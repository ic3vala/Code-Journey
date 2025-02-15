
package com.lyh.day5.model;

/**
 * 狗类继承示例
 */
public class Dog extends Animal {
    private String breed;  // 品种

    public Dog(String name, int age, String breed) {
        super(name, age);  // 调用父类构造
        this.breed = breed;
    }

    public String getBreed(){
        return breed;
    }
    @Override
    public void eat() {
        System.out.println(getName() + "正在啃骨头");
    }

    // 特有方法
    public void guardHouse() {
        System.out.println(getName() + "正在看家");
    }
}
