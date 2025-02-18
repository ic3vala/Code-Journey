### **一、基础容器概念框架**
#### 1. **容器（Collection）的作用** → **就像收纳盒**
- **为什么需要容器**：单个变量（如`int a=5;`）就像散落的物品，容器帮助分类管理
- **常见容器类型**：
  | 容器类型 | 现实比喻 | 特点 | Java实现类 |
  |---------|---------|------|------------|
  | **List** | 排队队伍 | 有序、可重复 | `ArrayList`, `LinkedList` |
  | **Set**  | 数学集合 | 无序、唯一 | `HashSet`, `TreeSet` |
  | **Map**  | 字典     | 键值对（key→value） | `HashMap`, `TreeMap` |

#### 2. **泛型（`<>`）的作用** → **给收纳盒贴标签**
```java
// 没有泛型 → 杂货箱（什么都能放，但危险！）
List messyList = new ArrayList();
messyList.add("hello");
messyList.add(123); // 允许，但取出时需要类型转换

// 有泛型 → 标签明确的药盒
List<String> safeList = new ArrayList<>();
safeList.add("hello");
// safeList.add(123); ← 编译报错！确保类型安全
```

**核心要点**：
- `<String>` 告诉编译器这个List**只能放字符串**
- 泛型在编译后会被擦除（类型信息消失），主要为了开发期安全

---

### **二、Map与Entry详解**
#### 1. **Map结构** → **像字典**
```java
Map<String, Integer> wordCount = new HashMap<>();
//        ↑键类型   ↑值类型
wordCount.put("apple", 5); // 类似字典：单词→解释
wordCount.put("banana", 2);
```

#### 2. **Entry是什么** → **字典中的一页**
- 每个Entry代表一个键值对
- 获取Entry的两种方式：
  ```java
  // 方式1：遍历Entry集合
  for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
      String key = entry.getKey();
      int value = entry.getValue();
  }

  // 方式2：分别获取键和值
  for (String key : wordCount.keySet()) { /* 遍历键 */ }
  for (Integer value : wordCount.values()) { /* 遍历值 */ }
  ```

**类比理解**：
- `Map` = 整本字典
- `Entry` = 单个词条（如apple→5）
- `entrySet()` = 获取所有词条的目录

---

### **三、List与泛型实战**
#### 1. **List基础操作**
```java
List<String> fruits = new ArrayList<>();
fruits.add("apple");  // 增
fruits.get(0);        // 查 → "apple"
fruits.set(0, "grape"); // 改
fruits.remove(0);     // 删
```

#### 2. **泛型嵌套示例**
```java
// List中存储Map
List<Map<String, Integer>> listOfMaps = new ArrayList<>();

Map<String, Integer> map1 = new HashMap<>();
map1.put("A", 1);
listOfMaps.add(map1); // √ 合法

// Map中存储List
Map<String, List<Integer>> studentScores = new HashMap<>();
studentScores.put("LiLei", Arrays.asList(80, 90));
```

---

### **四、常见符号与代码模式**
#### 1. **箭头符号`->`**
- 用于Lambda表达式和流式操作：
  ```java
  // 传统匿名类
  button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { ... }
  });

  // Lambda简化
  button.addActionListener(e -> System.out.println("Clicked!"));
  ```

#### 2. **双冒号`::`（方法引用）**
```java
List<String> names = Arrays.asList("A", "B", "C");
names.forEach(System.out::println); // 等价于 s -> System.out.println(s)
```

---

### **五、快速自查表**
| 遇到代码 | 含义 | 类比 |
|---------|------|-----|
| `List<String>` | 只能存String的列表 | 贴了"水果"标签的盒子 |
| `Map.Entry<K,V>` | 键值对组合 | 字典中的一页（单词+解释） |
| `<T>` | 泛型类型占位符 | "T"可以是任何类型，如String/Integer |
| `words.add("hello")` | 向列表添加元素 | 往盒子里放一个苹果 |

---

### **六、巩固练习**
#### 任务1：统计字母频率
```java
String text = "hello";
Map<Character, Integer> freq = new HashMap<>();
for (char c : text.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
// 目标：得到 h→1, e→1, l→2, o→1
```

#### 任务2：嵌套结构实践
```java
// 创建Map，值为List<Integer>
Map<String, List<Integer>> scores = new HashMap<>();
scores.put("Alice", Arrays.asList(85, 90));
// 添加Bob的成绩：[78, 88]
// 打印所有学生的平均分
```
