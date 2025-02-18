## Day9: [文件与IO]

## 🧩 核心概念

- 什么是IO流？

    - IO流是Java中用于处理输入和输出操作的一系列类和接口的集合。

    - "I"代表输入（Input），"O"代表输出（Output）。

    - 流（Stream）是指数据的顺序集合，可以是字节流（byte）或字符流（char）。

- IO流的作用？

    - 用于读写数据，包括本地文件、网络数据等。

    - 通过IO流，可以方便地处理文件的创建、读取、写入和删除等操作。

- IO流的分类

    - 按流向分类

        - 输入流（`InputStream`/`Reader`）：从数据源（如文件、网络）读取数据到程序中。

        - 输出流（`OutputStream`/`Writer`）：将程序中的数据写入到数据源（如文件、网络）。

    - 按操作数据类型分类

        - 字节流（byte）：可以操作所有类型的文件，包括二进制文件

        - 字符流（char）：只能操作纯文本文件

- **字节流 vs 字符流**

    - **字节流**：处理二进制数据，如图像、音频等，使用字节作为基本单位，例如`InputStream`和`OutputStream`。

    - **字符流**：处理文本数据，使用字符作为基本单位，考虑了字符编码，例如`Reader`和`Writer`。

    - 选择哪种流取决于要处理的数据类型。对于文本文件，通常使用字符流；对于二进制文件，使用字节流。

- **Serializable接口与版本控制**

    - **Serializable接口**：是一个标记接口，表示实现该接口的类的对象可以被序列化。

    - **版本控制**：序列化版本标识符（`serialVersionUID`）用于确保反序列化时类的版本兼容性。如果类的结构发生变化，可能需要更新这个标识符，以防止反序列化时的不兼容问题。

- **BufferedReader性能优化**

    - `BufferedReader`通过内置的缓冲区来提高读取性能，减少对底层文件系统的访问次数。

    - 可以通过指定缓冲区大小来优化性能，例如`new BufferedReader(new FileReader(file), bufferSize)`。

    - 适当调整缓冲区大小可以提高读取效率，但需要根据实际应用场景和数据量来决定。

## 🧩 核心概念
### **1. `Files.readAllLines()` 方法解析**
#### **功能**
**一次性读取文件所有行**，返回 `List<String>`（每行作为列表元素）。

#### **代码示例**
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileDemo {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("test.txt");
        List<String> lines = Files.readAllLines(path); // 默认使用 UTF-8 编码
        lines.forEach(System.out::println);
    }
}
```

#### **重载方法**
```java
// 指定字符编码
List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
```

#### **特点**
- **优点**：代码简洁，适合小文件快速读取。
- **缺点**：
    - 全量加载到内存，大文件可能导致 `OutOfMemoryError`。
    - 无法逐行处理（需要全部读取后才操作）。

---

### **2. 其他常用 NIO 快捷方法**
#### **(1) `Files.readAllBytes()`**
- **功能**：读取文件所有字节到 `byte[]`。
- **适用场景**：二进制文件（如图片、视频）。
```java
byte[] data = Files.readAllBytes(path);
```

#### **(2) `Files.write()`**
- **功能**：写入内容到文件（覆盖模式）。
- **支持数据类型**：`byte[]`、`Iterable<String>`（如 `List<String>`）。
```java
// 写入字符串列表（每行一个元素）
List<String> content = Arrays.asList("Line 1", "Line 2");
Files.write(path, content, StandardCharsets.UTF_8);

// 追加写入（需指定 OpenOption）
Files.write(path, content, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
```

#### **(3) `Files.newBufferedReader()` / `Files.newBufferedWriter()`**
- **功能**：创建带缓冲的读写流（适合大文件逐行处理）。
```java
// 读取大文件（逐行处理，避免内存溢出）
try (BufferedReader reader = Files.newBufferedReader(path)) {
    String line;
    while ((line = reader.readLine()) != null) {
        // 处理每行
    }
}

// 写入文件
try (BufferedWriter writer = Files.newBufferedWriter(path)) {
    writer.write("Hello, NIO!");
}
```

#### **(4) `Files.lines()`（Java 8+）**
- **功能**：返回 `Stream<String>`，**惰性读取**文件内容。
- **优势**：适合大文件逐行处理，内存友好。
```java
try (Stream<String> stream = Files.lines(path)) {
    stream.filter(line -> line.contains("error"))
          .forEach(System.out::println);
}
```

---

### **3. 核心注意事项**
#### **(1) 编码问题**
- 默认使用 `UTF-8`，若文件编码不同需显式指定：
  ```java
  Files.readAllLines(path, StandardCharsets.GBK);
  ```

#### **(2) 异常处理**
- 所有方法均可能抛出 `IOException`，需捕获或声明抛出：
  ```java
  try {
      List<String> lines = Files.readAllLines(path);
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```

#### **(3) 大文件处理**
- **避免使用** `readAllLines()` / `readAllBytes()`，改用流式处理：
  ```java
  // 使用 Files.lines() 的 Stream
  Files.lines(path).parallel().forEach(line -> process(line));
  ```

---

### **4. 性能对比**
| **方法**               | **内存占用** | **速度** | **适用场景**               |
|------------------------|-------------|---------|---------------------------|
| `readAllLines()`       | 高           | 快       | 小文本文件（<100MB）       |
| `lines()` + Stream     | 低           | 中等     | 大文件逐行处理             |
| `newBufferedReader()`  | 低           | 中等     | 需要精细控制读取流程       |

---

### **5. 典型应用场景**
1. **配置文件读取**
   ```java
   // 快速读取 properties 文件
   Map<String, String> config = Files.lines(configPath)
       .map(line -> line.split("="))
       .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
   ```

2. **日志文件分析**
   ```java
   // 统计 ERROR 日志数量
   long errorCount = Files.lines(logPath)
                          .filter(line -> line.contains("ERROR"))
                          .count();
   ```

3. **快速复制文件**
   ```java
   byte[] data = Files.readAllBytes(sourcePath);
   Files.write(targetPath, data);
   ```

---

### **总结**
- **小文件**：优先用 `readAllLines()` / `readAllBytes()`，代码简洁。
- **大文件**：使用 `Files.lines()` 或 `BufferedReader` 流式处理。
- **编码敏感场景**：始终显式指定字符集。

## 💻 代码实验室

### 核心练习

### 1. 实现CSV文件解析器（读取为对象列表）

首先，定义一个Student类，包含姓名、年龄和成绩等属性，并提供相应的构造方法和getter/setter方法。

```java
public class Student {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // getters and setters omitted for brevity
}
```

然后，编写解析CSV文件的代码：

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) {
        List<Student> students = parseCSV("students.csv");
        for (Student student : students) {
            System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getScore());
        }
    }

    public static List<Student> parseCSV(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    double score = Double.parseDouble(fields[2]);
                    students.add(new Student(name, age, score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
```

### 2. 将学生信息序列化到文件

首先，确保Student类实现了Serializable接口。

```java
import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // getters and setters omitted for brevity
}
```

然后，编写序列化List到文件的代码：

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationDemo {
    public static void main(String[] args) {
        List<Student> students = parseCSV("students.csv");
        serialize(students, "students.ser");
    }

    public static void serialize(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


[⬅️ Day8 集合框架](./day8.md)
[➡️ Day10 多线程基础](./day10.md)
[🏠 返回目录](../../README.md)
