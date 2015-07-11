/**
 * 
 */
package com.sparsh.learning.callable;

import java.util.concurrent.Callable;

/**
 * @author prashant.swamy
 *
 */
public class CallableTask implements Callable<String> {

    private String taskName;

    public CallableTask(final String taskName) {
        this.taskName = taskName;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // System.out.println("Inside the call method of callable.");
        return "callable task " + taskName + " run at " + System.currentTimeMillis();
    }
}
