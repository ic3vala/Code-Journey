
package com.lyh.day6.model;

public interface Swimmable {
    void swim();

    default void underwaterAction() {
        System.out.println("进行水下呼吸");
    }
}