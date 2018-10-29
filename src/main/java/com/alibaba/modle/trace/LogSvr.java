package com.alibaba.modle.trace;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模拟服务器端写日志
 *
 * */

public class LogSvr {

    private static final Logger logger = LoggerFactory.getLogger(LogSvr.class);

    private SimpleDateFormat  dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    private static ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    public void logMsg(File logFile,String msgInfo) throws IOException{

        if(!logFile.exists()) {
            logFile.createNewFile();
        }

        Writer txtWriter = new FileWriter(logFile,true);
        txtWriter.write(dateFormat.format(new Date()) + "\t" + msgInfo + "\n");
        txtWriter.flush();
        txtWriter.close();
    }

    public void stop(){
        if(exec != null){
            exec.shutdown();
            logger.info("file write stop ！");
        }
    }

    public static void main(String[] args) throws Exception {

        final LogSvr logSvr = new LogSvr();
        final File tmpLogFile = new File("src/main/resources/mock.log");
        final String msgInfo = "test !";

        //启动一个线程每5秒向日志文件写一次数据
        exec.scheduleWithFixedDelay(new Runnable(){
            public void run() {
                try {
                    logSvr.logMsg(tmpLogFile, msgInfo);
                    //Thread.sleep(1000);
                } catch (Exception e) {
                    logger.error("file write error ！");
                }
            }

        }, 0, 1, TimeUnit.MILLISECONDS);

    }

}
