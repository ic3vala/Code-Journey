package com.lyh.day6;

import com.lyh.day6.model.Animal;
import com.lyh.day6.model.Bird;
import com.lyh.day6.model.Fish;
import com.lyh.day6.model.Flyable;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Fish("小蓝", "淡水"),
                new Bird("燕子", 0.5) // 必须使用double类型参数
        };

        for (Animal animal : animals) {
            animal.breathe();
            animal.move();

            if (animal instanceof Flyable flyer) { // 类型匹配检测
                flyer.fly();
                // 正确访问静态方法
                System.out.println("翼展（英尺）: " +
                        Flyable.convertWingspan(((Bird)animal).getWingSpan()));
            }

            System.out.println("----------");
        }
    }
}
