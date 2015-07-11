/**
 * 
 */
package com.sparsh.learning.threadpool;

/**
 * @author prashant.swamy
 *
 */
public class DemoTask implements Runnable {

    private String name;

    public DemoTask(final String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
