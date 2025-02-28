package com.lyh.day16;


public class TreeTest {
       public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        TreeNode root = bst.getRoot();
        System.out.println("中序遍历：");
        root.inOrder(root); // 输出：20 30 40 50 70
        System.out.println("\n查找 40：" + (bst.search(40) != null)); // true
        bst.delete(30);
        System.out.println("删除 30 后中序遍历：");
        root.inOrder(root); // 输出：20 40 50 70
        System.out.println("\n是否为有效 BST：" + bst.isValidBST()); // true
    }
}
