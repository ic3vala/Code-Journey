package com.lyh.day13;


public class LinkedListStack<T> {
    private Node<T> head;
    private Node<T> current;
    private int size;
    public LinkedListStack() {
        this.head = new Node<>(null);
        this.current = head;
        this.size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        current.next = newNode;
        current = newNode;
        size++;


    }
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Node<T> temp = head.next;
        while (temp.next.next != null) {
            temp = temp.next;


        }
        temp.next = null;
        current = temp;
        size--;

    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return current.data;

    }
    public int size() {
        return size;
    }
    public void printStack() {
        Node<T> temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }


}
