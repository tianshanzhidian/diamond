package com.alibaba.modle.biz.string;

/*
* 字符串解析小坑
* **/

public class StringTest {


    private static String spit = "\\|";

    public static void main(String[] args) {
        String s1 = "a1|true";
        String[] strs = s1.split(spit);

        for(String s : strs){
            System.out.println(s);
        }
        String s2= strs[0]+spit+strs[1];
        System.out.println(s2);


    }
}
