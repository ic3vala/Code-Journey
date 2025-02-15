
package com.lyh.day3;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // 声明并初始化
        int[] nums = {3, 1, 4, 1, 5};

        // 数组遍历
        System.out.println("原始数组: " + Arrays.toString(nums));

        // Arrays工具类使用
        Arrays.sort(nums);
        System.out.println("排序后: " + Arrays.toString(nums));
    }
}