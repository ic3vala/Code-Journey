
package com.lyh.day5;

import com.lyh.day5.model.Animal;
import com.lyh.day5.model.Cat;
import com.lyh.day5.model.Dog;

/**
 * 多态与类型转换演示
 */
public class Main {
    public static void main(String[] args) {
        // 多态数组
        Animal[] animals = {
                new Dog("大黄", 3, "金毛"),
                new Cat("咪咪", 2, "橘色")
        };

        // 循环调用通用方法
        for (Animal animal : animals) {
            animal.eat();
            animal.sleep();

            // 类型安全检测
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.guardHouse();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.catchMouse();
            }

            System.out.println("----------");
        }
    }
}
