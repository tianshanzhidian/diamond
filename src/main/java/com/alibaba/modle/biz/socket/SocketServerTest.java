package com.alibaba.modle.biz.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    private static final int PORT = 5209;

    public static void test(){
        try {
            Thread.currentThread().setName("SocketServerTest");
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            int len =0;
            byte[] buf =new byte[1024];
            while(true){
//                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                OutputStream outputStream =socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();
//                System.out.println("receive_msg:"+dataInputStream.readUTF());
                while((len=inputStream.read(buf)) !=-1){
                    System.out.println("receive_msg:"+new String(buf,0,len));
                }

//                Thread.sleep(1000);
//                dataOutputStream.writeUTF("hello");
////                dataOutputStream.flush();
                System.out.println("22222");
                outputStream.write("hello".getBytes());
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        test();
    }
}
