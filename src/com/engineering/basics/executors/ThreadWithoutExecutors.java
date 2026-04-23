package com.engineering.basics.executors;


public class ThreadWithoutExecutors {

    public int factorial(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    static void main() {
        long startTime = System.currentTimeMillis();
        Thread [] threadArray = new Thread[9];
        ThreadWithoutExecutors object= new ThreadWithoutExecutors();
        for(int i = 1; i<10; i++) {
                int finalI = i;
            threadArray[i-1] = new Thread(() -> {
                    int result = object.factorial(finalI);
                    System.out.println("Factorial of " + finalI + " is: " + result);
                });
            threadArray[i-1].start();
        }

        for(Thread t : threadArray){
            try {
                t.join(); // Wait for all threads to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to calculate factorial: " + (endTime - startTime) + " milliseconds");

    }
}
