package org.fariha.thread.jointhreads;

class Message {
    private String message;
    private boolean flag = false;

    public synchronized void writeMessage(String message) {
        while (flag) {
            try {
                wait(); // Wait until the message is read
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        flag = true;
        notify(); // Notify that the message has been written
    }

    public synchronized void readMessage() {
        while (!flag) {
            try {
                wait(); // Wait until a message is written
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reading Message: " + message);
        flag = false;
        notify(); // Notify that the message has been read
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Message message = new Message();

        Thread writer = new Thread(() -> {
            message.writeMessage("Hello from writer!");
        });

        Thread reader = new Thread(() -> {
            message.readMessage();
        });

        writer.start();
        reader.start();
    }
}
