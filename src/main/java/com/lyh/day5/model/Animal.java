package com.lyh.day5.model;

/**
 * 动物抽象基类
 * 演示继承/多态核心概念
 */
public abstract class Animal {
    // 封装属性
    private String name;
    private int age;

    // 构造方法
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 抽象方法（强制子类实现）
    public abstract void eat();

    // final方法（禁止子类修改）
    public final void sleep() {
        System.out.println(name + "正在睡觉...");
    }

    // Getter/Setter
    public String getName() { return name; }
    public int getAge() { return age; }
}
