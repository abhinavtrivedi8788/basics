package com.engineering.basics.executors.countdownlatch;

import java.util.concurrent.*;

public class WithOutCountDownLatchExample {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future_task_1 = executorService.submit(new DependentTask());
        Future<Integer> future_task_2 = executorService.submit(new DependentTask());
        Future<Integer> future_task_3 = executorService.submit(new DependentTask());

        // Main thread will wait for the results of the tasks to be available before proceeding
        System.out.println("Result from task 1: " + future_task_1.get());
        System.out.println("Result from task 2: " + future_task_2.get());
        System.out.println("Result from task 3: " + future_task_3.get());

        System.out.println("All tasks completed. Shutting down executor service.");
        executorService.shutdown();

    }
}

class DependentTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Task started: " + Thread.currentThread().getName());
        Thread.sleep(2000); // Simulate some work
        return 42; // Return some result
    }
}
