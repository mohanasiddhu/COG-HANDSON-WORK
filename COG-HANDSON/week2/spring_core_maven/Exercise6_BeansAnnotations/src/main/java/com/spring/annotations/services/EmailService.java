package com.spring.annotations.services;

import org.springframework.stereotype.Service;

/**
 * EmailService interface
 */
public interface EmailService {

    void sendEmail(String to, String subject, String body);
}

/**
 * EmailServiceImpl implementation
 *
 * @Service - indicates this is a business logic component Spring will
 * automatically register this as a bean
 */
@Service
class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[Service] Sending email to " + to);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + body);
    }
}
