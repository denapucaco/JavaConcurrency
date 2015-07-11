/**
 * 
 */
package com.sparsh.learning.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author prashant.swamy
 *
 */
public class MonitorThread implements Runnable {

    private ThreadPoolExecutor executor;

    private int delay;

    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor executor, int dela) {
        this.executor = executor;
        this.delay = dela;
    }

    public void shutdown() {
        run = false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        while (run) {
            System.out.println(String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                    executor.getCorePoolSize(), executor.getMaximumPoolSize(), executor.getActiveCount(), executor.getCompletedTaskCount(),
                    executor.getTaskCount(), executor.isShutdown(), executor.isTerminated()));

            try {
                Thread.sleep(delay * 100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    };

}
