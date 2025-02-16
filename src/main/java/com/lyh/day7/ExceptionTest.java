package com.lyh.day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            test1();
        } catch (FileNotFoundException e) {
            System.out.println("您要找的文件不存在！");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("您要解析的时间有问题！");
            e.printStackTrace();
        }

    }


    public static void test1() throws FileNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse("2028-11-11 10:24");
        System.out.println(d);
        test2();
    }

    public static void test2() throws FileNotFoundException {
        InputStream is = new FileInputStream("D:/meinv.png");
    }

}
