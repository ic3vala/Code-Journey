## Day10: [多线程基础]

## 🧩 核心概念

- **什么是多线程？**

    - 多线程是指在单个程序中同时运行多个线程，每个线程可以独立执行不同的任务。通过多线程，程序可以同时处理多个任务，提高效率和响应速度。

- **多线程的作用？**

    - 多线程的主要作用是提高程序的效率和性能。它可以允许程序同时执行多个任务，减少等待时间，充分利用系统资源。

- **多线程的应用场景？**

    - 多线程广泛应用于各种场景，特别是在需要处理耗时操作、实现并发处理或提高用户交互体验的情况下。例如：

        - **软件中的耗时操作**：如下载、计算等，可以使用多线程来异步处理，避免界面冻结。

        - **聊天软件**：需要实时接收和发送消息，多线程可以分别处理接收和发送任务。

        - **服务器**：处理多个客户端的请求，多线程可以同时处理多个连接，提高响应速度。

- **并发与并行**

    - **并发**：在同一时刻，有多个指令在单个CPU上交替执行。由于现代CPU的速度非常快，给人以多个任务同时执行的错觉。

    - **并行**：在同一时刻，有多个指令在多个CPU上同时执行。这需要多核处理器的支持，真正实现同时执行多个任务。

    - 理解并发和并行的区别对于合理设计多线程程序非常重要。在单个CPU上，多线程实现的是并发，而不是并行。只有在多核处理器上，多线程才能实现真正的并行执行。

### 示例代码

以下是一个简单的Java多线程示例，演示了如何创建和启动一个线程：

```java
public class MultiThreadDemo {
    public static void main(String[] args) {
        // 创建线程对象
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程运行中...");
            }
        });

        // 启动线程
        thread.start();

        System.out.println("主线程运行中...");
    }
}
```

在这个例子中，我们创建了一个新的线程，它独立于主线程执行。主线程和子线程可以同时执行各自的代码，从而实现多任务处理。

## 关键概念2

### 1. 线程生命周期

在Java中，线程有多种生命周期状态，包括：

- **New**：线程被创建但尚未启动。

- **Runnable**：线程已启动，正在运行或准备运行。

- **Blocked**：线程被阻塞，等待某个条件。

- **Waiting**：线程进入等待状态，通常在等待其他线程的通知。

- **Timed_waiting**：线程进入等待状态，但设置了超时时间。

- **Terminated**：线程已完成执行，处于终止状态。

这些状态是线程在其生命周期中可能经历的不同阶段。理解这些状态有助于管理线程的行为和资源。

### 2. `synchronized` 关键字的作用域

`synchronized`关键字用于实现线程同步，防止多个线程同时访问共享资源，从而引发数据不一致的问题。

- **作用域**：

    - **方法级**：将整个方法声明为`synchronized`，确保同一时间只有一个线程执行该方法。

    - **代码块级**：在代码块中使用`synchronized`，指定同步锁对象，确保同一时间只有一个线程执行该代码块。

- **锁对象**：`synchronized`关键字需要一个锁对象，通常是对象的引用。多个线程竞争同一锁对象，只有获得锁的线程才能执行同步代码。

正确使用`synchronized`关键字可以避免线程安全问题，但过度使用可能导致性能下降，因此需要权衡。

### 3. 线程安全与原子操作

- **线程安全**：指多个线程并发访问共享资源时，能够保证数据的一致性和完整性。

- **原子操作**：指不可分割的操作，确保操作在执行过程中不会被其他线程干扰。

在多线程环境中，原子操作是保证线程安全的关键。Java提供了多种机制来实现原子操作，包括`synchronized`关键字、`volatile`关键字、原子类（如`AtomicInteger`）以及锁机制。

理解这些概念对于编写高效、安全的多线程程序至关重要。在实际开发中，应优先使用高级的原子类，以减少锁的使用，提高性能。

### 示例代码

以下是一个简单的示例，展示了`synchronized`关键字的使用：

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

在这个例子中，`increment`方法使用`synchronized`关键字，确保每次只有一个线程能够修改`count`变量，从而避免了线程安全问题。

另一个例子是使用原子类`AtomicInteger`：

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```

这里，`AtomicInteger`提供了原子性的增减操作，无需使用`synchronized`，提高了性能。

## 💻 代码实验室

### 核心练习

1. **模拟银行账户多线程存款（解决竞争问题）**
- [BankAccount类](./src/main/java/com/lyh/day10/Model/BankAccount.java)
- [DepositThread类](./src/main/java/com/lyh/day10/Model/DepositThread.java)
- [Main](./src/main/java/com/lyh/day10/Main.java)
2. **用`Runnable`和`Thread`创建线程**
- 首先，使用Runnable接口创建线程
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "RunnableThread");
        thread.start();
    }
}

```
- 然后，使用Thread子类创建线程
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

```
3. **实现生产者-消费者模型（拓展）**

## 🧭 导航

[⬅️ Day9 文件与IO](./day9.md)

[➡️ Day11 JSON处理](./day11.md)

[🏠 返回目录](../../README.md)
