package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Spring Learn Application - XML Configuration Loading Demo
 */
@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run(String... args) throws Exception {
        LOGGER.info("=========================================");
        LOGGER.info("Starting Spring Core XML Beans Demo...");
        LOGGER.info("=========================================");

        // Load country XML configuration from classpath
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            LOGGER.info("Spring ApplicationContext loaded successfully.");

            // Retrieve the list bean
            LOGGER.info("Retrieving 'countryList' bean...");
            ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
            LOGGER.info("--- Country List Content ---");
            for (Country country : countryList) {
                LOGGER.info("Country: code='{}', name='{}'", country.getCode(), country.getName());
            }
            LOGGER.info("----------------------------");

            // Retrieve individual beans
            LOGGER.info("Retrieving single bean 'in'...");
            Country inCountry = context.getBean("in", Country.class);
            LOGGER.info("Retrieved 'in': {}", inCountry);
        }

        LOGGER.info("=========================================");
        LOGGER.info("Spring Core XML Beans Demo completed!");
        LOGGER.info("=========================================");
    }
}
