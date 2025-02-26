package com.lyh.day14;

public class QuickSort {
    // 主排序方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 递归终止条件
            // 获取基准位置
            int pivotIndex = partition(arr, low, high);
            // 递归排序左半部分
            quickSort(arr, low, pivotIndex - 1);
            // 递归排序右半部分
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 分区方法
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = low - 1; // 小于等于基准部分的末尾
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++; // 前移i
                swap(arr, i, j); // 交换
            }
        }
        // 将基准放到正确位置
        swap(arr, i + 1, high);
        return i + 1; // 返回基准位置
    }

    // 交换数组中两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " "); // 输出：1 5 7 8 9 10
        }
    }
}