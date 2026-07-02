package com.spring.ioc.advanced.beans;

/**
 * Database connection pool bean
 */
public class DatabasePool {

    private String url;
    private String username;
    private String password;
    private int maxConnections;
    private int minConnections;

    // Constructor
    public DatabasePool(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println("DatabasePool initialized with URL: " + url);
    }

    // Init method - called after bean is constructed
    public void initialize() {
        System.out.println("Initializing database pool...");
        System.out.println("Max Connections: " + maxConnections);
        System.out.println("Min Connections: " + minConnections);
        System.out.println("Database pool ready!");
    }

    // Destroy method - called when container is closed
    public void destroy() {
        System.out.println("Destroying database pool - closing all connections");
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }
}
