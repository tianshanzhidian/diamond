package com.alibaba.modle.biz.socket;

import java.io.*;
import java.net.Socket;

public class SocketClientTest {
    private static final String HOST="127.0.0.1";
    private static final int PORT = 5209;

    private static void test(){
        try {
            Thread.currentThread().setName("SocketClientTest");
            Socket socket = new Socket(HOST,PORT);
//            DataInputStream dis = new DataInputStream(socket.getInputStream());
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            OutputStream outputStream = socket.getOutputStream();
            InputStream ins = socket.getInputStream();
            int len =0;
            byte[] buf = new byte[1024];
            while (true){
//                dataOutputStream.writeUTF("hahaha");
//                dataOutputStream.flush();
                outputStream.write("hahaha".getBytes());
                outputStream.flush();
                System.out.println("11111");
                while((len = ins.read(buf))!=-1){
                    System.out.println("receive_msg:"+new String(buf,0,len));

                }
//                System.out.println("receive_msg:"+dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
