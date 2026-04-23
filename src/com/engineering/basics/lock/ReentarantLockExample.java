package com.engineering.basics.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentarantLockExample {

    // To avoid Deadlock situation we can use ReentrantLock which allows the same thread
    // to acquire the lock multiple times without causing a deadlock.

    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ " Executing outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +" Executing Inner method");
        } finally {
            lock.unlock();
        }
    }

     static void main() {
        ReentarantLockExample example = new ReentarantLockExample();
        example.outerMethod();

        Runnable r = example::outerMethod; // way of creating runnable using method reference
        Thread t1 = new Thread(r,"Thread-1");
        Thread t2 = new Thread(r,"Thread-2");

        t1.start();
        t2.start();
    }
}
