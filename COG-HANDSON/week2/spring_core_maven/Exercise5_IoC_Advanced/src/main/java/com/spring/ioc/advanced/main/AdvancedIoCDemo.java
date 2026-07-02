package com.spring.ioc.advanced.main;

import com.spring.ioc.advanced.beans.AppConfiguration;
import com.spring.ioc.advanced.beans.DataSourceFactory;
import com.spring.ioc.advanced.beans.ExpensiveResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 5: Configuring the Spring IoC Container (Advanced)
 *
 * This application demonstrates advanced IoC container features: 1. Bean
 * lifecycle methods (init-method and destroy-method) 2. Factory methods for
 * bean creation 3. Bean scopes: Singleton vs Prototype 4. Lazy initialization
 * 5. Collection injection (List, Map, Set)
 */
public class AdvancedIoCDemo {

    public static void main(String[] args) {
        System.out.println("=== Advanced Spring IoC Container Demo ===\n");

        // Create ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Database Pool (Lifecycle Demo) ---");
        context.getBean("databasePool");

        System.out.println("\n--- Factory Method Demo ---");
        Object mysqlDS = context.getBean("mysqlDataSource");
        System.out.println("DataSource Type: " + mysqlDS.getClass().getSimpleName());

        System.out.println("\n--- Singleton vs Prototype Scope Demo ---");
        ExpensiveResource singleton1 = context.getBean("singletonResource", ExpensiveResource.class);
        ExpensiveResource singleton2 = context.getBean("singletonResource", ExpensiveResource.class);

        System.out.println("Singleton 1: " + singleton1.hashCode());
        System.out.println("Singleton 2: " + singleton2.hashCode());
        System.out.println("Are they the same object? " + (singleton1 == singleton2));

        System.out.println("\n--- Prototype Scope Demo ---");
        ExpensiveResource prototype1 = context.getBean("prototypeResource", ExpensiveResource.class);
        ExpensiveResource prototype2 = context.getBean("prototypeResource", ExpensiveResource.class);

        System.out.println("Prototype 1: " + prototype1.hashCode());
        System.out.println("Prototype 2: " + prototype2.hashCode());
        System.out.println("Are they the same object? " + (prototype1 == prototype2));

        System.out.println("\n--- Lazy Initialization Demo ---");
        System.out.println("Getting lazy resource for the first time...");
        ExpensiveResource lazyResource = context.getBean("lazyResource", ExpensiveResource.class);
        lazyResource.doWork();

        System.out.println("\n--- Collection Injection Demo ---");
        AppConfiguration appConfig = context.getBean("appConfig", AppConfiguration.class);
        appConfig.displayConfiguration();

        System.out.println("\n--- Closing ApplicationContext ---");
        context.close();
        System.out.println("Demo completed! (Destroy methods called)");
    }
}
