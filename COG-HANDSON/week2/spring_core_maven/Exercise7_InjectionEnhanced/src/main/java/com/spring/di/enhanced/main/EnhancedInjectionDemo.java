package com.spring.di.enhanced.main;

import com.spring.di.enhanced.beans.OrderProcessor;
import com.spring.di.enhanced.beans.ShoppingCart;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 7: Enhanced Constructor and Setter Injection Examples
 *
 * This application demonstrates: 1. Constructor Injection - dependencies
 * required at construction 2. Setter Injection - dependencies optional, can be
 * set after construction 3. When to use each approach 4. Multiple
 * implementations of same interface 5. Configuration through XML
 */
public class EnhancedInjectionDemo {

    public static void main(String[] args) {
        System.out.println("=== Enhanced Dependency Injection Demo ===\n");

        // Create ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n========== CONSTRUCTOR INJECTION DEMO ==========");

        System.out.println("\n--- Order Processor 1 (Credit Card) ---");
        OrderProcessor processor1 = context.getBean("orderProcessor1", OrderProcessor.class);
        processor1.processOrder("ORD001", 100.00);

        System.out.println("\n--- Order Processor 2 (Digital Wallet) ---");
        OrderProcessor processor2 = context.getBean("orderProcessor2", OrderProcessor.class);
        processor2.processOrder("ORD002", 150.00);

        System.out.println("\n========== SETTER INJECTION DEMO ==========");

        System.out.println("\n--- Shopping Cart 1 (Credit Card) ---");
        ShoppingCart cart1 = context.getBean("shoppingCart1", ShoppingCart.class);
        cart1.checkout("ORD003");

        System.out.println("\n--- Shopping Cart 2 (Digital Wallet) ---");
        ShoppingCart cart2 = context.getBean("shoppingCart2", ShoppingCart.class);
        cart2.checkout("ORD004");

        System.out.println("\n--- Shopping Cart 3 (No Payment Service) ---");
        ShoppingCart cart3 = context.getBean("shoppingCart3", ShoppingCart.class);
        cart3.checkout("ORD005");

        System.out.println("\n========== COMPARISON ==========");
        System.out.println("\nConstructor Injection:");
        System.out.println("  ✓ Dependencies are immutable");
        System.out.println("  ✓ All dependencies provided at construction");
        System.out.println("  ✓ Easier to test");
        System.out.println("  ✗ Cannot have optional dependencies");

        System.out.println("\nSetter Injection:");
        System.out.println("  ✓ Flexible - can inject optional dependencies");
        System.out.println("  ✓ Can change dependencies after construction");
        System.out.println("  ✗ Dependencies are mutable");
        System.out.println("  ✗ Can have null references");

        System.out.println("\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed successfully!");
    }
}
