package com.spring.ioc.basics.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory implementation of UserRepository
 */
public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("[Repository] Saving user: " + user.getName());
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        System.out.println("[Repository] Finding user by email: " + email);
        return users.get(email);
    }
}
