/*
package org.fariha.thread;// ThreadExample.java
import java.util.concurrent.*;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running!");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running using Runnable!");
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

public class ThreadExampleAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example 1: Creating a thread by extending the Thread class
        MyThread thread1 = new MyThread();
        thread1.start(); // Start the thread, which calls run() internally
        
        // Example 2: Creating a thread by implementing the Runnable interface
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start(); // Start the thread

        // Example 3: Thread Sleep and Join
        MyThread thread3 = new MyThread();
        thread3.start();
        thread3.join(); // Main thread will wait until thread3 finishes
        System.out.println("Main thread finishes execution.");
        
        // Example 4: Synchronization with multiple threads
        Counter counter = new Counter();
        
        // Create two threads that increment the counter
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        thread4.start();
        thread5.start();
        
        thread4.join();
        thread5.join();
        
        System.out.println("Final counter value: " + counter.getCount());

        // Example 5: Using ExecutorService (Thread Pool)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Runnable task1 = () -> System.out.println("Task 1 is running");
        Runnable task2 = () -> System.out.println("Task 2 is running");
        
        executor.submit(task1);
        executor.submit(task2);
        
        executor.shutdown(); // Shutting down the executor
    }
}
*/
