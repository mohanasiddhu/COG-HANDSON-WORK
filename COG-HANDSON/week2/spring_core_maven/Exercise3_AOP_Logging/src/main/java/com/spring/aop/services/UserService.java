package com.spring.aop.services;

/**
 * Interface for User Service operations
 */
public interface UserService {

    void registerUser(String username, String email);

    String getUserInfo(String username);

    void updateUserEmail(String username, String newEmail);

    void deleteUser(String username);
}
