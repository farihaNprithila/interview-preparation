package org.fariha.thread.jointhreads.counter;

class CounterThread extends Thread {
    private String threadName;

    public CounterThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " counted: " + i);
            try {
                // Simulate some work with a small delay
                Thread.sleep(500); // Sleep for 500ms to see the output clearly
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
    }
}

public class ThreadJoinExampleWithCounter {
    public static void main(String[] args) throws InterruptedException {
        // Create two threads
        CounterThread thread1 = new CounterThread("Thread 1");
        CounterThread thread2 = new CounterThread("Thread 2");

        // Start the first thread
        thread1.start();
        
        // Wait for thread1 to finish before starting thread2
        thread1.join(); // Main thread waits for thread1 to finish

        // Start the second thread after thread1 finishes
        thread2.start();
        
        // Wait for thread2 to finish before the main thread continues
        thread2.join(); // Main thread waits for thread2 to finish

        System.out.println("Both threads have finished counting.");
    }
}
