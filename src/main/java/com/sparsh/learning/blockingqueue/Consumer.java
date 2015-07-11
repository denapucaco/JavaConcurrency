package com.sparsh.learning.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author prashant.swamy
 *
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());

            System.out.println(blockingQueue.take());

            System.out.println(blockingQueue.take());

            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
