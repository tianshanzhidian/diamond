package com.alibaba.modle.biz.process;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Process1 extends Thread{

    private String mFileName;
    private FileChannel fileChannel;
    private MappedByteBuffer mappedByteBuffer;

    public Process1(String mFileName) {
        this.mFileName = mFileName;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(mFileName,"r");
            fileChannel = randomAccessFile.getChannel();
            long size = fileChannel.size();
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,size).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(300);
                FileLock lock = null;
                lock = fileChannel.tryLock(0,10,true);
                if(lock == null){
                    System.err.println("Process1: lock failed");
                    continue;
                }
                System.out.println("Consumer: "+mappedByteBuffer.getInt(0)+":"+mappedByteBuffer.getInt(1)+":"+mappedByteBuffer.getInt(2));
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Process1 process1 = new Process1("src/main/resources/1.txt");
        process1.start();
//        System.out.println("this is process1 ");
//        Thread.sleep(20000);
    }
}
