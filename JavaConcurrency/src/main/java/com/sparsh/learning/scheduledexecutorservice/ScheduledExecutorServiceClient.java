package com.sparsh.learning.scheduledexecutorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.sparsh.learning.callable.CallableTask;
import com.sparsh.learning.runnable.Runner;

/**
 * @author prashant.swamy
 *
 */
public class ScheduledExecutorServiceClient {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        scheduleCallable();

        scheduleRunnable();

        scheduleAtFixedRate();

        scheduleWithFixedDelay();
    }

    private static void scheduleCallable() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture<String> scheduledFuture =
                scheduledExecutorService.schedule(new CallableTask("Scheduled Task"), 1, TimeUnit.SECONDS);

        try {
            System.out.println("result = " + scheduledFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();
    }

    private static void scheduleRunnable() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ScheduledFuture<Object> scheduledFuture =
                (ScheduledFuture<Object>) scheduledExecutorService.schedule(new Runner(), 1, TimeUnit.SECONDS);

        try {
            if (scheduledFuture.get() != null) {
                System.out.println("Runner not executed, there is some problem.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }

    private static void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        scheduledExecutorService.scheduleAtFixedRate(new Runner(), 1, 2, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }

    private static void scheduleWithFixedDelay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleWithFixedDelay(new Runner(), 1, 2, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();
    }

}
