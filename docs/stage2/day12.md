

# Day12: [数组与链表]

## 🧩 核心概念
### 1. 数组（Array）—— 像书架
- **特点**：连续内存空间、固定大小
- **优点**：快速随机访问（通过索引）
- **缺点**：插入/删除元素效率低（需要移动其他元素）

### 2. 链表（LinkedList）—— 像火车车厢
- **特点**：非连续内存、通过指针连接
- **优点**：动态扩容、插入/删除高效
- **缺点**：访问元素需要遍历

### ⚖️ 对比表
| 操作         | 数组（时间复杂度） | 链表（时间复杂度） |
|--------------|------------------|------------------|
| 随机访问       | O(1)            | O(n)            |
| 头部插入/删除  | O(n)            | O(1)            |
| 尾部插入/删除  | O(1)            | O(1)            |
| 中间插入/删除  | O(n)            | O(n)            |

---

## 💻 代码实验室
### 第一部分：数组基础
```java
public class ArrayDemo {
    public static void main(String[] args) {
        // 1. 声明并初始化数组（类似固定长度的盒子）
        int[] numbers = new int[3]; // 容量3的数组
        String[] names = {"Alice", "Bob", "Charlie"};

        // 2. 访问元素（索引从0开始）
        System.out.println(names[0]); // 输出 Alice
        numbers[1] = 5; // 修改第二个元素

        // 3. 遍历数组（普通for循环）
        for(int i=0; i<names.length; i++){
            System.out.println(names[i]);
        }

        // 4. 常见问题：越界访问（会报错！）
        // System.out.println(names[3]); // ❌ 最大索引是2
    }
}
```

### 第二部分：链表实践（使用Java标准库）
```java
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // 1. 创建链表（类似可以无限接长的火车）
        LinkedList<String> stations = new LinkedList<>();

        // 2. 添加元素
        stations.add("北京站");    // 尾部添加
        stations.addFirst("始发站"); // 头部插入
        stations.addLast("终点站");  // 尾部插入
        stations.add(1, "天津站");  // 指定位置插入

        // 3. 访问元素
        System.out.println("第一站: " + stations.getFirst());
        System.out.println("第三站: " + stations.get(2));

        // 4. 删除元素
        stations.removeFirst(); // 删除头部
        stations.remove("天津站"); // 删除指定元素

        // 5. 遍历链表（增强for循环）
        for(String station : stations){
            System.out.println("→ " + station);
        }
    }
}
```

---

## 🎯 关键细节解析
### 数组的"长度不可变"陷阱
```java
int[] arr = {1,2,3};
// arr[3] = 4; ❌ 无法直接扩容
// 正确做法：创建新数组并复制
int[] newArr = new int[6];
System.arraycopy(arr, 0, newArr, 0, arr.length);
```

### 链表的底层原理（节点结构）
```java
// 简化版链表节点实现
class Node<T> {
    T data;
    Node<T> next; // 指向下一个节点的指针

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## 🛠️ 动手挑战
### 任务1：数组反转
```java
// 将数组 {1,2,3,4,5} 反转为 {5,4,3,2,1}
int[] arr = {1,2,3,4,5};
// 你的代码写在这里...
```

### 任务2：链表实现
尝试自己实现一个简易链表：
```java
class MyLinkedList {
    private Node head; // 头节点

    // 添加节点方法
    public void add(int data) {
        // 实现代码...
    }

    // 打印链表方法
    public void print() {
        // 实现代码...
    }
}
```

---

### Leetcode [206]反转链表
```java
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3798 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;


    }
}

```

### Leetcode [19]删除链表的倒数第n个结点
```java
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3029 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 🛡️ 关键防御：创建哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head; // 新头节点前驱

        ListNode fast = dummy;
        ListNode slow = dummy;

        // 🚀 快指针先走n+1步（重点！）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 此时fast与slow间距n+1

        // 🕰️ 同步移动直到fast为null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时slow指向要删除节点的前驱

        // 💥 改变指针指向（跳过目标节点）
        slow.next = slow.next.next;

        return dummy.next; // 始终返回哑节点的next
    }

}

```
## 📌 使用场景建议
- **选择数组**：当需要频繁访问元素、已知数据量大小
- **选择链表**：当需要频繁插入/删除、数据量变化大

---

## 🧭 导航
[⬅️ Day11 JSON处理](../stage1/day11.md)  
[➡️ Day13 栈与队列](../stage2/day13.md)  
[🏠 返回目录](../../README.md)
