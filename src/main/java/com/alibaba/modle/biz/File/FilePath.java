package com.alibaba.modle.biz.File;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.lang.management.ManagementFactory;

public class FilePath {
    static final String BASE_PRADAR_LOG_DIR = locatePradarLogPath();
    static final String BASE_LOG_DIR = locateBaseLogPath();
    static final String USER_HOME = locateUserHome();
    static final String APP_LOG_MULTI_DIR = locateMultiAppLogPath();
    public static void main(String[] args) throws InterruptedException {
        String PRADAR_RPC_LOG_FILE = APP_LOG_MULTI_DIR + "pradar.log";
//        String USER_HOME = locateUserHome();
        System.out.println(PRADAR_RPC_LOG_FILE);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        System.out.println("Pid is:"+pid);
//        Thread.sleep(20000);
    }
    static public final String locateMultiAppLogPath() {
        String appName = System.getProperty("pradar.project.name", "default");
        return BASE_PRADAR_LOG_DIR + Thread.currentThread().getId() + File.separator;
    }

    static private final String locatePradarLogPath() {
        String tmpPath = getSystemProperty("pradar.log.path");
        if (StringUtils.isNotBlank(tmpPath)) {
            if (!tmpPath.endsWith(File.separator)) {
                tmpPath += File.separator;
            }
        } else {
            tmpPath = BASE_LOG_DIR + "pradar" + File.separator;
        }
        return tmpPath;
    }

    static private final String getSystemProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            return null;
        }
    }

    static private final String locateBaseLogPath() {
        String tmpPath = getSystemProperty("pradar.log.base.path");
        if (StringUtils.isNotBlank(tmpPath)) {
            if (!tmpPath.endsWith(File.separator)) {
                tmpPath += File.separator;
            }
        } else {
            tmpPath = USER_HOME + "logs" + File.separator;
        }
        return tmpPath;
    }

    static private final String locateUserHome() {
        String userHome = getSystemProperty("user.home");
        if (StringUtils.isNotBlank(userHome)) {
            if (!userHome.endsWith(File.separator)) {
                userHome += File.separator;
            }
        } else {
            userHome = "/tmp/";
        }
        return userHome;
    }
}
