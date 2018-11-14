package com.alibaba.modle.biz.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.modle.biz.Person;

import java.util.concurrent.LinkedBlockingQueue;

public class LogFileSender implements Runnable {

    private LinkedBlockingQueue<Person> queue;

    private boolean running;
    public LogFileSender(LinkedBlockingQueue<Person> queue){
        this.queue = queue;
        this.running = true;
    }
    public void run() {
        while(running){
            try {
                Person p = queue.take();
                System.out.println(queue.size());
                System.out.println(LogFileClient.TO_SEND_DATA.size());
                System.out.println(JSON.toJSONString(p));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
