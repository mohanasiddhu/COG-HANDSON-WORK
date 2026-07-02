package com.spring.di.enhanced.beans;

import com.spring.di.enhanced.services.PaymentService;

/**
 * OrderProcessor with Constructor Injection
 *
 * Constructor injection is preferred because: 1. Dependencies are immutable
 * (final fields possible) 2. All required dependencies must be provided at
 * construction 3. Dependencies cannot be null (fail-fast principle) 4. Makes
 * testing easier (can pass mock objects to constructor)
 */
public class OrderProcessor {

    // Immutable dependency
    private final PaymentService paymentService;
    private final String processorName;

    // Constructor injection - all dependencies provided via constructor
    public OrderProcessor(PaymentService paymentService, String processorName) {
        this.paymentService = paymentService;
        this.processorName = processorName;
        System.out.println("[OrderProcessor] Created with Constructor Injection - Name: " + processorName);
    }

    // Process order method
    public void processOrder(String orderId, double orderAmount) {
        System.out.println("\n[OrderProcessor] Processing order: " + orderId);
        System.out.println("  Processor Name: " + processorName);

        double transactionFee = paymentService.getTransactionFee();
        double totalAmount = orderAmount + transactionFee;

        System.out.println("  Order Amount: $" + orderAmount);
        System.out.println("  Transaction Fee: $" + transactionFee);
        System.out.println("  Total Amount: $" + totalAmount);

        // Process payment using injected PaymentService
        paymentService.processPayment(orderId, totalAmount);

        System.out.println("  Order processed successfully!");
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public String getProcessorName() {
        return processorName;
    }
}
