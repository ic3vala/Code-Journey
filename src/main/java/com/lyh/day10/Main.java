package com.lyh.day10;

import com.lyh.day10.Model.BankAccount;
import com.lyh.day10.Model.DepositThread;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        int depositTimes = 10;
        Thread thread1 = new Thread(new DepositThread(account, depositTimes), "客户1");
        Thread thread2 = new Thread(new DepositThread(account, depositTimes), "客户2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终余额: " + account.getBalance());
    }
}
