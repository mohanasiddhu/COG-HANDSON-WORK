package com.cognizant.springlearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a country is not found by its code.
 * Mapped to 404 NOT FOUND status.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends RuntimeException {
    
    public CountryNotFoundException() {
        super("Country not found");
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}
