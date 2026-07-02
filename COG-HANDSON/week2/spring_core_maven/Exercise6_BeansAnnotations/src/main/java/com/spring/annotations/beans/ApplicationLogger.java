package com.spring.annotations.beans;

import org.springframework.stereotype.Component;

/**
 * @Component - generic stereotype annotation Indicates this class is a
 * Spring-managed component Can be used for any component that doesn't fit into
 * @Service, @Repository, or @Controller
 */
@Component
public class ApplicationLogger {

    public void log(String message) {
        System.out.println("[Logger] " + System.currentTimeMillis() + " - " + message);
    }

    public void logError(String message, Exception e) {
        System.out.println("[Logger ERROR] " + System.currentTimeMillis() + " - " + message);
        e.printStackTrace();
    }
}
