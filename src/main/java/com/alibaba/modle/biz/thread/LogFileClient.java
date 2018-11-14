package com.alibaba.modle.biz.thread;

import com.alibaba.modle.biz.Person;

import java.util.concurrent.LinkedBlockingQueue;

public class LogFileClient {

    public static LinkedBlockingQueue<Person> TO_SEND_DATA;

    private static int maxQueueSize = 20;

    static{
        //起单独的线程去处理操作记录
        TO_SEND_DATA = new LinkedBlockingQueue<Person>(maxQueueSize);
        startSender(new LogFileSender(TO_SEND_DATA));
    }

    private static void startSender(LogFileSender logFileSender) {
        Thread thread = new Thread(logFileSender);
        thread.setDaemon(true);
        thread.setName("trace_thread");
        thread.start();
    }

    public static void put(Person p){
        boolean flag = TO_SEND_DATA.offer(p);
        if (!flag) {
            System.out.println("TO_SEND_DATA max, throw trace data"+TO_SEND_DATA.size());
        }
    }
}
