package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller to expose Country details loaded from XML configuration.
 */
@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("in")
    private Country indiaCountry;

    @Autowired
    @Qualifier("countryList")
    private ArrayList<Country> countryList;

    /**
     * GET /country endpoint returning the default 'in' country bean.
     */
    @GetMapping("/country")
    public Country getIndiaCountry() {
        LOGGER.info("GET /country endpoint triggered");
        return indiaCountry;
    }

    /**
     * GET /countries endpoint returning the full list of country beans.
     */
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("GET /countries endpoint triggered");
        return countryList;
    }

    /**
     * GET /country/{code} endpoint returning a country based on the country code.
     * Throws CountryNotFoundException if code is invalid.
     */
    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("GET /country/{} endpoint triggered", code);
        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> {
                    LOGGER.warn("Country code '{}' not found", code);
                    return new CountryNotFoundException("Country with code " + code + " not found");
                });
    }
}
