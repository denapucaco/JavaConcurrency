/**
 * 
 */
package com.sparsh.learning.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author prashant.swamy
 *
 */
public class Producer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    private int delay = 2000;

    public Producer(final BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        try {
            blockingQueue.put("Task 1");
            Thread.sleep(delay);

            blockingQueue.put("Task 2");
            Thread.sleep(delay);

            blockingQueue.put("Task 3");
            Thread.sleep(delay);

            blockingQueue.put("Task 4");
            Thread.sleep(delay);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
