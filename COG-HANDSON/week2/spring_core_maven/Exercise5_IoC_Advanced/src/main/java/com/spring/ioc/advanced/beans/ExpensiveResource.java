package com.spring.ioc.advanced.beans;

/**
 * Lazy-initialized bean
 */
public class ExpensiveResource {

    public ExpensiveResource() {
        System.out.println("Creating ExpensiveResource - this is expensive!");
        try {
            // Simulate expensive initialization
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("ExpensiveResource created successfully");
    }

    public void doWork() {
        System.out.println("ExpensiveResource is doing work...");
    }
}
