

# Day 16: [树与图基础]

## 核心概念
### 基础理论
- **概念1：树（Tree）**  
  - **一句话定义**：树是一种分层的数据结构，由节点和边组成，具有唯一的根节点和分级的子节点。  
  - **生活类比**：树就像家族族谱，根节点是祖先，子节点是后代，叶子节点是没有子嗣的成员。  

- **概念2：二叉搜索树（BST）**  
  - **一句话定义**：BST 是一种特殊的二叉树，满足左子树所有节点值 < 根节点值 < 右子树所有节点值。  
  - **与普通二叉树的异同**：  
    - **相同点**：都是二叉树，每个节点最多有两个子节点（左子节点和右子节点）。  
    - **不同点**：BST 具有严格的排序规则，支持高效的查找、插入和删除操作，而普通二叉树无此约束。  

### 关键特性对比
| 特性/操作  | 二叉树            | 二叉搜索树（BST）        |
| ---------- | ----------------- | ------------------------ |
| 时间复杂度 | 查找 O(n)（最坏） | 查找 O(log n)（平均）    |
| 空间复杂度 | O(n)              | O(n)                     |
| 适用场景   | 层级数据存储      | 有序数据查找、插入、删除 |

---

## 代码实验室
### 基础语法示例
```java
// BST 节点类定义
public class Node {
    int key;         // 节点值
    Node left;       // 左子节点指针
    Node right;      // 右子节点指针
    public Node(int key) {
        this.key = key;
        this.left = null;  // 默认左右子节点为空
        this.right = null;
    }
}

// BST 类定义及基本操作
public class BST {
    private Node root;  // 根节点
    public BST() {
        this.root = null;  // 初始化为空树
    }

    // 插入操作（递归）
    public void insert(int key) {
        root = insertRec(root, key);
    }
    private Node insertRec(Node root, int key) {
        if (root == null) {  // 找到插入位置
            return new Node(key);
        }
        if (key < root.key) {  // 插入值小于根，递归左子树
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {  // 插入值大于根，递归右子树
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // 查找操作（递归）
    public Node search(int key) {
        return searchRec(root, key);
    }
    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {  // 找到或不存在
            return root;
        }
        if (key < root.key) {  // 查找值小于根，递归左子树
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);  // 查找值大于根，递归右子树
    }
}
```

### 进阶实践
```java
// BST 删除操作
public void delete(int key) {
    root = deleteRec(root, key);
}
private Node deleteRec(Node root, int key) {
    if (root == null) return null;  // 树为空，直接返回
    if (key < root.key) {  // 删除值小于根，递归左子树
        root.left = deleteRec(root.left, key);
    } else if (key > root.key) {  // 删除值大于根，递归右子树
        root.right = deleteRec(root.right, key);
    } else {
        // 找到要删除的节点，分三种情况处理
        // 情况1: 叶子节点，直接删除
        if (root.left == null && root.right == null) return null;
        // 情况2: 只有一个子节点，返回非空子节点
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 情况3: 有两个子节点，用右子树最小值（后继）替换
        Node successor = findMin(root.right);
        root.key = successor.key;
        root.right = deleteRec(root.right, successor.key);
    }
    return root;
}

// 查找右子树最小值（后继）
private Node findMin(Node node) {
    while (node.left != null) node = node.left;  // 一直向左走
    return node;
}
```

## 常见问题清单
1. **Q：为什么 BST 的查找效率比普通二叉树高？**  
   → **解答**：BST 利用了二分查找的思想，通过比较节点值快速排除一半的搜索空间，平均时间复杂度为 O(log n)。而普通二叉树没有排序规则，最坏情况下（如退化为链表）查找复杂度为 O(n)。  

2. **Q：删除 BST 节点时，为什么要用后继节点替换？**  
   → **解答**：当删除的节点有两个子节点时，用右子树的最小值（后继节点）替换，能保证 BST 的性质（左 < 根 < 右）不被破坏，因为后继节点大于左子树所有值，小于右子树其他值。

---

## 记忆卡片
```markdown
- `BST`：左子树 < 根 < 右子树。
- `插入`：递归找到空位插入。
- `删除`：根据子节点数量分情况处理（无子节点/单子节点/双子节点）。
```

## 实战挑战
### 基础任务
```java
// 实现中序遍历 BST，验证其有序性
public void inOrderTraversal(Node node) {
    if (node != null) {
        inOrderTraversal(node.left);    // 先遍历左子树
        System.out.print(node.key + " ");  // 访问根节点
        inOrderTraversal(node.right);   // 再遍历右子树
    }
}
```

### 进阶任务

```java
// 实现 BST 的非递归插入操作
public void insertIterative(int key) {
    Node newNode = new Node(key);
    if (root == null) {
        root = newNode;
        return;
    }
    Node current = root;
    while (true) {
        if (key < current.key) {
            if (current.left == null) {
                current.left = newNode;
                break;
            }
            current = current.left;
        } else if (key > current.key) {
            if (current.right == null) {
                current.right = newNode;
                break;
            }
            current = current.right;
        } else {
            break;  // 重复值不插入
        }
    }
}
// 提示：使用循环和指针遍历，避免递归开销
```

### 进阶任务
```java
// 实现 BST 的非递归插入操作
public void insertIterative(int key) {
    Node newNode = new Node(key);
    if (root == null) {
        root = newNode;
        return;
    }
    Node current = root;
    while (true) {
        if (key < current.key) {
            if (current.left == null) {
                current.left = newNode;
                break;
            }
            current = current.left;
        } else if (key > current.key) {
            if (current.right == null) {
                current.right = newNode;
                break;
            }
            current = current.right;
        } else {
            break;  // 重复值不插入
        }
    }
}
// 提示：使用循环和指针遍历，避免递归开销
```



## 导航

[⬅️ Day15 哈希表](../stage2/day15.md)  
[➡️ Day17 网络请求](../stage3/day17.md)  
[🏠 返回目录](../../README.md)