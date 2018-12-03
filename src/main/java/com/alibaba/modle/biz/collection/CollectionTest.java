package com.alibaba.modle.biz.collection;

import com.alibaba.modle.biz.Person;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("hello");
//        list.add("hello1");
//        list.add("hello2");
//        list.add("hello3");
//
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        List<Person> set  = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setId(1);
        p1.setAge("name");
        Person p2 = new Person();
        p2.setId(1);
        p2.setAge("name1");
        set.add(p1);
        if(!set.contains(p2)){
            set.add(p2);
        }

        System.out.println(set.size());




    }
}
