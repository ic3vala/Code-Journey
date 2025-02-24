package com.lyh.day13;

public class LinkedListStackTest {
    public static void main(String[] args) {

        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        System.out.println("==============");
        System.out.println(stack.size());
        System.out.println("==============");
        stack.printStack();
        System.out.println("==============");
        stack.pop();
        stack.printStack();
        stack.pop();
        System.out.println("==============");
        stack.printStack();
    }
}
