package com.alibaba.modle.biz;

public class ThreadLocalDemo {
    private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    private void fun1() {
        threadLocal.set(System.nanoTime());
        System.out.println("fun1:" + threadLocal.get());
        fun2();
    }

    private void fun2() {
        System.out.println("fun2:" + threadLocal.get());
        fun3();
    }

    private void fun3() {
        System.out.println("fun3:" + threadLocal.get());
        threadLocal.remove();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.fun1();
    }
}
