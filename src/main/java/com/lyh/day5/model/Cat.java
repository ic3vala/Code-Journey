
package com.lyh.day5.model;

/**
 * 猫类继承示例
 */
public class Cat extends Animal {
    private String furColor;  // 毛色

    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    public String getFurColor(){
        return furColor;
    }
    @Override
    public void eat() {
        System.out.println(getName() + "正在吃鱼");
    }

    // 特有方法
    public void catchMouse() {
        System.out.println(getName() + "正在抓老鼠");
    }
}
