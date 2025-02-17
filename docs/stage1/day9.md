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
