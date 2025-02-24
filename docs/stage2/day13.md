# Day13: [栈与队列]

## 🧩 核心概念

### 基础理论

- **栈（Stack）**：  
  一句话定义：后进先出（LIFO）的数据结构。  
  生活类比：像一摞书，最新放上去的书最先被拿走。  

- **队列（Queue）**：  
  一句话定义：先进先出（FIFO）的数据结构。  
  生活类比：像排队买票，先来的人先买到票。  

- **对比说明**：  
  - 栈和队列都是线性数据结构，但操作方式不同。  
  - 栈在顶部进行插入（push）和删除（pop），适合后进先出的场景，如函数调用栈或撤销操作。  
  - 队列在后端插入（enqueue）并在前端删除（dequeue），适合先进先出的场景，如任务调度或打印队列。  

### 关键特性对比

| 特性/操作     | 栈 (Stack)           | 队列 (Queue)  |
| ------------- | -------------------- | ------------- |
| 插入操作      | push                 | enqueue       |
| 删除操作      | pop                  | dequeue       |
| 查看顶部/前端 | peek/top             | front         |
| 时间复杂度    | O(1)                 | O(1)          |
| 空间复杂度    | O(n)                 | O(n)          |
| 适用场景      | 函数调用、表达式求值 | 任务调度、BFS |

**注解**：时间复杂度为 O(1) 是因为基本操作只涉及顶部或两端元素的直接访问；空间复杂度 O(n) 取决于存储的元素数量。

---

## 💻 代码实验室

### 基础语法示例

#### 栈实现
```java
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 1. 基础用法：添加元素
        stack.push("a");
        stack.push("b");
        stack.push("c");
        // 2. 关键API调用：pop移除并返回顶部元素，peek只查看顶部元素
        System.out.println(stack.pop()); // 输出：c（后进先出）
        System.out.println(stack.peek()); // 输出：b
        // 3. 常见错误示例：若栈空时调用pop会抛出EmptyStackException
    }
}
```

#### 队列实现
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // 1. 基础用法：添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        // 2. 关键API调用：poll移除并返回前端元素，peek查看前端元素
        System.out.println(queue.poll()); // 输出：a（先进先出）
        System.out.println(queue.peek()); // 输出：b
        // 3. 常见错误示例：队列为空时poll返回null，不会抛异常
    }
}
```

#### 括号匹配
```java
import java.util.Stack;

public class BracketMatching {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 遇到左括号，压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 遇到右括号，检查栈是否为空
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                // 检查括号是否匹配
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // 栈空表示所有括号匹配成功
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("({[]})")); // true
        System.out.println(isValid("([)]")); // false
    }
}
```
**注解**：使用栈解决括号匹配问题，利用 LIFO 特性确保最近的左括号与当前右括号匹配。

#### 打印任务模拟
```java
import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        // 添加打印任务
        printQueue.offer("Document1");
        printQueue.offer("Document2");
        printQueue.offer("Document3");
        // 按顺序处理任务
        while (!printQueue.isEmpty()) {
            System.out.println("Printing: " + printQueue.poll());
        }
        // 输出：
        // Printing: Document1
        // Printing: Document2
        // Printing: Document3
    }
}
```
**注解**：队列的 FIFO 特性模拟了打印任务的先后顺序。

### 进阶实践

#### Kotlin基础语法示例
```kotlin
// 变量声明和数据类型
val name = "Kotlin"  // 不可变变量
var age = 20         // 可变变量
age = 21             // 可以重新赋值
val pi: Double = 3.14 // 显式类型声明

// 字符串模板
println("Hello, $name! Age: ${age + 1}") // 输出：Hello, Kotlin! Age: 22

// 控制流：if 作为表达式
val a = 5
val b = 10
val max = if (a > b) a else b // max = 10

// when 语句
val x = 5
when (x) {
    1 -> println("One")
    in 2..10 -> println("Between 2 and 10") // 输出此行
    else -> println("Other")
}

// for 循环
for (i in 1..5) { // 1到5
    println(i) // 输出 1 2 3 4 5
}
for (i in 1 until 5) { // 1到4
    println(i) // 输出 1 2 3 4
}

// while 循环
var i = 0
while (i < 5) {
    println(i) // 输出 0 1 2 3 4
    i++
}
```
**注解**：Kotlin 的语法简洁且强大，例如 `when` 比 Java 的 `switch` 更灵活，字符串模板减少了拼接的复杂性。

#### Kotlin OOP 和 Android Activity 综合实践
```kotlin
package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreate called")

        val dog = Dog("Max", "Golden Retriever")
        dog.speak() // 输出：Max makes a sound
        dog.bark()  // 输出：Max barks: Woof!

        val book = Book("Learn Kotlin")
        book.print() // 输出：Printing book: Learn Kotlin
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy called")
    }
}

open class Animal(val name: String) {
    fun speak() {
        Log.d("KotlinOOP", "$name makes a sound")
    }
}

class Dog(name: String, val breed: String) : Animal(name) {
    fun bark() {
        Log.d("KotlinOOP", "$name barks: Woof!")
    }
}

interface Printable {
    fun print()
}

class Book(val title: String) : Printable {
    override fun print() {
        Log.d("KotlinOOP", "Printing book: $title")
    }
}
```
**注解**：此代码展示了 Kotlin 的 OOP（类、继承、接口）与 Android Activity 生命周期的结合，`Log.d` 输出便于跟踪状态变化。

---

## 🎨 图解原理

### 栈
```
push顺序：a -> b -> c
栈结构：
[ c ] <- top
[ b ]
[ a ]
pop后：
[ b ] <- top
[ a ]
```

### 队列
```
enqueue顺序：a -> b -> c
队列结构：
[ a ] -> [ b ] -> [ c ]
       front       rear
dequeue后：
[ b ] -> [ c ]
       front    rear
```

**注解**：栈操作集中在一端，队列操作分前端和后端，图示直观展示了数据流的顺序。

---

## 🛠️ 常见问题清单

1. **Q：栈和队列的区别是什么？**  
   → 解答：栈是后进先出（LIFO），操作在顶部完成；队列是先进先出（FIFO），插入在后端，删除在前端。  
     示例：栈适合回溯（如撤销），队列适合顺序处理（如打印任务）。

2. **Q：括号匹配中栈为何为空时返回 false？**  
   → 解答：右括号出现时若栈为空，说明没有对应的左括号匹配。例如 `")"` 是无效的，栈空表示无待匹配符号。

---

## 🧠 记忆卡片

- `push`：栈的插入操作，将元素压入顶部。  
- `pop`：栈的删除操作，移除并返回顶部元素。  
- `enqueue`：队列的插入操作，将元素加入后端。  
- `dequeue`：队列的删除操作，移除并返回前端元素。  
- `val`：Kotlin 不可变变量，赋值后不可更改。  
- `var`：Kotlin 可变变量，可重新赋值。  
- `override`：Kotlin 中重写父类或接口方法的关键字。  

---

## 🚀 实战挑战

### 基础任务：最小栈
实现一个栈，支持 `push`、`pop`、`top` 和 `getMin` 操作，`getMin` 返回当前栈中的最小元素。
```java
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 只有当 x 小于等于当前最小值时才压入 minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 如果弹出的元素是最小值，minStack 也需同步弹出
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```
**注解**：使用辅助栈 `minStack` 跟踪最小值，确保 `getMin` 操作时间复杂度为 O(1)。

### 进阶任务：Kotlin 队列实现
实现一个支持 `enqueue`、`dequeue` 和 `getFront` 的队列。
```kotlin
import java.util.LinkedList

class MyQueue {
    private val list = LinkedList<Int>()

    fun enqueue(x: Int) {
        list.addLast(x)
    }

    fun dequeue(): Int {
        return list.removeFirst()
    }

    fun getFront(): Int {
        return list.first
    }
}
```
**注解**：利用 `LinkedList` 的双端特性实现队列，保持 FIFO 顺序。

---

## 🧭 导航

[⬅️ Day12 数组与链表](../stage2/day12.md)  
[➡️ Day14 排序算法](../stage2/day14.md)  
[🏠 返回目录](../../README.md)

---

