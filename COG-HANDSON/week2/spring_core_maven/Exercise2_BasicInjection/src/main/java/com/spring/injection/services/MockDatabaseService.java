package com.spring.injection.services;

/**
 * Mock Database Service implementation
 */
public class MockDatabaseService implements DatabaseService {

    @Override
    public void connect(String host, int port) {
        System.out.println("[MockDB] Connected to " + host + ":" + port);
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("[MockDB] Executing query: " + query);
    }
}
