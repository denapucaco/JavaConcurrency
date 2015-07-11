/**
 * 
 */
package com.sparsh.learning.runnable;

/**
 * @author prashant.swamy
 *
 */
public class Runner implements Runnable {

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }

}
