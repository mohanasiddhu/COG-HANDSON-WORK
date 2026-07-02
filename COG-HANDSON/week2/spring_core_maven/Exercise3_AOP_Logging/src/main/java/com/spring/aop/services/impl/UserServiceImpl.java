package com.spring.aop.services.impl;

import com.spring.aop.services.UserService;

/**
 * UserServiceImpl - Implementation of UserService This is a target object for
 * AOP advice
 */
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(String username, String email) {
        System.out.println("Registering user: " + username + " with email: " + email);
        // Simulate user registration
    }

    @Override
    public String getUserInfo(String username) {
        System.out.println("Retrieving info for user: " + username);
        // Simulate user info retrieval
        return "User: " + username + ", Email: user@example.com";
    }

    @Override
    public void updateUserEmail(String username, String newEmail) {
        System.out.println("Updating email for user: " + username + " to: " + newEmail);
        // Simulate email update
    }

    @Override
    public void deleteUser(String username) {
        System.out.println("Deleting user: " + username);
        // Simulate user deletion
        if (username.equals("admin")) {
            throw new RuntimeException("Cannot delete admin user!");
        }
    }
}
