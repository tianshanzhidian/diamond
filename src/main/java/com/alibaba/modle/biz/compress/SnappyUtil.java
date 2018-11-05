package com.alibaba.modle.biz.compress;


import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SnappyUtil {

    public static byte[] compressedByte(String str) {
        try {
            return Snappy.compress(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {

           return null;
        }
    }

    public static String decompress(byte[] bytes){
        try {
            return new String(Snappy.uncompress(bytes));
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String s="hello,i am a girl!";
        byte[] bytes = compressedByte(s);
        System.out.println(new String(decompress(bytes)));
    }
}
