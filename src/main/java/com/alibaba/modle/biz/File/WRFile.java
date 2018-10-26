package com.alibaba.modle.biz.File;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.modle.biz.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 文件操作类
 *
 * **/
public class WRFile {

    public static void read(File file) throws IOException {
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }
        br.close();
        fr.close();
    }

    public static void write(List<Person> persons){
        BufferedWriter bufferedWriter = null;
        File file = new File("src/main/resources/1.txt");
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            for(Person p: persons){
                bufferedWriter.write(JSONObject.toJSONString(p)+"\r\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
//        File file = new File("src/main/resources/1.txt");
//        try {
//            read(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Person> peoples =new ArrayList<Person>();

        for(int i=0;i<40000000;i++){
            Person p = new Person();
            p.setName("hello"+i);
            p.setName(String.valueOf(i));
            peoples.add(p);
        }
        write(peoples);
    }
}
