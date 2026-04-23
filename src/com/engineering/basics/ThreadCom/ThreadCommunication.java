package com.engineering.basics.ThreadCom;

class SharedResource {
    private int data;
    private boolean isProduced ;

    public synchronized void produce(int input) {
        while (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = input;
        isProduced = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized void consume() {
        while (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isProduced = false;
        System.out.println("Consumed: " + data);
        notify();
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
        }
    }
}

class consumer implements Runnable {
    private SharedResource resource;

    public consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.consume();
        }
    }
}


public class ThreadCommunication {

    static void main() {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
