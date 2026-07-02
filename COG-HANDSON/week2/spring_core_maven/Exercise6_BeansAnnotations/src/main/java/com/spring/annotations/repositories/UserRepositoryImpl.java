package com.spring.annotations.repositories;

import org.springframework.stereotype.Repository;

/**
 * UserRepository implementation
 *
 * @Repository - indicates this is a data access object (DAO) Spring will
 * automatically register this as a bean
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(String username, String email) {
        System.out.println("[Repository] Saving user to database: " + username + " - " + email);
    }

    @Override
    public String getUserByUsername(String username) {
        System.out.println("[Repository] Fetching user from database: " + username);
        return "User: " + username + ", Email: " + username + "@example.com";
    }
}
