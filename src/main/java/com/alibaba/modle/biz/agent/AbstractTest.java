package com.alibaba.modle.biz.agent;

import com.alibaba.modle.biz.Person;

import java.util.List;

public abstract class AbstractTest {
    public abstract void getDemo(Person p);

    public  void getDemo1(List<Person> persons){
        for(Person p : persons){
            System.out.println("lelelellelel");
        }

    }
}
