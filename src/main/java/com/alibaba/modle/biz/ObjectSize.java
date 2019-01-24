package com.alibaba.modle.biz;

import java.io.*;
import java.lang.instrument.Instrumentation;
import java.util.Date;

public class ObjectSize {

    private String filePath = getlogsPath() + "fasttrace.log";;
    private long lastFileSuffix = 0;
    private BufferedOutputStream bos = null;
    private final int bufferSize = 4*1024;
    private static final int DEFAULT_BUFFER_SIZE = 4 * 1024;
    private boolean multiProcessDetected = false;

    static private final String getlogsPath() {
        return "/opt/pamirs/logs/fasttrace"+ File.separator;
    }

    private void setFile() {
        try {
            File logFile = new File(filePath + '.' + lastFileSuffix);
            if (!logFile.exists()) {
                File parentFile = logFile.getParentFile();
                if (!parentFile.exists() && !parentFile.mkdirs()) {

                    return;
                }
                try {
                    if (!logFile.createNewFile()) {

                    }
                } catch (IOException e) {

                }
            }
            FileOutputStream ostream = new FileOutputStream(logFile, true); // 必须 true 保证 O_APPEND
            this.bos = new BufferedOutputStream(ostream, bufferSize);
        } catch (Throwable e) {

        }
    }

    public void append(String log) {
        BufferedOutputStream bos = this.bos;
        if (bos != null) {
            try {


                byte[] bytes = log.getBytes("utf-8");
                int len = bytes.length;
                if (len > DEFAULT_BUFFER_SIZE && this.multiProcessDetected) {
                    len = DEFAULT_BUFFER_SIZE;
                    bytes[len - 1] = '\n';
                }
                bos.write(bytes, 0, len);
                bos.flush();
            } catch (Exception e) {
                close();
                setFile();
            }
        }
    }
        public void close() {
            BufferedOutputStream bos = this.bos;
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {

                }
                this.bos = null;
            }
        }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ObjectSize objectSize = new ObjectSize();
        objectSize.setFile();

        String log = "15470217654560000000001|9|fastdata|1547021765456|[0, 102]|com.pamirs.data.AbstractCanalClient|cleanData|192.168.1.240|null|null|null|32|CleanDataInfo[current={id=1,gmt_created=Date[],gmt_modified=Date[],name=1111123,age=28,creator=system,modifier=system},schema=mysql,table=luolei_test,businessId=id:1]|0||";
        for(int i=0;i<100;i++){
            objectSize.append(log);
        }

    }
}
