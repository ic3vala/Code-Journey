# Day15: 哈希表

## 🧩 核心概念

### 基础理论
- **哈希表（Hash Table）**：一种通过哈希函数将键映射到存储位置的数据结构，好比电话簿通过名字快速找到电话号码。
- **与数组的对比**：数组通过连续索引访问数据，哈希表通过哈希函数实现键值映射；数组适合顺序存储，哈希表擅长快速查找和动态操作。

### 关键特性对比
| 特性/操作      | 哈希表               | 数组                 |
| -------------- | -------------------- | -------------------- |
| 查找时间复杂度 | O(1)（平均）         | O(n)（线性查找）     |
| 插入时间复杂度 | O(1)（平均）         | O(n)（可能移动元素） |
| 删除时间复杂度 | O(1)（平均）         | O(n)（可能移动元素） |
| 空间复杂度     | O(n)（含空桶）       | O(n)（连续存储）     |
| 适用场景       | 快速查找、去重、缓存 | 顺序访问、静态存储   |

---

## 💻 代码实验室

### 基础语法示例
以下是一个简单的哈希表实现，支持增删改查操作，并通过链表解决哈希冲突。
```java
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] buckets; // 存储桶数组
    private int size; // 哈希表容量

    // 键值对的内部类
    static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 构造函数，初始化哈希表
    public HashTable(int capacity) {
        this.size = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>(); // 每个桶初始化为空链表
        }
    }

    // 计算哈希值的函数
    private int Hash(K key) {
        return Math.abs(key.hashCode() % size); // 确保索引非负且在容量范围内
    }

    // 添加或更新键值对
    public void put(K key, V value) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // 键已存在，更新值
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // 键不存在，添加新条目
    }

    // 查询键对应的值
    public V get(K key) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // 找到键，返回值
            }
        }
        return null; // 未找到，返回 null
    }

    // 删除键值对
    public void remove(K key) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // 找到键，删除条目
                return;
            }
        }
    }

    // 交互式测试的主方法
    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable<>(10); // 创建容量为10的哈希表
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 显示操作菜单
            System.out.println("\n请选择操作：");
            System.out.println("1. 增（添加键值对）");
            System.out.println("2. 删（删除键值对）");
            System.out.println("3. 改（更新键值对）");
            System.out.println("4. 查（查询键值对）");
            System.out.println("5. 退出");
            System.out.print("输入你的选择（1-5）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            if (choice == 5) {
                System.out.println("退出程序。");
                break;
            }

            switch (choice) {
                case 1: // 增
                    System.out.print("输入键：");
                    String addKey = scanner.nextLine();
                    System.out.print("输入值：");
                    String addValue = scanner.nextLine();
                    table.put(addKey, addValue);
                    System.out.println("添加成功： " + addKey + " -> " + addValue);
                    break;

                case 2: // 删
                    System.out.print("输入要删除的键：");
                    String removeKey = scanner.nextLine();
                    if (table.get(removeKey) != null) {
                        table.remove(removeKey);
                        System.out.println("删除成功：键 " + removeKey + " 已移除");
                    } else {
                        System.out.println("删除失败：键 " + removeKey + " 不存在");
                    }
                    break;

                case 3: // 改
                    System.out.print("输入要更新的键：");
                    String updateKey = scanner.nextLine();
                    if (table.get(updateKey) != null) {
                        System.out.print("输入新的值：");
                        String newValue = scanner.nextLine();
                        table.put(updateKey, newValue);
                        System.out.println("更新成功： " + updateKey + " -> " + newValue);
                    } else {
                        System.out.println("更新失败：键 " + updateKey + " 不存在");
                    }
                    break;

                case 4: // 查
                    System.out.print("输入要查询的键：");
                    String getKey = scanner.nextLine();
                    String value = table.get(getKey);
                    if (value != null) {
                        System.out.println("查询结果： " + getKey + " -> " + value);
                    } else {
                        System.out.println("查询失败：键 " + getKey + " 不存在");
                    }
                    break;

                default:
                    System.out.println("无效的选择，请输入 1-5 之间的数字。");
            }
        }
        scanner.close();
    }
}
```

### 进阶实践（可选）
实现动态扩容的哈希表，当负载因子（如条目数/桶数）超过0.75时，自动将桶数翻倍并重新分配所有键值对。

---

## 🎨 图解原理
``` 
哈希表结构：
buckets[0] -> [Key1:Value1|Next] -> [Key2:Value2|Next] -> ...
buckets[1] -> [Key3:Value3|Next] -> ...
buckets[2] -> ...
...
说明：每个桶是一个链表，存储发生哈希冲突的键值对。
```

---

## 🛠️ 常见问题清单
1. **Q：为什么哈希表需要处理冲突？**  
   → 解答：因为哈希函数可能将不同键映射到同一索引（哈希冲突）。此实现用链表存储冲突的键值对，查询时遍历链表即可。

2. **Q：负载因子过高会有什么问题？**  
   → 解答：负载因子过高（如接近1）会导致大量键值对挤在少数桶中，链表变长，查询效率从O(1)退化为O(n)。解决方法是动态扩容。

---

## 🧠 记忆卡片
```markdown
- `哈希函数`：将键转换为索引的核心工具，要求分布均匀以减少冲突。
- `拉链法`：用链表解决哈希冲突的方法，简单但可能导致链表过长。
```

---

## 🚀 实战挑战

### 基础任务
实现一个支持字符串键值对的哈希表，完成增删改查功能。
```java
public class Task {
    // 已在上方代码中实现
}
```

### 进阶任务（可选）
扩展上述哈希表，添加动态扩容功能。
```java
// 提示：建议在 put 方法中检查负载因子，调用 resize 方法扩容
class MyHashTable<K, V> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int entryCount; // 记录条目数

    // TODO: 实现 resize 方法，扩容并重新哈希
}
```

---

## 🧭 导航
[⬅️ Day14 排序算法](../stage2/day14.md)  
[➡️ Day16 树与图基础](../stage2/day16.md)  
[🏠 返回目录](../../README.md)

---

