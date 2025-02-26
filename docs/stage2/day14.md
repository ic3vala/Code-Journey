# Day14: 排序算法

## 🧩 核心概念
### 分治思想
- **快速排序**：通过选取基准元素将数组分为两部分（小于基准和大于基准），递归排序
- **归并排序**：将数组拆分为最小单元，逐步合并有序子数组

### 关键特性对比
| 特性/算法    | 快速排序                   | 归并排序                     |
| ------------ | -------------------------- | ---------------------------- |
| 时间复杂度   | 平均O(n log n)，最差O(n²)  | 稳定O(n log n)               |
| 空间复杂度   | O(log n)（递归栈）         | O(n)（辅助数组）             |
| 稳定性       | 不稳定（交换改变元素顺序） | 稳定（保持相等元素顺序）     |
| 最佳适用场景 | 内存敏感的通用排序         | 需要稳定性和可预测性能的排序 |

---

## 💻 代码实验室

### 快速排序实现
```java
package com.lyh.day14;

public class QuickSort {
    // 主排序方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 递归终止条件：子数组长度>1
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // 处理左半部分（小于基准）
            quickSort(arr, pivotIndex + 1, high); // 处理右半部分（大于基准）
        }
    }

    /**
     * 分区操作（算法核心）
     * @param arr 待排序数组
     * @param low 当前分区起始索引
     * @param high 当前分区结束索引（基准位置）
     * @return 基准元素的最终正确位置
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = low - 1; // 指向小于基准区域的最后一个位置
        
        // 遍历当前分区（不包含基准）
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++; // 扩大小于基准区域
                swap(arr, i, j); // 将当前元素交换到小值区末尾
            }
        }
        swap(arr, i + 1, high); // 将基准放到正确位置
        return i + 1; // 返回基准的最终索引
    }

    // 交换辅助方法
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试用例
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr)); 
    }
}
```

### 归并排序实现
```java
package com.lyh.day14;

public class MergeSort {
    // 主排序方法
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // 递归终止条件
            int mid = (left + right) / 2; // 计算中间点
            mergeSort(arr, left, mid);    // 排序左半部
            mergeSort(arr, mid + 1, right);// 排序右半部
            merge(arr, left, mid, right); // 合并有序子数组
        }
    }

    /**
     * 合并两个有序子数组
     * @param left  左子数组起始索引
     * @param mid   中间分隔索引
     * @param right 右子数组结束索引
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        
        // 双指针合并
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) 
                      ? leftArr[i++] 
                      : rightArr[j++];
        }
        
        // 处理剩余元素
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // 测试用例
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
```

---

## 🎨 图解原理
### 快速排序分区过程（示例数组 [3,1,4,1,5]）
```
初始状态：3 1 4 1 [5]（基准=5）
分区过程：
j=0: 3<=5 → i=0 → 交换保持原位
j=1: 1<=5 → i=1 → 交换保持原位 
j=2: 4<=5 → i=2 → 交换保持原位
j=3: 1<=5 → i=3 → 交换保持原位
最终交换基准 → [3,1,4,1,5]
```

### 归并排序合并过程
```
左子数组：[2,5]  右子数组：[3,7]
合并步骤：
比较2和3 → 取2
比较5和3 → 取3
比较5和7 → 取5
剩余7 → 最终[2,3,5,7]
```

---

## 🛠️ 常见问题清单
1. **Q：快速排序为什么选择最后一个元素作为基准？**  
   → 这是最简单的实现方式，但可能产生最差情况。实际应用中建议随机选择基准元素

2. **Q：归并排序的空间复杂度为什么是O(n)？**  
   → 因为合并时需要创建临时数组存储当前合并结果

3. **Q：遇到StackOverflowError怎么办？**  
   → 可能输入数组太大导致递归过深，可改用迭代实现或增大JVM栈空间

4. **Q：如何处理包含重复元素的数组？**  
   → 快速排序的<=比较可保留重复元素相对位置（但整体仍不稳定）

---

## 🧠 记忆卡片
```markdown
- `partition()`：快速排序核心方法，完成元素分类和基准定位
- `merge()`：归并排序核心方法，合并两个有序数组
- 递归终止条件：数组长度<=1时不需要排序（low >= high / left >= right）
```

---

## 🚀 实战挑战
### 基础任务
```java
// 实现随机化快速排序（优化基准选择）
private static int partition(int[] arr, int low, int high) {
    // 添加随机化代码 ↓
    int randomIndex = new Random().nextInt(high-low+1) + low;
    swap(arr, randomIndex, high);
    // 原分区逻辑保持不变...
}
```

### 进阶任务
```java
// 实现三路快速排序（处理大量重复元素）
void quickSort3Way(int[] arr, int low, int high) {
    if (low >= high) return;
    // 实现分为 <pivot, ==pivot, >pivot 三部分
}
```

---

## 🧭 导航
[⬅️ Day13 栈与队列](../stage2/day13.md)  
[➡️ Day15 哈希表](../stage2/day15.md)  
[🏠 返回目录](../../README.md)

