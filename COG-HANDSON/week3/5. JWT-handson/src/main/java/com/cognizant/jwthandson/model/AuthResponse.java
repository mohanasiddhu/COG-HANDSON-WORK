package com.cognizant.jwthandson.model;

import java.io.Serializable;

/**
 * Response payload containing the generated JWT token.
 */
public class AuthResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    
    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
