package com.engineering.basics.executors.barrier;

import java.util.concurrent.CyclicBarrier;

public class cyclicBarrierExample {
    static void main() {
        int numberOfSubSystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubSystems, () -> {
            System.out.println("All subsystems have been initialized, System start up is completed. ");
        });

        Thread webserver = new Thread(new SubSystem("webserver", 2000, barrier));
        Thread cacheService = new Thread(new SubSystem("cacheService", 4000, barrier));
        Thread database = new Thread(new SubSystem("database", 3000, barrier));
        Thread messagingService = new Thread(new SubSystem("messagingService", 4000, barrier));

        webserver.start();
        cacheService.start();
        database.start();
        messagingService.start();

        System.out.println("In Cyclic Barrier Main thread will not wait for all subsystems to initialize...");
    }
}

class SubSystem implements Runnable{

   private final String name ;
   private final int initializationTime;
   private final CyclicBarrier barrier;

   public SubSystem(String name, int initializationTime, CyclicBarrier barrier){
    this.name = name;
    this.initializationTime = initializationTime;
    this.barrier = barrier;
   }

    @Override
    public void run() {
        try {
            System.out.println(name + " is initializing...");
            Thread.sleep(initializationTime); // Simulate time taken for initialization
            System.out.println(name + " has finished initialization.");

            barrier.await();
            // this will block the thread until all parties have called await() on the barrier.
            // Once all threads have reached this point, they will be released to continue execution.
            // once final thread calls await() on the barrier, all threads will be released to continue execution.
            // last thread will execute the barrier action, which is the Runnable provided in the CyclicBarrier constructor.

        } catch (Exception e) {
            System.out.println(name + " encountered an error during initialization: " + e.getMessage());
        }
    }
}
