package com.spring.lifecycle.demo;

import com.spring.lifecycle.beans.ConnectionPool;
import com.spring.lifecycle.beans.CacheManager;
import com.spring.lifecycle.beans.ServiceWithContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean Lifecycle Demo - Demonstrates Spring Bean Lifecycle Phases
 */
public class BeanLifecycleDemo {

    public static void main(String[] args) {
        System.out.println("=== Spring Bean Lifecycle Demo ===\n");

        System.out.println("--- Creating Spring Container (Loading applicationContext.xml) ---\n");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n========== TEST CASE 1: init-method / destroy-method ==========\n");
        ConnectionPool connectionPool = context.getBean(ConnectionPool.class);
        connectionPool.getConnection();
        connectionPool.getConnection();
        connectionPool.releaseConnection();

        System.out.println("\n========== TEST CASE 2: InitializingBean / DisposableBean ==========\n");
        CacheManager cacheManager = context.getBean(CacheManager.class);
        cacheManager.putItem("user1", "John Doe");
        cacheManager.putItem("user2", "Jane Doe");
        cacheManager.getItem("user1");

        System.out.println("\n========== TEST CASE 3: ApplicationContextAware ==========\n");
        ServiceWithContextAware service = context.getBean(ServiceWithContextAware.class);
        service.listAllBeans();
        service.doSomething();

        System.out.println("\n--- Closing ApplicationContext (Calling destroy methods) ---\n");
        context.close();
        System.out.println("\nDemo completed!");
    }
}
