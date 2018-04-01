package pjhubs;

import org.apache.log4j.Logger;

public class ThreadClass implements Runnable {
    private Thread t;
    private String threadName;

    ThreadClass( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        while(true) {
            try {
                Thread.sleep(2000);
                Logger logger = Logger.getLogger(Main.class);
                logger.info("当前JVM已经从操作系统拿到的内存大小:"
                        + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
