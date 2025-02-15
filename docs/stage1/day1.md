## Day 1: Java基础语法
### 学习内容
- 了解JAVA特性
- JDK:Java Development Kit JRE: Java Runtime Environment JVM: Java Virtual Machine
- Java 运行机制：解释型语言 强类型语言
---
- 注释// /* */
- 基本类型：`int`, `String`, `boolean`, `short`, `byte`, `long`, `float`, `double`
- 转义字符：
  `\t`  制表符, `\n`  换行
- 类型转换 低到高 自动转换
- 命名规范：
    1. 类变量：monthSalary
    2. 局部变量：monthSalary
    3. 常量：MAX_VALUE
    4. 类名：Man, GoodMan
    5. 方法名：run(), runRun()
- 三目运算符： ?:  x?y:z
- 包名倒置 package pkg1[. pkg2[. pkg3...]];  import package1[.package2...].(classname|*);


---
### 代码练习
- [HelloWorld.java](../../../src/main/java/com/lyh/day1/Hello.java)
```java
package com.lyh.day1;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World！");
    }
}
```
---
### 遇到的问题
- 为什么`String`是类而不是基本类型？

- [下一节：Java方法](../day2.md)