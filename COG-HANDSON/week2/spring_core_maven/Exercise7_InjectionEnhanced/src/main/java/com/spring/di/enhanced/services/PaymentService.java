package com.spring.di.enhanced.services;

/**
 * Payment Service interface
 */
public interface PaymentService {

    void processPayment(String transactionId, double amount);

    double getTransactionFee();
}

/**
 * Credit Card Payment Service implementation
 */
class CreditCardPaymentService implements PaymentService {

    @Override
    public void processPayment(String transactionId, double amount) {
        System.out.println("Processing credit card payment - Transaction: " + transactionId + ", Amount: $" + amount);
    }

    @Override
    public double getTransactionFee() {
        return 2.5; // $2.50 fee
    }
}

/**
 * Digital Wallet Payment Service implementation
 */
class DigitalWalletPaymentService implements PaymentService {

    @Override
    public void processPayment(String transactionId, double amount) {
        System.out.println("Processing digital wallet payment - Transaction: " + transactionId + ", Amount: $" + amount);
    }

    @Override
    public double getTransactionFee() {
        return 1.0; // $1.00 fee
    }
}
