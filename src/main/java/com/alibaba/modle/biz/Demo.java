package com.alibaba.modle.biz;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import com.alibaba.fastjson.JSON;

public class Demo {
    public static void main(String[] args) {
//        sayHello();
//        test();


//        Person p = new Person();
//        p.setAge("hello");
//        p.setName("haha");
//
//        ThreadLocals.set(p);
//
//        DoSoming doSoming = new DoSoming();
//
//        doSoming.DoThing();

        StaticTest.sayHello();
        Person person = new Person();

        person.setName("hello");
        person.setAge("12");



        JsonTestObject object = new JsonTestObject();
        object.setPerson(person);



        String str = JSON.toJSONString(object);

        System.out.println(str);


        JsonTestObject object1  = JSON.parseObject(str,JsonTestObject.class);
        System.out.println(object1.getPerson().getName());







    }

    private static void test() {
        String s = "hello";
        Integer.valueOf(s);
    }

    public static void sayHello(){
        try{
            String a = null;
            String b = "";
            System.out.println(a.equals(b));
        } catch(Exception e){
            System.out.println("hello");
            getStackTrace(e);
            System.out.println(JSON.toJSONString(e.getStackTrace()));
            System.out.println(getStackTrace(e));
//            e.printStackTrace();
        }

    }


    public static String getStackTrace(Throwable aThrowable) {
        Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }
}
