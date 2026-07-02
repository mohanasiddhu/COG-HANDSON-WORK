package com.spring.injection.services;

/**
 * Console Logger implementation
 */
public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[ConsoleLogger] " + message);
    }
}
