package com.alibaba.modle.biz.socket;

import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    private String serverIp;

    private int port;

    private Socket socket;

    private boolean running = false;

    public Client(String serverIp,int port){
        this.port=port;
        this.serverIp = serverIp;
    }

    public void satrt(){
        try{
            socket = new Socket(serverIp,port);
            running = true;
            //保持长连接的线程，每隔2秒项服务器发送文件内容
            new Thread(new LogFilesProcessThread(socket.getOutputStream())).start();
//            new Thread(new ReceiveWatchDog()).start();
        }catch(Exception e){

        }
    }

    class LogFilesProcessThread implements Runnable{


        private OutputStream outputStream;

        public LogFilesProcessThread(OutputStream outputStream) {
            this.outputStream = outputStream;
        }
        @Override
        public void run() {

                try {
                    String str = "caiyang=10|xianliu=20";
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    Thread.sleep(50000);
                } catch (Exception e) {

                }

        }
    }
}
