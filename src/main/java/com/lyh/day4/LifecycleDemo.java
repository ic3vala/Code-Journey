
package com.lyh.day4;

import com.lyh.day4.model.Pet;

public class LifecycleDemo {
    public static void main(String[] args) {
        // 对象创建
        Pet myCat = new Pet("喵喵", 2);

        // 垃圾回收演示（配合JVM参数-XX:+PrintGCDetails）
        for (int i = 0; i < 100000; i++) {
            new Pet("temp", i);
        }
    }
}