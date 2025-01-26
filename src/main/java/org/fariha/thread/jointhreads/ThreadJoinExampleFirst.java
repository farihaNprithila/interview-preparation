package org.fariha.thread.jointhreads;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread finished execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadJoinExampleFirst {
    public static void main(String[] args) throws InterruptedException {
     /*   MyThread thread1 = new MyThread();
        thread1.start();
        
        try {
            thread1.join(); // Main thread will wait for thread1 to finish
            System.out.println("Main thread resumed after thread1 completed.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();

        thread.start();
        thread2.start();

        System.out.println("Is thread alive? " + thread.isAlive());

        thread.join(); // Wait for thread to finish

        System.out.println("Is thread alive? " + thread.isAlive());
    }
}
