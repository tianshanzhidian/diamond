package com.alibaba.modle.biz;

import java.util.Date;

public class Person {
    private  String name;
    private String age;
    private Date date;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object object) {
        if(object == this){
            return true;
        }
        if(!(object instanceof Person)){
            return false;
        }
        Person p = (Person)object;
        if(id == p.getId()){
            return true;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        int result = 17;
//        result += 31 * province.hashCode();
//        result += 31 * city.hashCode();
//        return result;
//    }
}
