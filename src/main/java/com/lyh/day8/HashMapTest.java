package com.lyh.day8;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2dsfsa", 2);
        map.put("3I", 3);
        map.put("K", 4);
        map.put("uii", 5);
        System.out.println(map);
        System.out.println(map.get("K"));
        map.remove("uii");
        System.out.println(map);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println(entryList);
    }
}
