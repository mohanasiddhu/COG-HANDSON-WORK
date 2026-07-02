package com.spring.injection.demo;

import com.spring.injection.services.ApplicationManager;
import com.spring.injection.services.UserNotificationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Basic Injection Demo - Constructor vs Setter Injection
 */
public class BasicInjectionDemo {

    public static void main(String[] args) {
        System.out.println("=== Spring Basic Injection Demo ===\n");

        // Load Spring configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n========== CONSTRUCTOR INJECTION DEMO ==========\n");
        ApplicationManager appManager = context.getBean(ApplicationManager.class);
        appManager.startup();
        appManager.shutdown();

        System.out.println("\n========== SETTER INJECTION DEMO ==========\n");
        UserNotificationService notificationService = context.getBean(UserNotificationService.class);
        notificationService.sendNotification("USER123");

        System.out.println("\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed!");
    }
}
