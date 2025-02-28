package com.lyh.day16;

public class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.val = value;
    }

    public int getVal() {

        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.println("根节点：" + root.val);
        if (root.left != null) {
            System.out.println("左子节点：" + root.left.val);
        }
        if (root.right != null) {
            System.out.println("右子节点：" + root.right.val);
        }
    }

    public void preOrder(TreeNode node) {
        if (node == null) return;
        // 第一步：处理当前节点（打印）
        System.out.print(node.val + " ");
        // 第二步：递归左子树
        preOrder(node.left);
        // 第三步：递归右子树
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);

    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

}
