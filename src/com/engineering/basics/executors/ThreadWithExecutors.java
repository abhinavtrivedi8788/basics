package com.engineering.basics.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadWithExecutors {

    public int factorial(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    static void main() {
        long startTime = System.currentTimeMillis();
        ThreadWithoutExecutors customObject= new ThreadWithoutExecutors();
        // ExecutorService is a higher level replacement for working with threads directly.
        // It provides a way to manage a pool of threads and allows you to submit tasks for execution
        // without having to worry about thread creation and management.
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 1; i<10; i++) {
            int finalI = i;
            executorService.submit(()-> {;
                int result = customObject.factorial(finalI);
                System.out.println("Factorial of " + finalI + " is: " + result);
            });
        }
        executorService.shutdown(); // This will not wait for the tasks to complete,
        // it will just prevent new tasks from being submitted. The already submitted tasks will continue to execute until they are finished.

        try {
            // This will wait for the executor service to terminate,
            // which means it will wait for all tasks to complete or for the specified timeout to elapse, whichever happens first.
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to calculate factorial: " + (endTime - startTime) + " milliseconds");

    }
}
