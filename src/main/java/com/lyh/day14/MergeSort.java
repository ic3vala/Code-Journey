package com.lyh.day14;

public class MergeSort {
    // 主排序方法
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间点
            int mid = (left + right) / 2;
            // 递归排序左半部分
            mergeSort(arr, left, mid);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right);
            // 合并两个有序子数组
            merge(arr, left, mid, right);
        }
    }

    // 合并方法
    private static void merge(int[] arr, int left, int mid, int right) {
        // 计算左右子数组的长度
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // 复制数据到临时数组
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // 合并临时数组
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // 复制剩余的元素
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " "); // 输出：5 6 7 11 12 13
        }
    }
}