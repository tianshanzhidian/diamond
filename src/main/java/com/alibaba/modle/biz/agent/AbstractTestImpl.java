package com.alibaba.modle.biz.agent;

import com.alibaba.modle.biz.Person;

public class AbstractTestImpl extends AbstractTest {
    @Override
    public void getDemo(Person p) {
        System.out.println("hahahhahahah");
        System.out.println(p.getName());
    }
}
