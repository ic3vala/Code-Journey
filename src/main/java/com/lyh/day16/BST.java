package com.lyh.day16;

public class BST {
    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);
        if (key < node.getVal()) node.left = insertRec(node.left, key);
        else if (key > node.getVal()) node.right = insertRec(node.right, key);
        return node;
    }

    public TreeNode search(int key) {
        return searchRec(root, key);
    }

    private TreeNode searchRec(TreeNode node, int key) {
        if (node == null || node.getVal() == key) return node;
        if (key < node.getVal()) return searchRec(node.left, key);
        return searchRec(node.right, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode node, int key) {
        if (node == null) return null;
        if (key < node.getVal()) node.left = deleteRec(node.left, key);
        else if (key > node.getVal()) node.right = deleteRec(node.right, key);
        else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode successor = findMin(node.right);
            node.setVal(successor.getVal());
            node.right = deleteRec(node.right, successor.getVal());
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private TreeNode prev = null;

    public boolean isValidBST() {
        prev = null;
        return isValidBSTRec(root);
    }

    private boolean isValidBSTRec(TreeNode node) {
        if (node == null) return true;
        if (!isValidBSTRec(node.left)) return false;
        if (prev != null && node.getVal() <= prev.getVal()) return false;
        prev = node;
        return isValidBSTRec(node.right);
    }

    public TreeNode getRoot() {
        return root;
    }
}
