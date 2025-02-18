package com.lyh.day10;

public class ThreadGo {
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyThread2()).start();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...using extends thread");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...by runnable");
    }
}