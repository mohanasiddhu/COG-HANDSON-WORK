# Account Service

## Objective
Manage account-related queries and business operations including account creation, deposits, and balance-guarded withdrawals.

## Technologies Used
- Java 21
- Spring Boot 3.3.1
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Spring Cloud Eureka Client

## Project Structure
- `entity`: Account Database mapping.
- `dto`: Input validators and responses.
- `repository`: H2 DB operations.
- `service`: Deposit & Withdraw logic checks.
- `controller`: REST endpoints mapping.
- `exception`: Global exception handling maps.

## How to Run
Run via maven:
```bash
mvn spring-boot:run
```

## Expected Output
Hit `GET http://localhost:8082/api/accounts` to list default seeded bank accounts.
