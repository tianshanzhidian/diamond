package com.alibaba.modle.biz.process;

import java.io.IOException;
/*
* 失败的案例
* **/
public class ProcessTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        Process p = run.exec("java Process1");
        run.exec("java Process2");
        Thread.sleep(100000);
    }
}
