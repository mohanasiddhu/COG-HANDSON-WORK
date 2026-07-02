package com.spring.aop.basic.services;

import java.util.HashMap;
import java.util.Map;

/**
 * BankAccountService implementation Target object for AOP advice
 */
public class BankAccountServiceImpl implements BankAccountService {

    // Simple in-memory account storage
    private static Map<String, Double> accounts = new HashMap<>();

    static {
        accounts.put("ACC001", 1000.0);
        accounts.put("ACC002", 2000.0);
        accounts.put("ACC003", 500.0);
    }

    @Override
    public void deposit(String accountId, double amount) {
        System.out.println("[BankService] Depositing $" + amount + " to account " + accountId);
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        double currentBalance = accounts.getOrDefault(accountId, 0.0);
        accounts.put(accountId, currentBalance + amount);
        System.out.println("[BankService] Deposit successful");
    }

    @Override
    public void withdraw(String accountId, double amount) {
        System.out.println("[BankService] Withdrawing $" + amount + " from account " + accountId);
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        double currentBalance = accounts.getOrDefault(accountId, 0.0);
        if (currentBalance < amount) {
            throw new IllegalStateException("Insufficient balance! Current: $" + currentBalance);
        }
        accounts.put(accountId, currentBalance - amount);
        System.out.println("[BankService] Withdrawal successful");
    }

    @Override
    public double getBalance(String accountId) {
        System.out.println("[BankService] Getting balance for account " + accountId);
        return accounts.getOrDefault(accountId, 0.0);
    }

    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {
        System.out.println("[BankService] Transferring $" + amount + " from " + fromAccount + " to " + toAccount);
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
        System.out.println("[BankService] Transfer successful");
    }
}
