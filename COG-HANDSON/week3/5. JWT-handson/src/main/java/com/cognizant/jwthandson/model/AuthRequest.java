package com.cognizant.jwthandson.model;

import java.io.Serializable;

/**
 * Request payload containing username and password.
 */
public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    
    private String username;
    private String password;

    public AuthRequest() {}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
