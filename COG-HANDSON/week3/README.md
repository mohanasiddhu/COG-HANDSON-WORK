# Week 3 Spring Boot REST & Security (JWT) Hands-On

This folder contains the complete solutions for the Week 3 hands-on exercises:

1. **`1. spring-rest-handson`**: Spring Core configuration loading countries from an XML config file using standard Spring Container.
2. **`2. spring-rest-handson`**: Spring Boot REST web services implementing:
   - Hello World endpoint (`/hello`)
   - Country listing endpoint (`/countries`)
   - Country retrieval by code endpoint (`/country/{code}`) with error handling.
3. **`5. JWT-handson`**: Spring Boot Security service implementing stateless JWT authentication:
   - Credentials verification endpoint (`POST /authenticate`) returning a JWT
   - Secured endpoint (`GET /hello`) requiring validation of authorization header

---

## How to Build and Run

As Maven may not be globally installed, you can run these applications using your IDE (Eclipse, IntelliJ IDEA, or Spring Tools Suite) as Spring Boot applications, or install Maven and run:

```bash
# To run Project 1
cd "1. spring-rest-handson"
mvn spring-boot:run

# To run Project 2 (port 8080)
cd "../2. spring-rest-handson"
mvn spring-boot:run

# To run Project 5 (port 8081)
cd "../5. JWT-handson"
mvn spring-boot:run
```

---

## Endpoints Summary

### Project 2:
- `GET http://localhost:8080/hello` -> Returns `"Hello World!"`
- `GET http://localhost:8080/country` -> Returns default country India (`IN`)
- `GET http://localhost:8080/countries` -> Returns a JSON array of all countries defined in XML
- `GET http://localhost:8080/country/{code}` -> Returns the country matching the code (e.g. `IN`, `US`, `DE`, `JP`), or `404 Not Found` if it doesn't exist.

### Project 5:
- `POST http://localhost:8081/authenticate` -> Accepts credentials JSON:
  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```
  Returns:
  ```json
  {
    "token": "<JWT-token>"
  }
  ```
- `GET http://localhost:8081/hello` -> Requires Header `Authorization: Bearer <JWT-token>`
