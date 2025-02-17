package com.lyh.day10.Model;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance = new AtomicInteger(0);

    public void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public int getBalance() {
        return balance.get();
    }
}
