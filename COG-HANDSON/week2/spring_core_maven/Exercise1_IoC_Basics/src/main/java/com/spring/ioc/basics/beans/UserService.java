package com.spring.ioc.basics.beans;

/**
 * UserService demonstrating Spring's IoC container managing dependencies
 */
public class UserService {

    private UserRepository userRepository;
    private EmailService emailService;

    /**
     * Constructor injection - Spring will inject dependencies via constructor
     */
    public UserService(UserRepository userRepository, EmailService emailService) {
        System.out.println("[UserService] Created via constructor injection");
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void registerUser(String name, String email) {
        System.out.println("[UserService] Registering new user...");
        User user = new User(name, email);
        userRepository.save(user);
        emailService.sendEmail(email, "Welcome!", "Thank you for registering!");
    }

    public User getUserInfo(String email) {
        System.out.println("[UserService] Retrieving user info...");
        return userRepository.findByEmail(email);
    }
}
