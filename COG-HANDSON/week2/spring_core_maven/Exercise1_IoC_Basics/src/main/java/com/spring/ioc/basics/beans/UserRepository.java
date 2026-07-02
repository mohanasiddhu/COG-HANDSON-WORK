package com.spring.ioc.basics.beans;

/**
 * UserRepository interface for data access
 */
public interface UserRepository {

    void save(User user);

    User findByEmail(String email);
}
