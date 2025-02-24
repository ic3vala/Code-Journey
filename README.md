# Code-Journey

[![Last Commit](https://img.shields.io/github/last-commit/ic3vala/Code-Journey?color=blue&style=flat-square)](https://github.com/ic3vala/Code-Journey/commits/main)

> 系统化Java学习仓库，每日进度可视化跟踪

## 📁 项目结构
```bash
CodeLab
├── docs/           # 阶段学习笔记
├── src/
│   └── main/java/com/lyh/day[1-5]  # 每日代码
└── test/           # 测试代码（同步开发中）
```
## 计划链接 
- [Plan](./docs/stage0/plan.md)
- [Details of Plan](./docs/stage0/detail.md)

## 📚 学习轨迹
| 天数   | 主题 | 代码示例                                                            | 笔记链接                        |
|------|----|-----------------------------------------------------------------|-----------------------------|
| Day1 | 基础语法 | [HelloWorld.java](./src/main/java/com/lyh/day1/HelloWorld.java) | [笔记](./docs/stage1/day1.md) |
| Day2 | 方法与流程控制 | [学生管理系统](./src/main/java/com/lyh/day2/student/)                 | [笔记](./docs/stage1/day2.md) |
| Day3 | 数组与面向对象基础 | [数组基本操作](./src/main/java/com/lyh/day3/ArrayDemo.java)           | [笔记](./docs/stage1/day3.md) |
| Day4 | 类与对象基础 | [宠物类设计](./src/main/java/com/lyh/day4/model/Pet.java)            | [笔记](./docs/stage1/day4.md) |
| Day5 | 面向对象进阶 | [动物继承体系](./src/main/java/com/lyh/day5/model/)                   | [笔记](./docs/stage1/day5.md) |
| Day6 | 抽象类与接口 | [具体实现类](./src/main/java/com/lyh/day6/model/Fish.java)           | [笔记](./docs/stage1/day6.md) |
| Day7 | 异常处理 | [异常处理方法](./src/main/java/com/lyh/day7/ExceptionTest.java)       | [笔记](./docs/stage1/day7.md) |
| Day8 | 集合框架 | [HashMap词频排序](./src/main/java/com/lyh/day8/HashMapCount.java)   | [笔记](./docs/stage1/day8.md) |
| Day9 | 文件与IO | [实现CSV文件解析器](./src/main/java/com/lyh/day9/CSVParser.java)       | [笔记](./docs/stage1/day9.md) |
| Day10 | 多线程基础 | [银行账户多线程存款](./src/main/java/com/lyh/day10/Main.java)            | [笔记](./docs/stage1/day10.md) |
| Day11 | JSON处理 | [](./src/main/java/com/lyh/day11/.java)                         | [笔记](./docs/stage1/day11.md) |
| Day12 | 数组与链表 | [动态数组实现](./src/main/java/com/lyh/day12/DynamicArrayTest.java)   | [笔记](./docs/stage2/day12.md) |
| Day13 | 栈与队列 | [链表实现栈](./src/main/java/com/lyh/day13/LinkedListStack.java)     | [笔记](./docs/stage2/day13.md) |
| Day14 | 排序算法 | [](./src/main/java/com/lyh/day14/.java)                         | [笔记](./docs/stage2/day14.md) |
| Day15 | 哈希表 | [](./src/main/java/com/lyh/day15/.java)                         | [笔记](./docs/stage2/day15.md) |
| Day16 | 树与图基础 | [](./src/main/java/com/lyh/day16/.java)                         | [笔记](./docs/stage2/day16.md) |
## 🛠 开发规范
1. **包命名原则**：`com.lyh.dayX.module`（X为天数）
2. **提交规范**：
    - feat: 新功能开发
    - docs: 文档更新
    - fix: 问题修复
3. **分支策略**：每日任务在`dayX-feature`分支开发

## 🔍 快速导航
```bash
# 查看Day3的冒泡排序代码
cd src/main/java/com/lyh/day3/sort
ls MaoPao.java

# 查看Day5的多态示例
open src/main/java/com/lyh/day5/model/Animal.java
```
