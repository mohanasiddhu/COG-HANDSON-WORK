package com.spring.annotations.services;

import com.spring.annotations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService interface
 */
public interface UserService {

    void registerUser(String username, String email);

    void notifyUser(String username, String message);
}

/**
 * UserServiceImpl implementation
 *
 * @Service - indicates this is a business logic component Uses @Autowired for
 * dependency injection
 */
@Service
class UserServiceImpl implements UserService {

    // Dependency injection using @Autowired annotation
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    /**
     * Alternative: Constructor-based injection with @Autowired This is
     * commented out as we're using field injection above
     */
    // @Autowired
    // public UserServiceImpl(UserRepository userRepository, EmailService emailService) {
    //     this.userRepository = userRepository;
    //     this.emailService = emailService;
    // }
    @Override
    public void registerUser(String username, String email) {
        System.out.println("\n[Service] Registering new user...");
        userRepository.saveUser(username, email);
        emailService.sendEmail(email, "Welcome!", "Welcome to our application!");
    }

    @Override
    public void notifyUser(String username, String message) {
        System.out.println("\n[Service] Notifying user...");
        String userInfo = userRepository.getUserByUsername(username);
        System.out.println("User Info: " + userInfo);
        emailService.sendEmail(username + "@example.com", "Notification", message);
    }
}
