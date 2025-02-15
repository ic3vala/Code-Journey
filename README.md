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

## 📚 学习轨迹
| 天数 | 主题 | 代码示例                                                       | 笔记链接                        |
|------|------|------------------------------------------------------------|-----------------------------|
| Day1 | 基础语法 | [Hello.java](./src/main/java/com/lyh/day1/HelloWorld.java) | [笔记](./docs/stage1/day1.md) |
| Day2 | 方法与流程控制 | [学生管理系统](./src/main/java/com/lyh/day2/student/)            | [笔记](./docs/stage1/day2.md) |
| Day5 | 面向对象进阶 | [动物继承体系](./src/main/java/com/lyh/day5/model/)              | [笔记](./docs/stage1/day5.md) |

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
