package com.spring.aop.main;

import com.spring.aop.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 3: Implementing Logging with Spring AOP
 *
 * This application demonstrates: 1. Spring AOP (Aspect-Oriented Programming) 2.
 * Cross-cutting concerns (Logging) 3. Advice types: @Before, @After, @Around,
 *
 * @AfterReturning, @AfterThrowing 4. Pointcuts and JoinPoints 5. Aspect weaving
 * and proxy creation
 */
public class AOPLoggingDemo {

    public static void main(String[] args) {
        System.out.println("=== Spring AOP Logging Demo ===\n");

        // Create ApplicationContext and enable AOP
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get UserService bean (which is now proxied)
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println("\n--- Test Case 1: Register User ---");
        userService.registerUser("john_doe", "john@example.com");

        System.out.println("\n\n--- Test Case 2: Get User Info ---");
        String userInfo = userService.getUserInfo("john_doe");
        System.out.println("Result: " + userInfo);

        System.out.println("\n\n--- Test Case 3: Update User Email ---");
        userService.updateUserEmail("john_doe", "john.new@example.com");

        System.out.println("\n\n--- Test Case 4: Delete User (Success) ---");
        userService.deleteUser("john_doe");

        System.out.println("\n\n--- Test Case 5: Delete User (Exception) ---");
        try {
            userService.deleteUser("admin");
        } catch (RuntimeException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }

        System.out.println("\n\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed successfully!");
    }
}
