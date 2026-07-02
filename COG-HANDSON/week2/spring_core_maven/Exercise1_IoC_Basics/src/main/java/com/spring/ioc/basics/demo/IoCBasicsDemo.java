package com.spring.ioc.basics.demo;

import com.spring.ioc.basics.beans.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IoC Basics Demo - Demonstrates Spring Container and Dependency Injection
 */
public class IoCBasicsDemo {

    public static void main(String[] args) {
        System.out.println("=== Spring IoC Basics Demo ===\n");

        // Create Spring IoC Container by loading XML configuration
        System.out.println("--- Initializing Spring IoC Container ---");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Getting UserService Bean from Container ---");
        // Retrieve the UserService bean from the container
        // Spring automatically injects UserRepository and EmailService
        UserService userService = context.getBean(UserService.class);

        // Use the injected service
        System.out.println("\n--- Test Case 1: Register New User ---");
        userService.registerUser("John Doe", "john@example.com");

        System.out.println("\n--- Test Case 2: Get User Info ---");
        var userInfo = userService.getUserInfo("john@example.com");
        System.out.println("Retrieved: " + userInfo);

        System.out.println("\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed!");
    }
}
