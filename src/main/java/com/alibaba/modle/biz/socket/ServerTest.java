package com.alibaba.modle.biz.socket;

public class ServerTest {
    public static void main(String[] args) {
        Server server = new Server(9999);
        Thread thread = new Thread(server);
        thread.start();
    }
}
