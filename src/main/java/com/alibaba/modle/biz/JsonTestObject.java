package com.alibaba.modle.biz;

import java.io.Serializable;

public class JsonTestObject implements Serializable {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
