package com.lyh.day8;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for(String str : list) {
            System.out.print(str + " ");
        }
    }

}
