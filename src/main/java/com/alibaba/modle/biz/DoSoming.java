package com.alibaba.modle.biz;

public class DoSoming {

    public void DoThing(){
        Person p = ThreadLocals.get();
        System.out.println(p.getName());
    }
}
