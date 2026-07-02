package com.spring.ioc.basics.beans;

/**
 * Simple service interface demonstrating basic Spring dependency
 */
public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
