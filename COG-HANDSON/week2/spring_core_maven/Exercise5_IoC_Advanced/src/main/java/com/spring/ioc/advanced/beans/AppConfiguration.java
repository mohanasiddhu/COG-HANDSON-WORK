package com.spring.ioc.advanced.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Bean demonstrating collection injection
 */
public class AppConfiguration {

    private List<String> serverUrls;
    private Map<String, String> properties;
    private Set<String> allowedRoles;

    public List<String> getServerUrls() {
        return serverUrls;
    }

    public void setServerUrls(List<String> serverUrls) {
        this.serverUrls = serverUrls;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Set<String> getAllowedRoles() {
        return allowedRoles;
    }

    public void setAllowedRoles(Set<String> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public void displayConfiguration() {
        System.out.println("\n=== Application Configuration ===");

        System.out.println("\nServer URLs: ");
        if (serverUrls != null) {
            serverUrls.forEach(url -> System.out.println("  - " + url));
        }

        System.out.println("\nProperties: ");
        if (properties != null) {
            properties.forEach((key, value) -> System.out.println("  " + key + " = " + value));
        }

        System.out.println("\nAllowed Roles: ");
        if (allowedRoles != null) {
            allowedRoles.forEach(role -> System.out.println("  - " + role));
        }
    }
}
