package com.spring.aop.basic.services;

/**
 * Bank Account Service interface
 */
public interface BankAccountService {

    void deposit(String accountId, double amount);

    void withdraw(String accountId, double amount);

    double getBalance(String accountId);

    void transfer(String fromAccount, String toAccount, double amount);
}
