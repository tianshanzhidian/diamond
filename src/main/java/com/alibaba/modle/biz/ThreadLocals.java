package com.alibaba.modle.biz;

public class ThreadLocals {

    private ThreadLocals(){

    }

    private static final ThreadLocal<Person> LOCAL = new ThreadLocal<Person>();

    public static void set(Person p){
        LOCAL.set(p);
    }

    public static Person get(){
        return LOCAL.get();
    }
}
