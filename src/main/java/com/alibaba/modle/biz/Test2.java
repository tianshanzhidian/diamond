package com.alibaba.modle.biz;

import com.alibaba.modle.staticField.TraceClient;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        TraceClient.strace("hello trace2");
        Thread.sleep(2000);
    }
}
