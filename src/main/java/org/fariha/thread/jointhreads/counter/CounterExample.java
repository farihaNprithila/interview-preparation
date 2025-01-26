package org.fariha.thread.jointhreads.counter;

public class CounterExample {

    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread thread1 = new Thread(counter, "Worker 1");
        Thread thread2 = new Thread(counter, "Worker 2");
        Thread thread3 = new Thread(counter, "Worker 3");

        // Start both threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
    }
}

class Counter2 implements Runnable {

    private int count = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (count <= 10) {
                System.out.println(Thread.currentThread().getName() + " printed: " + count);
                count++;

                // Notify the other thread to continue
                notify();

                // If the count is not 10, the current thread waits
                if (count <= 10) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
