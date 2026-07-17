# API Gateway

## Objective
Route external traffic to the appropriate registered microservices via Spring Cloud Gateway.

## Technologies Used
- Java 21
- Spring Boot 3.3.1
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client

## Project Structure
- `src/main/java`: API Gateway entrypoint.
- `src/main/resources`: Route predicates and CORS configurations.

## How to Run
Run via maven:
```bash
mvn spring-boot:run
```

## Expected Output
Requests sent to `http://localhost:8080/api/accounts` and `http://localhost:8080/api/loans` will be dynamically routed.
