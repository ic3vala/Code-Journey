package com.lyh.day8;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(4);

        System.out.println(set);


    }
}
