package com.lyh.day12;

public class DynamicArrayTest<T> {
    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");
        array.add("e");
        System.out.println(array.size());
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        array.remove(3);
        System.out.println(array.get(3));
    }
}
