package com.alibaba.modle.biz;

public class StaticTest {


    static{
        System.out.println("StaticTest init");
    }

    public StaticTest(){

    }

    public static void sayHello(){
        System.out.println("StaticTest sayHello");
    }
}
