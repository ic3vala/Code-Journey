package com.lyh.day6.model;

public interface Flyable {
    void fly(); // 接口方法必须被实现

    default void glide() {
        System.out.println("滑翔中...");
    }

    static double convertWingspan(double meters) {
        return meters * 3.2808;
    }
}
