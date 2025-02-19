package com.lyh.day12;

import java.util.LinkedList;

public class PerformanceBattle {
    public static void main(String[] args) {
        // 🏎️ 数组方案
        long start = System.currentTimeMillis();
        int[] arr = new int[10000];
        for(int i=0; i<10000; i++){
            // 每次插入都要创建新数组（模拟实际开销）
            int[] newArr = new int[arr.length+1];
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            arr = newArr;
        }
        System.out.println("数组耗时：" + (System.currentTimeMillis()-start) + "ms");

        // 🚄 链表方案
        start = System.currentTimeMillis();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<10000; i++){
            list.addFirst(i); // 直接插入头部
        }
        System.out.println("链表耗时：" + (System.currentTimeMillis()-start) + "ms");
    }
}
