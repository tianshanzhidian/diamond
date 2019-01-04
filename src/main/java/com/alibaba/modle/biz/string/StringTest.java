package com.alibaba.modle.biz.string;

/*
* 字符串解析小坑
* **/

import com.alibaba.fastjson.JSON;
import com.alibaba.modle.biz.Person;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

//        Math.random();
//
//        Random rand =new Random(3);
//        for(int i=0;i<100;i++){
//            System.out.println(rand.nextInt(3));
//        }
//        String s = "\r\n";
//        System.out.println(s.getBytes().length);

//        StringBuilder s = new StringBuilder();
//        if(StringUtils.isNotBlank(s.toString())){
//            System.out.println("hhaha");
//        }


//        StringBuilder s = new StringBuilder();
//        s.append(" ").append("|").append(" ").append("|").append(" ").append("|");
//        System.out.println(s.toString().split(spit).length);

//        String s1 = "null";
//        System.out.println(s1 == null);
        Person p = new Person();
        p.setId(1);
        Person p1 = new Person();
        p1.setId(1);
        Person p2 = new Person();
        p2.setId(1);

        Object[] objects = new Object[]{p,p1,p2};

        List<Object> personList = Arrays.asList(objects);

        for(Object person : personList){
            Person p4 = (Person) person;
            System.out.println(p4.getId());
        }


    }
}
