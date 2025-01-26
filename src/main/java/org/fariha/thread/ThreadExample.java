package org.fariha.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task is running...");
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running via Runnable interface...");
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(1000);  // Simulating some work
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                break;
            }
        }
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(); // Creating a thread
        thread1.start(); // Starting the thread

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable); // Creating a thread and passing the runnable instance
        thread2.start(); // Starting the thread

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());

        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread runnableThread = new Thread(myRunnable2);
        runnableThread.start();

        // Interrupt the thread after 5 seconds
        try {
            Thread.sleep(100);
            runnableThread.interrupt(); // Interrupt the thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);  // Creating a thread pool with 2 threads

        executor.submit(new MyTask());
        executor.submit(new MyTask());

        executor.shutdown();  // Initiates an orderly shutdown of the ExecutorService
    }
}
