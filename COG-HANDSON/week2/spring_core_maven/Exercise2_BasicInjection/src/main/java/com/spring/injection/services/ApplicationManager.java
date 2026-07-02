package com.spring.injection.services;

/**
 * ApplicationManager demonstrating Constructor Injection - Dependencies are
 * required and immutable - Best for mandatory dependencies
 */
public class ApplicationManager {

    private Logger logger;
    private DatabaseService databaseService;

    /**
     * Constructor injection - dependencies are required
     */
    public ApplicationManager(Logger logger, DatabaseService databaseService) {
        System.out.println("[ApplicationManager] Created with Constructor Injection");
        this.logger = logger;
        this.databaseService = databaseService;
    }

    public void startup() {
        logger.log("ApplicationManager starting...");
        databaseService.connect("localhost", 5432);
        logger.log("ApplicationManager startup complete");
    }

    public void shutdown() {
        logger.log("ApplicationManager shutting down...");
    }
}
