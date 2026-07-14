package com.cognizant.jwthandson.controller;

import com.cognizant.jwthandson.model.AuthRequest;
import com.cognizant.jwthandson.model.AuthResponse;
import com.cognizant.jwthandson.security.JwtUtil;
import com.cognizant.jwthandson.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing endpoints for JWT Authentication and a secured greeting.
 */
@RestController
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * POST /authenticate endpoint. Verifies username and password,
     * and returns a JWT response if successful.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        LOGGER.info("POST /authenticate triggered for username='{}'", authRequest.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            LOGGER.warn("Failed authentication attempt for username='{}': Bad credentials", authRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        LOGGER.info("JWT generated successfully for username='{}'", authRequest.getUsername());
        
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    /**
     * Secured GET /hello endpoint. Requires a valid JWT token.
     */
    @GetMapping("/hello")
    public String getSecuredHello() {
        LOGGER.info("GET /hello endpoint triggered - Authorized access verified");
        return "Hello World! You have successfully accessed a secured resource.";
    }
}
