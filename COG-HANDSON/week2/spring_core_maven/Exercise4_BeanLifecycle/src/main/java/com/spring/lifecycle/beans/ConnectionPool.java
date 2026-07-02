package com.spring.lifecycle.beans;

/**
 * ConnectionPool bean demonstrating lifecycle callbacks - init-method: called
 * after bean creation and dependency injection - destroy-method: called when
 * container is closed
 */
public class ConnectionPool {

    private String poolName;
    private int maxConnections;
    private int activeConnections = 0;

    public ConnectionPool() {
        System.out.println("[ConnectionPool] Constructor called");
    }

    public void setPoolName(String poolName) {
        System.out.println("[ConnectionPool] setPoolName: " + poolName);
        this.poolName = poolName;
    }

    public void setMaxConnections(int maxConnections) {
        System.out.println("[ConnectionPool] setMaxConnections: " + maxConnections);
        this.maxConnections = maxConnections;
    }

    /**
     * Initialization method - called after properties are set
     */
    public void initialize() {
        System.out.println("[ConnectionPool] ✓ Initializing pool: " + poolName);
        System.out.println("  - Max Connections: " + maxConnections);
        System.out.println("  - Creating connection pool resources...");
        activeConnections = 0;
        System.out.println("  - Pool initialized successfully");
    }

    /**
     * Cleanup method - called when container closes
     */
    public void destroy() {
        System.out.println("[ConnectionPool] ✓ Destroying pool: " + poolName);
        System.out.println("  - Closing " + activeConnections + " active connections");
        System.out.println("  - Releasing pool resources...");
        System.out.println("  - Pool destroyed successfully");
    }

    public void getConnection() {
        if (activeConnections < maxConnections) {
            activeConnections++;
            System.out.println("[ConnectionPool] Connection acquired (Active: " + activeConnections + ")");
        } else {
            System.out.println("[ConnectionPool] Connection pool exhausted!");
        }
    }

    public void releaseConnection() {
        if (activeConnections > 0) {
            activeConnections--;
            System.out.println("[ConnectionPool] Connection released (Active: " + activeConnections + ")");
        }
    }
}
