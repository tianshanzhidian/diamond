package com.alibaba.modle.staticField;

public class TraceClient {
    static {
        System.out.println("TraceClient init success");
    }

    public static void strace(String message){
        System.out.println(message);
    }
}
