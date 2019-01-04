package com.alibaba.modle.biz.process;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Process2 extends Thread{
    private String mFileName;
    private FileChannel fileChannel;
    private MappedByteBuffer mappedByteBuffer;

    public Process2(String mFileName){
        this.mFileName = mFileName;
        try {
            RandomAccessFile RAFile=new RandomAccessFile(mFileName,"rw");
            fileChannel = RAFile.getChannel();
            long size=fileChannel.size();
            mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,size).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){

        int i = 0;

            FileLock lock = null;
            try {
                lock = fileChannel.tryLock();
                if(lock==null)
                {
                    System.err.println("Process2: lock failed");
                }
                mappedByteBuffer.putInt(0,5);
                mappedByteBuffer.putInt(1,6);
                mappedByteBuffer.putInt(2,7);
                mappedByteBuffer.force();
                System.out.println("Producer: "+(i-3)+":"+(i-2)+":"+(i-1));
                Thread.sleep(200);
                lock.release();
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    public static void main(String[] args) throws InterruptedException {
        Process2 process2 = new Process2("src/main/resources/1.txt");
        process2.start();
    }
}
