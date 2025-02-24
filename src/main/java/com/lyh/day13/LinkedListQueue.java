package com.lyh.day13;

public class LinkedListQueue<T> {
    private Node front;
    private Node rear;
    private int size;
    public LinkedListQueue() {
        this.front = new Node(null);
        this.rear = this.front;
        this.size = 0;

    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (front == rear) {
            front = null;
            rear = null;
            size--;
        }else{
            front = front.next;
            size--;
        }

    }
    public void peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        System.out.println("font: " + front.data);
        System.out.println("rear: " + rear.data);

    }
    public void printQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Node temp = front;
        while (temp != rear) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.print(rear.data + "\n");
    }


}
