/**
 * 
 */
package com.sparsh.learning.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author prashant.swamy
 *
 */
public class MyCustomRejectedExecutionHandler implements RejectedExecutionHandler {

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.RejectedExecutionHandler#rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
     */
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        System.out.println(((DemoTask) runnable).getName() + " is Rejected.");
    }

}
