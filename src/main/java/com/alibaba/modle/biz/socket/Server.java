package com.alibaba.modle.biz.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    ServerSocket serverSocket = null;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("服务端启动中");
        try{
            while(true){
                Socket socket = serverSocket.accept();
                OutputStream outputStream = socket.getOutputStream();
                InputStream is=socket.getInputStream();
                int len = 0;
                byte[] buf = new byte[1024];
                while((len = is.read(buf))!=-1){
                    System.out.println("服务端接收到的数据："+new String(buf,0,len));
                }
            }
        }catch(Exception e){

        }

    }


}
