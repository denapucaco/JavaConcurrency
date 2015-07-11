/**
 * 
 */
package com.sparsh.learning.callable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author prashant.swamy
 *
 */
public class CallableExecutor {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\n\ngenerateCallableSubmit()");
        generateCallableSubmit();

        System.out.println("\n\ngenerateCallableInvokeAny()");
        generateCallableInvokeAny();

        System.out.println("\n\ngenerateCallableInvokeAll()");
        generateCallableInvokeAll();
    }

    private static void generateCallableSubmit() {
        CallableTask callableTask = new CallableTask("Task 1.");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> future = executorService.submit(callableTask);

        try {
            System.out.println("Returned from CallableTask.");
            String msg = future.get(); // it waits until Callable task gets finishes.
            System.out.println(msg);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void generateCallableInvokeAny() {

        CallableTask task1 = new CallableTask("Task 1");
        CallableTask task2 = new CallableTask("Task 2");
        CallableTask task3 = new CallableTask("Task 3");
        CallableTask task4 = new CallableTask("Task 4");

        Set<CallableTask> callableTasks = new HashSet<CallableTask>();
        callableTasks.add(task1);
        callableTasks.add(task2);
        callableTasks.add(task3);
        callableTasks.add(task4);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            String result = executorService.invokeAny(callableTasks);
            System.out.println("Result is " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void generateCallableInvokeAll() {

        CallableTask task1 = new CallableTask("Task 1");
        CallableTask task2 = new CallableTask("Task 2");
        CallableTask task3 = new CallableTask("Task 3");
        CallableTask task4 = new CallableTask("Task 4");

        Set<CallableTask> callableTasks = new HashSet<CallableTask>();

        callableTasks.add(task1);
        callableTasks.add(task2);
        callableTasks.add(task3);
        callableTasks.add(task4);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
