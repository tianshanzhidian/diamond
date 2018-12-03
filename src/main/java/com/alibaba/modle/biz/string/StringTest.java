package com.alibaba.modle.biz.string;

/*
* 字符串解析小坑
* **/

import com.alibaba.modle.biz.Person;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Date;
import java.util.Random;

public class StringTest {


    private static String spit = "\\|";

    public static void main(String[] args) {
//        String s1 = "a1|true";
//        String[] strs = s1.split(spit);
//
//        for(String s : strs){
//            System.out.println(s);
//        }
//        String s2= strs[0]+spit+strs[1];
//        System.out.println(s2);
//
//        System.out.println(Boolean.TRUE.toString());


//        Date now = new Date();
//
//        for(int i=0;i<100;i++){
//            System.out.println(i);
//        }
//        Date now1 = new Date();
//
//        System.out.println(now1.getTime()-now.getTime());

        Math.random();

        Random rand =new Random(3);
        for(int i=0;i<100;i++){
            System.out.println(rand.nextInt(3));
        }


    }
}
