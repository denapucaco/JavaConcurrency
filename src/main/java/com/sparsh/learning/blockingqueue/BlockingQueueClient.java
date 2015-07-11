/**
 * 
 */
package com.sparsh.learning.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author prashant.swamy
 *
 */
public class BlockingQueueClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        Producer producer = new Producer(blockingQueue);

        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();

        new Thread(consumer).start();

    }

}
