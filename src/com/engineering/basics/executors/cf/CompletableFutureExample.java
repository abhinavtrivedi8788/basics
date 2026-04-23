package com.engineering.basics.executors.cf;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    static void main() {

        // CompletableFuture allows you to write asynchronous, non-blocking code in a more readable and maintainable way.
        // By Default completableFuture tasks often runs on daemon threads due to use of ForkJoinPool.commonPool() for asynchronous execution,
        // which means they won't prevent the JVM from shutting down if the main thread finishes execution.

        // We can control the thread pool used by CompletableFuture by providing a custom Executor,
        // but if we don't, it will use the common pool which is shared across the application.

            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(2000); // Simulate a long-running task
                } catch (InterruptedException e) {
                    System.out.println("Task was interrupted: " + e.getMessage());
                }
                return "Hello, World!";
            });

            future.thenAccept(result -> {
                System.out.println("Result: " + result);
            });

            System.out.println("This will print before the result is available...");
            // Main thread can continue doing other work while the CompletableFuture is running asynchronously.
    }
}
