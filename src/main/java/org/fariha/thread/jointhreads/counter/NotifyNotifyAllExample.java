package org.fariha.thread.jointhreads.counter;

class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }
}

class Worker extends Thread {
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            try {
                while (counter.getCounter() < 10) {
                    System.out.println(Thread.currentThread().getName() + " is waiting. Counter: " + counter.getCounter());
                    counter.wait(); // Worker thread waits for notification
                }

                // After the counter is 10, perform the work
                System.out.println(Thread.currentThread().getName() + " is working with Counter: " + counter.getCounter());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Notifier extends Thread {
    private Counter counter;

    public Notifier(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 1; i <= 10; i++) {
                counter.increment();
                System.out.println("Notifier incremented counter to: " + counter.getCounter());

                // Notify all threads that are waiting on counter
                counter.notifyAll();

                try {
                    Thread.sleep(500); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class NotifyNotifyAllExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create worker threads
        Thread worker1 = new Worker(counter);
        Thread worker2 = new Worker(counter);

        // Create notifier thread
        Thread notifier = new Notifier(counter);

        // Start the threads
        worker1.start();
        worker2.start();
        notifier.start();
    }
}
