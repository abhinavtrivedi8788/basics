package com.engineering.basics.executors.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    static void main() throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            executorService.submit(new DependentExecution(latch));
        }

        // Wait for all tasks to complete before proceeding with the main thread
        // await() will block the main thread until the count of the latch reaches zero,
        // which means all tasks have completed their execution and called countDown().
        // Once the latch count reaches zero, the main thread will proceed to print the message and shut down the executor service.
        latch.await();

        // latch.await(5, TimeUnit.SECONDS);
        // This will wait for a maximum of 5 seconds for the latch to reach zero. If the latch does not reach zero within the specified time,
        // it will return false and the main thread will proceed.


        System.out.println("Main Thread will wait until all all tasks complete then only main thread will start it's execution . Shutting down executor service.");
        executorService.shutdown();
    }
    
}

class DependentExecution implements Callable<String>{

    private final CountDownLatch latch;

    public DependentExecution(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try{
            System.out.println("Task started: " + Thread.currentThread().getName());
            Thread.sleep(2000); // Simulate some work
            return "Task completed: " + Thread.currentThread().getName();
        } finally {
            latch.countDown(); // Decrement the count of the latch
        }
    }
}
