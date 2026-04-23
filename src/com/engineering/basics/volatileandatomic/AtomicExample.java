package com.engineering.basics.volatileandatomic;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    // By making the counter variable an AtomicInteger, we ensure that all operations on it are atomic and thread-safe.
    // which means that multiple threads can safely increment the counter without causing race conditions or
    // inconsistent results.

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}

public class AtomicExample {

    static void main() {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
