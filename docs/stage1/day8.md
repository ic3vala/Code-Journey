## Day8: 集合框架

### 1. 介绍

- 简介：Java集合框架是Java中用来处理数据集合的API，它提供了各种接口和实现类，用于存储、操作和遍历数据。

### 2. Collection接口

- 概述：Collection接口是Java集合框架中最基本的接口，它定义了对集合进行操作的方法。

- 常用方法：

  - `add(E e)`：添加元素

  - `clear()`：清空集合

  - `remove(E e)`：删除元素

  - `contains(Object obj)`：判断是否包含指定元素

  - `isEmpty()`：判断是否为空

  - `size()`：获取元素数量

  - `toArray()`：将集合转换为数组

### 3. List接口及其实现类

- 概述：List接口是有序集合，元素可以重复，并且有索引。

- 实现类：

  - `ArrayList`：基于动态数组实现，查询快，增删慢

  - `LinkedList`：基于双向链表实现，增删快，查询慢

- 示例代码：

  ```java
  import java.util.*;
  
  public class ArrayListExample {
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          list.add("Hello");
          list.add("World");
          list.add("HAHAHAHA");
          
          // 遍历方式1：增强for循环
          for (String str : list) {
              System.out.println(str);
          }
          
          // 遍历方式2：转换为数组
          String[] array = list.toArray(new String[0]);
          for (String str : array) {
              System.out.println(str);
          }
          
          // 遍历方式3：迭代器
          Iterator<String> iterator = list.iterator();
          while (iterator.hasNext()) {
              System.out.println(iterator.next());
          }
      }
  }
  ```

### 4. Set接口及其实现类

- 概述：Set接口是无序集合，元素不可重复，没有索引。

- 实现类：

  - `HashSet`：基于哈希表，插入顺序无序，查询快

  - `LinkedHashSet`：基于哈希表和链表，按插入顺序排序，查询快

  - `TreeSet`：基于红黑树，按自然顺序排序，查询快

- 示例代码：

  ```java
  import java.util.*;
  
  public class HashSetExample {
      public static void main(String[] args) {
          Set<String> set = new HashSet<>();
          set.add("Apple");
          set.add("Banana");
          set.add("Orange");
          set.add("Apple"); // 不会添加重复元素
          
          System.out.println("Set: " + set);
      }
  }
  ```

### 5. Queue接口及其实现类

- 概述：Queue接口是基于“先进先出”原则的集合，元素可以重复。

- 实现类：

  - `PriorityQueue`：按优先级排序的队列

  - `ArrayDeque`：双端队列，支持两端添加和删除元素

### 6. Map接口及其实现类

- 概述：Map接口是键值对集合，键唯一，值可重复。

- 实现类：

  - `HashMap`：基于哈希表，键无序

  - `LinkedHashMap`：基于哈希表和链表，键按插入顺序排序

  - `TreeMap`：基于红黑树，键按自然顺序排序

### 7. 集合类的选择

- 决策流程：

  1. 是否存储单个元素？如果是，选择Collection；否则，选择Map。

  2. 是否允许重复元素？如果允许，选择List；否则，选择Set。

  3. 是否需要顺序？如果需要，根据顺序类型选择LinkedList、ArrayList、LinkedHashSet等；否则，选择HashSet。

  4. 是否需要键值对？如果是，选择Map，并根据键的排序需求选择HashMap、LinkedHashMap或TreeMap。

### 8. 代码实验室

- 核心练习：

  - 使用ArrayList存储和遍历字符串
```java
import java.util.*;

public class ArrayListTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");

    for(String str : list) {
      System.out.print(str + " ");
    }
  }

}  
```

  - 使用HashSet去重
```java
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(4);

        System.out.println(set);


    }
}
```

  - 使用HashMap存储键值对
```java
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2dsfsa", 2);
        map.put("3I", 3);
        map.put("K", 4);
        map.put("uii", 5);
        System.out.println(map);
        System.out.println(map.get("K"));
        map.remove("uii");
        System.out.println(map);
    }
}

```

### 1. HashMap的哈希冲突解决机制

在HashMap中，哈希冲突是指多个键（key）经过哈希函数计算后，映射到同一个桶（bucket）中的情况。为了解决哈希冲突，HashMap采用了链地址法（Chaining）来处理。

具体来说，HashMap内部维护了一个数组，数组的每个槽位（slot）都是一个链表的头节点。当发生哈希冲突时，冲突的键值对会被添加到同一个链表中。这样，即使多个键映射到同一个桶，它们仍然可以被正确地存储和检索。

为了提高性能，HashMap在JDK 8中引入了一种优化机制，称为“树化”（tree bin）。当链表长度达到一定阈值（默认为8）时，链表会被转换为红黑树，以减少搜索时间。不过，这种优化在JDK 9中被移除了，因为发现它可能导致某些场景下的性能下降。

此外，HashMap还提供了`hash`方法来对键的hashCode进行扰动，以减少哈希冲突的可能性。这个方法在JDK 1.8中被引入，目的是提高哈希值的随机性，从而减少冲突。

### 2. ArrayList的动态扩容原理

ArrayList是一个动态数组，当数组满了时，它会自动进行扩容。在Java中，ArrayList的扩容机制如下：

- 默认情况下，ArrayList的初始容量是10。也就是说，当创建一个不带初始容量参数的ArrayList时，它的容量为10。

- 当添加的元素超过当前容量时，ArrayList会进行扩容。扩容的策略是：创建一个新的数组，大小为原数组大小的1.5倍，然后将原数组的所有元素复制到新数组中，并将引用指向新的数组。

- 在添加元素时，ArrayList会检查当前容量是否足够，如果不够，则进行扩容。

- 扩容操作是一个消耗性能的操作，因此在创建ArrayList时，如果已知需要存储的元素数量，建议指定初始容量，以避免不必要的扩容操作。

### 3. Iterator遍历的安全性问题

在Java中，Iterator是用来遍历集合的迭代器。为了保证在遍历过程中集合不会被修改，Iterator提供了一个`remove`方法，允许在遍历时删除当前迭代的元素。

然而，如果在遍历过程中对集合进行添加、删除或其他修改操作，可能会导致`ConcurrentModificationException`异常，这是为了防止在迭代过程中集合被意外地修改。

为了解决这个问题，可以使用迭代器的`remove`方法来安全地删除元素，或者使用迭代器的`forEachRemaining`方法来遍历剩余的元素。

此外，Java还提供了`ListIterator`接口，它扩展了`Iterator`接口，提供了双向遍历的功能，并且也可以使用`set`方法来替换当前元素。

总之，在使用Iterator遍历时，要确保在遍历过程中不修改集合，除非使用Iterator提供的安全删除方法。


### 9. 导航

- [⬅️ Day7 异常处理](./day7.md)

- [➡️ Day9 文件与IO](./day9.md)

- [🏠 返回目录](../../README.md)
