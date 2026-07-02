package com.spring.injection.services;

/**
 * Database service interface
 */
public interface DatabaseService {

    void connect(String host, int port);

    void executeQuery(String query);
}
