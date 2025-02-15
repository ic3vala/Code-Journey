package com.lyh.day6.model;

public abstract class Animal {
    protected String name; // 改为protected确保子类访问

    public Animal(String name) {
        this.name = name;
    }

    public abstract void move();

    public String getName() { // 必须添加getter
        return name;
    }

    public void breathe() {
        System.out.println(name + "正在呼吸");
    }
}
