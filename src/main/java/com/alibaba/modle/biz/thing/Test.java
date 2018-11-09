package com.alibaba.modle.biz.thing;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class Test {
    public static void main(String[] args) {
//        System.out.println(0&5);
        LineNumberReader lnr = null;
        try {
            lnr = new LineNumberReader(new FileReader(new File("src/main/resources/1.txt")));
            lnr.skip(Long.MAX_VALUE);
            System.out.println(lnr.getLineNumber()+1);
            lnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
