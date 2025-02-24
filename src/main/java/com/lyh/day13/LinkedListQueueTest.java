package com.lyh.day13;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<String> testQueue = new LinkedListQueue<>();
        testQueue.enqueue("a");
        testQueue.enqueue("b");
        testQueue.enqueue("c");
        testQueue.enqueue("d");
        testQueue.enqueue("e");
        testQueue.printQueue();
        testQueue.dequeue();
        testQueue.printQueue();
        testQueue.enqueue("dfasd");
        testQueue.printQueue();
        for (int i = 0; i < 5; i++) {
            testQueue.dequeue();
        }
        testQueue.printQueue();
    }
}
