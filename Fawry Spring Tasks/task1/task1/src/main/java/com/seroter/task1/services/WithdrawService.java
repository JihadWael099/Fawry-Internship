package com.seroter.task1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WithdrawService {
    private final BalanceService balanceService;

    @Autowired
    public WithdrawService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balanceService.getBalance()) {
            balanceService.deductBalance(amount);
            System.out.println("withdeow success  and New balance: " + balanceService.getBalance());
        }
        else {
            System.out.println("invalid amount");
        }
    }
}
