package com.alibaba.modle.biz.agent;


import com.alibaba.modle.biz.Person;
import com.pamirs.data.cloud.sink.MessageEntity;
import com.pamirs.data.cloud.sink.rule.TableTask;
import com.pamirs.fast.trace.client.model.TraceInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class App1 {
    public static void main(String[] args) {
        Person p =new Person();
        p.setDate(new Date());
        p.setId(2);
        Person p1 =new Person();
        p1.setDate(new Date());
        p1.setId(2);
        List<Person> people = new ArrayList<>();
        people.add(p);
        people.add(p1);
        hello(p,null);
        hello1(p,"kitty");

        AbstractTest abstractTest = new AbstractTestImpl();

//        abstractTest.getDemo(p);
        for(int i =0 ;i<10000;i++){
            abstractTest.getDemo1(people);
        }


//        MsgModel msgModel = new MsgModel();
//        MessageEntity messageEntity = new MessageEntity();
//        messageEntity.setBusinessId("id:4");
//        messageEntity.setTable("luolei_test_job_detail");
//        messageEntity.setSchema("mysql");
//        TraceInfo traceInfo = new TraceInfo();
//        traceInfo.setBatchSeq(2);
//        traceInfo.setFireTimestamp(1546412889710L);
//        traceInfo.setRoute("1");
//        traceInfo.setTraceId("15464128896670000000005");
//        traceInfo.setTraceSeq(0);
//        messageEntity.setTraceInfo(traceInfo);
//        msgModel.setMessageEntity(messageEntity);
//        TableTask tableTask = new TableTask();
//        tableTask.setId("1");
//
//        msgModel.setTableTask(tableTask);
//        List<MsgModel> lists = new ArrayList<>();
//        lists.add(msgModel);
//
//
//        cleanData(lists);



    }

    public static boolean cleanData(List<MsgModel> lists) {
        System.out.println("cclean data");
        return true;
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
