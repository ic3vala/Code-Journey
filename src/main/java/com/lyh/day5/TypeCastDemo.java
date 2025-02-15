package com.lyh.day5;

import com.lyh.day5.model.Animal;
import com.lyh.day5.model.Cat;
import com.lyh.day5.model.Dog;

/**
 * 类型安全转换最佳实践
 * 演示instanceof的多种应用场景
 */
public class TypeCastDemo {
    public static void main(String[] args) {
        Animal animal = getRandomAnimal();

        // 场景1：基础类型检查
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            System.out.println("发现狗狗品种: " + dog.getBreed());
        }

        // 场景2：多条件判断
        if (animal instanceof Cat cat) { // Java16+模式匹配语法
            System.out.println("猫咪毛色: " + cat.getFurColor());
        }

        // 场景3：接口类型检查（扩展性演示）
        if (animal instanceof Runnable runnable) {
            runnable.run();
        }
    }

    // 随机返回动物实例
    private static Animal getRandomAnimal() {
        return Math.random() > 0.5 ?
                new Dog("小黑", 2, "拉布拉多") :
                new Cat("雪球", 1, "白色");
    }
}
