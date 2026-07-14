package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Learn Web Application - RESTful Web Services Demo
 */
@SpringBootApplication
@ImportResource("classpath:country.xml") // Import XML-based Spring configurations
public class SpringLearnWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnWebApplication.class, args);
    }
}
