package com.engineering.basics.executors;

import java.util.concurrent.*;

public class ScheduleExecuteExample {

    static void main() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(
                ()-> System.out.println("Task executed after 2 seconds"),
                2,
                2,
                TimeUnit.SECONDS
        );

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(
                () -> System.out.println("Task executed delay of 2 seconds"),
                2,
                2,
                TimeUnit.SECONDS
        );

        //scheduledExecutorService.shutdown();
        scheduledExecutorService.schedule(
                ()-> {
                    System.out.println("Initiating for Shutdown is executed in 10 seconds");
                    scheduledExecutorService.shutdown();
                },
                10,
                TimeUnit.SECONDS
        );
    }
}
