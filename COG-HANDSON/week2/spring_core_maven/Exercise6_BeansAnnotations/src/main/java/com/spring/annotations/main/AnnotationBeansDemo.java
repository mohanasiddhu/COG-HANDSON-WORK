package com.spring.annotations.main;

import com.spring.annotations.beans.ApplicationLogger;
import com.spring.annotations.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 6: Configuring Beans with Annotations
 *
 * This application demonstrates: 1. @Component annotation for auto-registration
 * 2. @Service annotation for business logic components 3. @Repository
 * annotation for data access components 4. @Autowired annotation for dependency
 * injection 5. Component scanning with context:component-scan 6. Stereotype
 * annotations for reducing XML configuration
 */
public class AnnotationBeansDemo {

    public static void main(String[] args) {
        System.out.println("=== Spring Beans with Annotations Demo ===\n");

        // Create ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Annotation-Based Bean Discovery ---");
        System.out.println("Beans created and registered:");
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("  - " + beanName + " (" + context.getBean(beanName).getClass().getSimpleName() + ")");
        }

        System.out.println("\n--- Using @Service with @Autowired ---");
        UserService userService = context.getBean(UserService.class);
        userService.registerUser("alice", "alice@example.com");

        System.out.println("\n--- Using @Component ---");
        ApplicationLogger logger = context.getBean(ApplicationLogger.class);
        logger.log("Application is running successfully");

        System.out.println("\n--- Test Case 2: Notify User ---");
        userService.notifyUser("alice", "Your account has been verified");

        System.out.println("\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed successfully!");
    }
}
