/**
 * 
 */
package com.sparsh.learning.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author prashant.swamy
 *
 */
public class ThreadPoolExecutorClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 50 Tasks will be there in a blocking queue. After that Tasks will be rejected.
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(3);

        ThreadPoolExecutor threadPoolExecutor = new MyCustomThreadPoolExecutor(2, 5, 5000, TimeUnit.MILLISECONDS, blockingQueue);
        threadPoolExecutor.setRejectedExecutionHandler(new MyCustomRejectedExecutionHandler());

        // Let start all core threads initially
        threadPoolExecutor.prestartCoreThread();

        for (int i = 1; i <= 20; i++) {
            System.out.println("Adding DemoTask: " + i);
            threadPoolExecutor.execute(new DemoTask(String.valueOf(i)));
        }

        MonitorThread monitorThread = new MonitorThread(threadPoolExecutor, 2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();

        monitorThread.shutdown();

    }
}
