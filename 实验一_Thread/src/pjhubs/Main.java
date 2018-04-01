package pjhubs;

import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) throws Exception {
        while(true) {
            Thread.sleep(2000);
            Logger logger  =  Logger.getLogger(Main. class );
            logger.info("当前JVM已经从操作系统拿到的内存大小:"
                    + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        }
    }
}
