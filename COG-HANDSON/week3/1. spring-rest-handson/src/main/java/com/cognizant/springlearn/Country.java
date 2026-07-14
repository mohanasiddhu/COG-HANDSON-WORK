package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Model class representing a Country.
 */
public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    /**
     * Default constructor showing bean initialization log.
     */
    public Country() {
        LOGGER.info("Inside Country constructor: Bean instantiated");
    }

    /**
     * Parameterized constructor.
     */
    public Country(String code, String name) {
        LOGGER.info("Inside Country parameterized constructor: Bean instantiated with code={}, name={}", code, name);
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        LOGGER.info("Setting code: {}", code);
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOGGER.info("Setting name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
