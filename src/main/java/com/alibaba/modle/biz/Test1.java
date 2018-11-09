package com.alibaba.modle.biz;

import com.alibaba.modle.staticField.TraceClient;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        TraceClient.strace("hello trace");
        Thread.sleep(3000);
    }
}
