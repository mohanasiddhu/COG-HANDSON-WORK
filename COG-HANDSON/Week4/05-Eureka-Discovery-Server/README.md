# Eureka Discovery Server

## Objective
Enable service registration and discovery for the Account and Loan microservices.

## Technologies Used
- Java 21
- Spring Boot 3.3.1
- Spring Cloud Netflix Eureka Server

## Project Structure
- `src/main/java`: Contains the entry point annotated with `@EnableEurekaServer`.
- `src/main/resources`: Application configurations.

## How to Run
Run via maven:
```bash
mvn spring-boot:run
```

## Expected Output
Visit `http://localhost:8761` to access the Eureka Dashboard.
