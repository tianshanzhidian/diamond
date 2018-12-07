package com.alibaba.modle.biz.agent;

import com.alibaba.modle.biz.Person;

public class App2 {

    public static void main(String[] args) {
        hello();
    }
    public static Person hello() {
        Person person  = new Person();
        System.out.println("this is App2 agent-demo output");
        return person;
    }
}
