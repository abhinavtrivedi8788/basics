package com.engineering.basics.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int counter = 0;

    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    private static Lock readLock = lock.readLock();
    private static Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Acquired write lock, incrementing value :" + counter);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Acquired read lock, reading value");
        } finally {
            readLock.unlock();
        }
        return counter;
    }

    static void main() {
        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Read counter value: " + example.getCounter());
            }
        };

        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
                System.out.println(Thread.currentThread().getName() + " Write counter value: " + example.getCounter());
            }
        };

        Thread writerThread = new Thread(writeTask, "WriterThread");
        Thread readerThread1 = new Thread(readTask, "ReaderThread-1");
        Thread readerThread2 = new Thread(readTask, "ReaderThread-2");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();
    }
}
