package com.alibaba.modle.biz.thread;

import com.alibaba.modle.biz.Person;

public class ThreadTest {
    final static long timeInterval = 1000;
    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();
//        p.setName("hello");
//        p.setAge("11");
//        LogFileClient.put(p);
//        Thread.sleep(20000);

//        Long id =null;
//        p.setId(id);
        Runnable runnable = new Runnable() {
            public void run() {
                while(true){
                    System.out.println("hello");
                    try{
//                        Thread.sleep(timeInterval);
                        Thread.yield();
                        System.out.println("sleep later");
                    }catch(Exception e){

                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();



        Thread thread1 = new Thread(new HeartBeatRunnable());

    }

    private static class HeartBeatRunnable implements Runnable {
        @Override
        public void run() {

        }
    }
}
