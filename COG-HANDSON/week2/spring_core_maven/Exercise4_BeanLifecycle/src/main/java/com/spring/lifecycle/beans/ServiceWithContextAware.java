package com.spring.lifecycle.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Service demonstrating ApplicationContextAware - Spring will automatically
 * inject the ApplicationContext
 */
public class ServiceWithContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private String serviceName;

    public ServiceWithContextAware() {
        System.out.println("[ServiceWithContextAware] Constructor called");
    }

    public void setServiceName(String serviceName) {
        System.out.println("[ServiceWithContextAware] setServiceName: " + serviceName);
        this.serviceName = serviceName;
    }

    /**
     * Spring automatically calls this method to inject the ApplicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("[ServiceWithContextAware] ✓ setApplicationContext() called");
        this.applicationContext = applicationContext;
        System.out.println("  - ApplicationContext injected");
    }

    public void listAllBeans() {
        System.out.println("[ServiceWithContextAware] All beans in context:");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("  - " + beanName);
        }
    }

    public void doSomething() {
        System.out.println("[ServiceWithContextAware] Service '" + serviceName + "' is working");
    }
}
