package com.seroter.task1.services;

import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private double balance = 1000;
    public double getBalance() {
        return balance;
    }
    public void deductBalance(double amount) {
            balance -= amount;
    }
}
