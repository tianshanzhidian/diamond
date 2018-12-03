package com.alibaba.modle.biz.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.modle.biz.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws ParseException {
//        Long s = 1542965662L;
//        Date date = new Date(s);
//        System.out.println(simpleDateFormat.format(date));
//
//        String time = "2018-12-25 11:11:11";
//        Date date1 = simpleDateFormat.parse(time);
        try{
            Person p = null;
            if(p.getName()!=null){
                System.out.println("hello");
            }
        }catch(Throwable e){
            System.out.println(JSON.toJSONString(e));
        }


    }
}
