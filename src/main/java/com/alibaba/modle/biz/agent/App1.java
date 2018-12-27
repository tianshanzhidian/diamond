package com.alibaba.modle.biz.agent;

import com.alibaba.modle.biz.Person;

import java.util.Date;

public class App1 {
    public static void main(String[] args) {
        Person p =new Person();
        p.setDate(new Date());
        p.setId(2);
        hello(p,null);
        hello1(p,"kitty");
    }
    public static Person hello(Person p, String str) {

        Person person= new Person();
        person.setAge("12");
        person.setId(1);
        person.setName("hello");
        person.setDate(new Date());
        System.out.println("this is agent-demo output");
        return person;
    }
    public static Person hello1(Person p, String str) {

        Person person= new Person();
        person.setAge("12");
        person.setId(1);
        person.setName("hello1");
        person.setDate(new Date());
        System.out.println("this is hello1 output");
        return person;
    }
}
