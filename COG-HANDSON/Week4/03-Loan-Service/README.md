# Loan Service

## Objective
Handle application, listing, and approval/rejection operations for Home, Car, and Personal loans.

## Technologies Used
- Java 21
- Spring Boot 3.3.1
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Spring Cloud Eureka Client

## Project Structure
- `entity`: Loan database model.
- `dto`: Input validations.
- `repository`: H2 DB operations.
- `service`: Loan status state machine checks.
- `controller`: Status actions & query controllers.

## How to Run
Run via maven:
```bash
mvn spring-boot:run
```

## Expected Output
Hit `GET http://localhost:8083/api/loans` to check mock loans details.
