package com.lyh.day6.model;

public class Bird extends Animal implements Flyable {
    private double wingSpan;

    public Bird(String name, double wingSpan) {
        super(name);
        this.wingSpan = wingSpan;
    }

    @Override
    public void move() { // 正确实现抽象方法
        System.out.println(getName() + "拍打翅膀飞行");
    }

    @Override
    public void fly() { // 正确实现接口方法
        System.out.printf("%s展开%.1f米翅膀飞行%n", getName(), wingSpan);
        glide(); // 调用默认方法
    }

    public double getWingSpan() { // 必须添加getter
        return wingSpan;
    }
}
