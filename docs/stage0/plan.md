#### **核心思路**：
1. **打牢基础优先**：Java和数据结构是程序员的底层能力，课程所需的Kotlin/Android开发均依赖此基础。
   → **用Java学习数据结构和算法**（如链表/队列/排序），同时逐步过渡到与移动开发相关的知识点（如网络请求/JSON解析）。
2. **实战与理论结合**：每天确保**至少2小时写代码**（代码量 > 300行/天），杜绝“只看不练”。
3. **灵活弹性**：每天最后一小时为“动态复习时间”，重点回顾薄弱环节（如当天未理解的递归逻辑）。

---

### 计划表（Day 6 – Day 21）
**标⭐为必须完成的核心任务，其他任务根据进度调整**

#### **阶段一：Java核心语法强化（Day 6-11）**
**目标**：掌握开发Android应用所需的基础Java能力（OOP/集合/文件处理）。

| **Day** | **学习主题** | **具体任务** | **参考资源** | **配套练习** |
|---------|--------------|--------------|--------------|--------------|
| **6**   | **Java面向对象** | 彻底理解类/对象/继承/多态 | 《Java核心技术 卷I》第4章 | ⭐实现“动物类”继承体系：Animal→Dog/Cat，包含方法重写和super调用 |
| **7**   | **异常处理** | try-catch-finally/自定义异常 | MOOC《Java程序设计》第7讲 | ⭐编写计算器类，处理除零异常及非法输入 |
| **8**   | **集合框架** | ArrayList/HashMap/迭代器 | 《Effective Java》Item 28-34 | ⭐用HashMap统计文章单词频率，按Value排序输出 |
| **9**   | **文件与IO** | 读写文本文件/序列化 | Java官方Tutorial | ⭐实现CSV解析器，读取数据并转换为对象列表 |
| **10**  | **多线程基础** | Runnable接口/线程同步 | 《Java并发编程实战》前3章 | ⭐模拟10个线程同时存款，用synchronized避免竞争 |
| **11**  | **JSON处理** | Gson库解析与生成JSON | GitHub官方文档 | ⭐将学生对象序列化为JSON文件，实现增删改查 |

**提示**：避免过度设计代码，关注业务逻辑的清晰性（例如使用纯文本文件存储，无需数据库）.

---

#### **阶段二：数据结构与算法实战（Day 12-16）**
**目标**：用Java手写常用数据结构，理解它们在Android开发中的作用（如RecyclerView的链表优化）。

| **Day** | **学习主题** | **具体任务** | **理论连接现实案例** | **练习项目** |
|---------|--------------|--------------|--------------------|-------------|
| **12**  | **数组与链表** | 动态数组/单链表/双链表实现 | 安卓RecyclerView的Adapter实现 | ⭐手写动态扩容数组，支持add/remove/get方法 |
| **13**  | **栈与队列** | 数组实现栈/链表实现队列 | 移动端页面导航栈（如Activity回退） | ⭐用栈检查括号匹配问题，用队列模拟打印任务 |
| **14**  | **排序算法** | 快速排序/归并排序/冒泡排序 | 安卓RecyclerView数据排序功能 | ⭐实现Comparator接口对对象列表排序（多种策略） |
| **15**  | **哈希表** | 冲突解决（链地址法） | 安卓SharedPreferences的键值存储 | ⭐手写简易哈希表，处理字符串键的哈希冲突 |
| **16**  | **树与图基础** | 二叉搜索树/广度优先搜索 | 文件系统目录结构/社交网络关系 | ⭐用BST实现通讯录按名字排序查找功能 |

**提示**：完成代码后在LeetCode或Codewars上找到对应题号提交验证（例：实现链表后刷LeetCode 206反转链表）。

---

#### **阶段三：衔接移动开发的综合实战（Day 17-21）**
**目标**：从Java过渡到Android开发思维，铺垫未来学习Kotlin的能力。

| **Day** | **学习主题** | **具体任务** | **技能转化练习** | **延展挑战** |
|---------|--------------|--------------|------------------|--------------|
| **17**  | **网络请求** | Java实现HTTP客户端（HttpURLConnection） | ⭐爬取公开API数据（如天气API），解析JSON并输出 | 改用Retrofit库简化代码 |
| **18**  | **SQLite基础** | Java操作SQLite数据库（增删改查） | ⭐实现学生信息管理系统（命令行版） | 在安卓中嵌入SQLite (预习) |
| **19**  | **设计模式** | 观察者模式/单例模式/MVC | ⭐用观察者模式实现“传感器数据实时推送”（模拟Android LiveData） | 分析安卓源码中的设计模式案例 |
| **20**  | **Android入门** | 创建首个Android工程（Java版）“Hello World” | ⭐将Day 18的学生系统移植到Android（界面用TextView显示） | 尝试用Kotlin改写MainActivity |
| **21**  | **项目原型设计** | 用Figma绘制小组项目的低保真原型图 | ⭐与土耳其队友讨论功能需求，输出原型草稿 | 学习Material Design指南 |

---

### **配套资源清单**
- **Java核心**：《Java核心技术 卷I》 + [Codecademy Java Course](https://www.codecademy.com/learn/learn-java)（互动练习平台）
- **数据结构**：《算法（第4版）》 + [VisuAlgo](https://visualgo.net/)（算法可视化工具）
- **实战衔接**：[Android Developers Training](https://developer.android.com/courses)（官方免费课程）

### **调整策略建议**
- **每3天一次复盘**：用GitHub提交代码，对比前日任务并总结未完成原因（是优先级还是难度问题）
- **灵活替换**：若某天任务进度滞后，优先完成标⭐内容，其他延至动态复习时间
- **防止疲劳**：拆分学习时间为“2小时视频+笔记 → 1小时实践 → 午休 → 2小时实践+动态复习”
