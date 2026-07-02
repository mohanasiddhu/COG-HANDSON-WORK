package com.spring.aop.basic.main;

import com.spring.aop.basic.services.BankAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 8: Implementing Basic AOP with Spring
 *
 * This application demonstrates: 1. Multiple Aspects working together 2.
 * Performance Monitoring (Around, Before, AfterReturning, AfterThrowing) 3.
 * Security Auditing (Before, After) 4. Cross-cutting concerns: Performance,
 * Validation, Auditing, Error Handling 5. Pointcuts with OR conditions 6.
 * Exception handling in AOP
 */
public class BasicAOPDemo {

    public static void main(String[] args) {
        System.out.println("=== Basic Spring AOP Demo ===");
        System.out.println("Demonstrates: Performance Monitoring & Security Auditing\n");

        // Create ApplicationContext with AOP enabled
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the proxied BankAccountService bean
        BankAccountService bankService = context.getBean("bankAccountService", BankAccountService.class);

        System.out.println("======================================");
        System.out.println("Test 1: Get Balance (Read Operation)");
        System.out.println("======================================");
        double balance = bankService.getBalance("ACC001");
        System.out.println("Final Balance: $" + balance);

        System.out.println("\n======================================");
        System.out.println("Test 2: Deposit (Write Operation)");
        System.out.println("======================================");
        bankService.deposit("ACC001", 500.0);
        System.out.println("New Balance: $" + bankService.getBalance("ACC001"));

        System.out.println("\n======================================");
        System.out.println("Test 3: Withdraw (Sensitive Operation)");
        System.out.println("======================================");
        bankService.withdraw("ACC001", 300.0);
        System.out.println("New Balance: $" + bankService.getBalance("ACC001"));

        System.out.println("\n======================================");
        System.out.println("Test 4: Transfer (Sensitive Operation)");
        System.out.println("======================================");
        bankService.transfer("ACC001", "ACC002", 200.0);
        System.out.println("ACC001 Balance: $" + bankService.getBalance("ACC001"));
        System.out.println("ACC002 Balance: $" + bankService.getBalance("ACC002"));

        System.out.println("\n======================================");
        System.out.println("Test 5: Invalid Operation (Exception Handling)");
        System.out.println("======================================");
        try {
            bankService.withdraw("ACC003", 1000.0); // Insufficient balance
        } catch (RuntimeException e) {
            System.out.println("[Main] Caught exception: " + e.getMessage());
        }

        System.out.println("\n======================================");
        System.out.println("Test 6: Invalid Input (Validation)");
        System.out.println("======================================");
        try {
            bankService.deposit("INVALID", 100.0);
        } catch (Exception e) {
            System.out.println("[Main] Operation completed with validation warning");
        }

        System.out.println("\n======================================");
        System.out.println("Closing ApplicationContext");
        System.out.println("======================================");
        context.close();
        System.out.println("Demo completed!");
    }
}
