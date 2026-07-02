package com.spring.annotations.repositories;

/**
 * Repository interface using repository pattern
 */
public interface UserRepository {

    void saveUser(String username, String email);

    String getUserByUsername(String username);
}
