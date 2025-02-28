package com.lyh.day16;


public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        //root.printTree(root);
        //先序遍历
        root.preOrder(root);
        System.out.println();

        //中序遍历
        root.inOrder(root);
        System.out.println();

        //后序遍历
        root.postOrder(root);
        System.out.println();


    }
}
