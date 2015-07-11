/**
 * 
 */
package com.sparsh.learning.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author prashant.swamy
 *
 */
public class RunnerExecutor {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Runner runner = new Runner();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 1st way, execute does not return anything (void)
        executorService.execute(runner);

        // 2nd way, submit returns Future
        Future future = executorService.submit(runner);

        try {
            Object object = future.get();
            if (object == null) {
                System.out.println("Runner executed successfully.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
