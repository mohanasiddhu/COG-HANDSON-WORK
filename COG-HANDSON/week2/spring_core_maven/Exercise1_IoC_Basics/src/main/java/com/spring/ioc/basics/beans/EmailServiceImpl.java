package com.spring.ioc.basics.beans;

/**
 * Email Service implementation
 */
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[EmailService] Sending email to: " + to);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + body);
    }
}
