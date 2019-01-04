package com.alibaba.modle.biz.socket;

public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1",1111);

        client.satrt();
    }
}
