package com.lyh.day10.Model;

public class DepositThread implements Runnable {
    private BankAccount account;
    private int depositTimes;

    public DepositThread(BankAccount account, int depositTimes) {
        this.account = account;
        this.depositTimes = depositTimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < depositTimes; i++) {
            int amount = (int) (Math.random() * 1000) + 100;
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + "存款 " + amount);
        }
    }
}
