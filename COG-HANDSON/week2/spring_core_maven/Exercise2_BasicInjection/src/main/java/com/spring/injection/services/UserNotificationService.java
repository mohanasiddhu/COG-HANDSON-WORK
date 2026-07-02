package com.spring.injection.services;

/**
 * UserNotificationService demonstrating Setter Injection - Dependencies are
 * optional and can be changed - Best for optional dependencies
 */
public class UserNotificationService {

    private Logger logger;
    private DatabaseService databaseService;
    private String notificationEmail;

    public UserNotificationService() {
        System.out.println("[UserNotificationService] Created with default constructor");
    }

    /**
     * Setter injection for Logger - optional dependency
     */
    public void setLogger(Logger logger) {
        System.out.println("[UserNotificationService] Logger injected via setter");
        this.logger = logger;
    }

    /**
     * Setter injection for DatabaseService - optional dependency
     */
    public void setDatabaseService(DatabaseService databaseService) {
        System.out.println("[UserNotificationService] DatabaseService injected via setter");
        this.databaseService = databaseService;
    }

    /**
     * Property injection for String value
     */
    public void setNotificationEmail(String notificationEmail) {
        System.out.println("[UserNotificationService] NotificationEmail set to: " + notificationEmail);
        this.notificationEmail = notificationEmail;
    }

    public void sendNotification(String userId) {
        if (logger != null) {
            logger.log("Sending notification to user: " + userId);
        }

        if (databaseService != null) {
            databaseService.executeQuery("SELECT * FROM users WHERE id=" + userId);
        }

        if (notificationEmail != null) {
            System.out.println("[UserNotificationService] Email to: " + notificationEmail);
        }
    }
}
