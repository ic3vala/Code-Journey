
### **Day 6：Java多态与继承体系**
#### **视频资源**
- **必看**：B站狂神说Java《面向对象：多态详解》(1-30集，2倍速)
- **辅助**：YouTube《Java Polymorphism in Depth》(重点看Method Overriding部分)

#### **代码任务**
1. 实现动物类继承体系：`Animal` → `Dog`/`Cat`
2. 编写类型安全转换工具类`TypeSafeCaster`
3. 测试多态调用：`Animal a = new Dog(); a.makeSound();`

#### **核心学习点**
- 多态的三大条件（继承、重写、父类引用）
- `instanceof` 的安全检查逻辑
- 方法重写（`@Override`）与重载的区别

---

### **Day 7：异常处理与健壮性编程**
#### **视频资源**
- **必看**：B站黑马程序员《Java异常处理实战》(1-15集)
- **辅助**：Oracle官方文档《Exception Handling Tutorial》

#### **代码任务**
1. 实现计算器类`Calculator`，处理除零异常
2. 自定义异常`InvalidInputException`
3. 使用`try-with-resources`读取文件

#### **核心学习点**
- 检查型异常 vs 非检查型异常
- `try-catch-finally` 执行流程
- 异常链与日志记录规范

---

### **Day 8：集合框架与HashMap实战**
#### **视频资源**
- **必看**：B站《Java集合框架深度解析》(ArrayList/HashMap部分)
- **辅助**：《Effective Java》Item 34-37（速读）

#### **代码任务**
1. 用`HashMap`统计文本词频
2. 按词频排序输出（使用`Comparator`）
3. 实现LRU缓存淘汰策略（拓展）

#### **核心学习点**
- `HashMap`的哈希冲突解决机制
- `ArrayList`的动态扩容原理
- `Iterator`遍历的安全性问题

---

### **Day 9：文件操作与数据持久化**
#### **视频资源**
- **必看**：B站《Java IO流与文件操作》(重点看字符流)
- **辅助**：Java官方《File I/O Tutorial》

#### **代码任务**
1. 实现CSV文件解析器（读取为对象列表）
2. 将学生信息序列化到文件
3. 反序列化恢复对象状态

#### **核心学习点**
- 字节流 vs 字符流
- `Serializable`接口与版本控制
- `BufferedReader`性能优化

---

### **Day 10：多线程与并发基础**
#### **视频资源**
- **必看**：YouTube《Java Concurrency Essentials》(前3章)
- **辅助**：B站《synchronized锁机制详解》

#### **代码任务**
1. 模拟银行账户多线程存款（解决竞争问题）
2. 用`Runnable`和`Thread`创建线程
3. 实现生产者-消费者模型（拓展）

#### **核心学习点**
- 线程生命周期（New/Runnable/Blocked等）
- `synchronized` 关键字的作用域
- 线程安全与原子操作

---

### **Day 11：JSON处理与数据交换**
#### **视频资源**
- **必看**：B站《Gson库快速入门》
- **辅助**：GitHub《Gson User Guide》

#### **代码任务**
1. 将学生对象序列化为JSON文件
2. 解析JSON数据恢复对象
3. 实现RESTful API模拟（用Map存储数据）

#### **核心学习点**
- JSON数据结构（键值对/数组嵌套）
- `@SerializedName`注解用法
- 异常处理：JSON解析失败场景

---

### **Day 12：动态数组与链表实现**
#### **视频资源**
- **必看**：B站浙江大学《数据结构-数组与链表》(1-8讲)
- **辅助**：VisuAlgo链表可视化工具

#### **代码任务**
1. 手写动态数组（支持泛型与扩容）
2. 实现单链表`addFirst`/`removeLast`
3. LeetCode #206 反转链表

#### **核心学习点**
- 均摊时间复杂度分析（O(1)）
- 虚拟头节点（Dummy Node）技巧
- 链表指针操作的顺序依赖

---

### **Day 13：栈与队列应用**
#### **视频资源**
- **必看**：B站《栈与队列实战应用》
- **辅助**：LeetCode官方《栈问题精讲》

#### **代码任务**
1. 用数组实现栈`ArrayStack`
2. 用链表实现队列`LinkedQueue`
3. LeetCode #20 有效括号匹配

#### **核心学习点**
- 栈的LIFO特性与递归调用栈
- 队列的FIFO特性与BFS算法
- 双端队列（Deque）的应用场景

---

### **Day 14：排序算法与性能优化**
#### **视频资源**
- **必看**：YouTube《Sorting Algorithms Animations》
- **辅助**：B站《快速排序分治思想详解》

#### **代码任务**
1. 实现快速排序（递归版）
2. 实现归并排序（迭代版）
3. 对比不同算法对10万数据的排序时间

#### **核心学习点**
- 分治思想与递归终止条件
- 时间复杂度对比（O(n²) vs O(n log n)）
- 原地排序（In-place）与稳定性

---

### **Day 15：哈希表与冲突解决**
#### **视频资源**
- **必看**：B站《哈希表原理与实现》
- **辅助**：《算法（第4版）》哈希表章节

#### **代码任务**
1. 手写链地址法哈希表（支持`put`/`get`）
2. 解决字符串键的哈希冲突
3. LeetCode #1 两数之和

#### **核心学习点**
- 哈希函数设计原则（均匀性/高效性）
- 负载因子（Load Factor）与扩容阈值
- 开放寻址法 vs 链地址法

---

### **Day 16：树与二叉搜索树**
#### **视频资源**
- **必看**：B站《二叉树遍历与递归》
- **辅助**：VisuAlgo树结构可视化

#### **代码任务**
1. 实现二叉搜索树（插入/查找/删除）
2. 递归实现前序/中序/后序遍历
3. LeetCode #98 验证二叉搜索树

#### **核心学习点**
- 树的高度与深度计算
- BST的中序遍历有序性
- 递归算法的栈溢出风险

---

### **Day 17：网络请求与API调用**
#### **视频资源**
- **必看**：B站《Java HTTP编程实战》
- **辅助**：Postman官方文档

#### **代码任务**
1. 使用`HttpURLConnection`调用天气API
2. 解析JSON响应并提取关键数据
3. 实现本地缓存（避免频繁请求）

#### **核心学习点**
- HTTP协议基础（GET/POST/状态码）
- JSON数据解析与对象映射
- 网络请求的异步处理（回调机制）

---

### **Day 18：SQLite数据库操作**
#### **视频资源**
- **必看**：B站《Java操作SQLite教程》
- **辅助**：SQLite官方《Java API Guide》

#### **代码任务**
1. 创建学生信息表（`id, name, score`）
2. 实现CRUD操作（增删改查）
3. 事务处理：批量插入1000条数据

#### **核心学习点**
- JDBC连接池配置
- SQL注入攻击与参数化查询
- 数据库索引优化查询性能

---

### **Day 19：设计模式与架构**
#### **视频资源**
- **必看**：YouTube《Design Patterns in Android》
- **辅助**：《Head First设计模式》前3章

#### **代码任务**
1. 实现观察者模式（模拟LiveData）
2. 单例模式优化数据库连接管理
3. MVC分层重构学生管理系统

#### **核心学习点**
- 观察者模式中的发布-订阅机制
- 单例模式的线程安全问题
- 分层架构的解耦优势

---

### **Day 20：Android入门与工程创建**
#### **视频资源**
- **必看**：Google官方《Android Basics in Java》
- **辅助**：B站《Android Studio入门指南》

#### **代码任务**
1. 创建`Hello World`工程并运行
2. 将命令行学生系统移植到Android（用TextView显示）
3. 添加按钮点击事件（跳转页面）

#### **核心学习点**
- Android工程结构（`res/`, `src/`, `AndroidManifest`）
- Activity生命周期
- 布局文件XML编写规范

---

### **Day 21：项目原型设计与协作**
#### **视频资源**
- **必看**：YouTube《Figma for Developers》
- **辅助**：Material Design官方指南

#### **任务**
1. 用Figma绘制智能教室系统原型图
2. 编写需求文档（Markdown格式）
3. 创建GitHub仓库并初始化项目

#### **核心学习点**
- 低保真原型设计原则
- 用户故事（User Story）编写技巧
- GitHub Issue跟踪任务进度

---

### **执行工具与检查清单**
1. **视频加速**：用[Enhancer for YouTube](https://chrome.google.com/webstore/detail/enhancer-for-youtube/ponfpcnoihfmfllpaingbgckeeldkhle)插件控制播放速度
2. **代码验证**：每完成一个函数，用JUnit编写单元测试
3. **笔记模板**：
   ```markdown
   # Day [X]: [主题]
   
   ## 核心知识点
   - 知识点1
   - 知识点2
   
   ## 代码片段
   ```java
   // 关键代码
   ```

   ## 问题与解决
    - 问题描述 → 解决思路
   ```

