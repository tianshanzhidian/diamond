package com.alibaba.modle.biz.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.modle.biz.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastJsonTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("hello");
        p.setAge("11");
        p.setDate(new Date());
        Person p1 = new Person();
        p1.setName("hello1");
        p1.setAge("111");
        p1.setDate(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);


        String jsonString = JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);

        System.out.println(jsonString);


    }
}
