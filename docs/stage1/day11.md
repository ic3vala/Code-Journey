

# Day11: [JSON处理]

## 🧩 核心概念
### 什么是 JSON？
就像网购时填写的收货地址单，JSON 是一种**标准格式**，用来表示结构化的数据。例如：
```json
{
  "name": "张三",
  "age": 25,
  "isStudent": true
}
```

### 为什么要序列化？
- **序列化**：把 Java 对象 → JSON 字符串（像把衣服叠进行李箱）
- **反序列化**：把 JSON 字符串 → Java 对象（像从行李箱拿出衣服）

---

## 💻 代码实验室
### 第一步：安装工具箱（添加 Gson 依赖）
在项目的 `pom.xml` 文件中添加（类似给手机安装APP）：
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

### 第二步：定义数据模型（创建Java类）
```java
// 就像设计一张个人信息登记表
class Person {
    // @SerializedName 作用：指定JSON字段名（类似表格列标题）
    @SerializedName("full_name") 
    private String name;
    
    private int age;
    
    // transient 表示临时字段，不参与序列化（类似备注，不打印到纸上）
    private transient String password; 

    // 必须要有无参构造方法（Gson创建对象时需要）
    public Person() {}

    // 全参构造方法（方便创建对象）
    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    // Getter 和 Setter 方法（Gson通过反射访问字段）
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // 其他getter/setter省略...
}
```

### 第三步：序列化（对象 → JSON）
```java
public class JsonDemo {
    public static void main(String[] args) {
        // 1. 创建Gson工具实例（就像拿到一个转换器）
        Gson gson = new Gson();
        
        // 2. 创建一个Java对象（填写登记表）
        Person person = new Person("李小花", 25, "123456");
        
        // 3. 序列化操作（把表格转换成JSON字符串）
        String jsonStr = gson.toJson(person);
        
        // 打印结果：{"full_name":"李小花","age":25}
        System.out.println("生成的JSON: " + jsonStr); 
    }
}
```
**关键现象观察**：
- `password` 字段没有出现在JSON中（因为被标记为transient）
- Java字段名`name`变成了JSON中的`full_name`

### 第四步：反序列化（JSON → 对象）
```java
// 接上面的main方法
// 4. 准备一个JSON字符串（就像收到别人发来的数据）
String receivedJson = "{\"full_name\":\"王大明\",\"age\":30}";

// 5. 反序列化操作（把JSON解析成Java对象）
Person newPerson = gson.fromJson(receivedJson, Person.class);

// 6. 验证结果
System.out.println("姓名: " + newPerson.getName()); // 输出 王大明
System.out.println("年龄: " + newPerson.getAge());  // 输出 30
System.out.println("密码: " + newPerson.getPassword()); // 输出 null（因为原始JSON没有这个字段）
```

---

## 📖 核心原理图示
```
         序列化
Java对象  ──────▶ JSON字符串
         ◀──────
         反序列化

Gson 的工作流程：
1. 扫描类的字段
2. 根据注解调整字段名称
3. 忽略 transient 字段
4. 自动处理基本类型和字符串
```

---

## 🧠 记忆卡片
| 术语       | 类比                 | 作用                          |
|------------|----------------------|-------------------------------|
| @SerializedName | 贴标签       | 指定Java字段对应的JSON字段名   |
| transient  | "临时"贴纸           | 标记不参与序列化的字段          |
| Gson实例   | 翻译官               | 负责对象与JSON之间的转换        |

---

## 🚀 动手尝试
修改 Person 类：
1. 添加 `@SerializedName("user_age")` 到 age 字段
2. 新增一个普通字段 `String email`
3. 观察序列化后的JSON变化

---

## 🧭 导航
[⬅️ Day10 多线程基础](./day10.md)  
[➡️ Day12 数组与链表](../stage2/day12.md)  
[🏠 返回目录](../../README.md)