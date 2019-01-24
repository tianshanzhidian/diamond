package com.alibaba.modle.biz.bytetest;

public class ByteTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[1];
        bytes[0] = boolean2bytes(true);
        System.out.println(byte2boolean(bytes,0));

    }

    public static byte boolean2bytes(boolean v) {
        return (byte) (v ? 1 : 0);
    }

    public static boolean byte2boolean(byte[] bytes, int off) {
        return bytes[off] == 1 ? true : false;
    }
}
