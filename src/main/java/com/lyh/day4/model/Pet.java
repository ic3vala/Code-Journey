
package com.lyh.day4.model;

public class Pet {
    // 封装属性
    private String name;
    private int age;

    // 构造方法重载
    public Pet() {
        this("无名氏", 0);
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter/Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}