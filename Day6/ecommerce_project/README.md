# E-Commerce REST API (Spring Boot)

## What you get
- Simple Spring Boot project (H2 in-memory DB) with endpoints for:
  - Customer CRUD and register (passwords hashed with BCrypt)
  - Product CRUD and search
  - Order placement, view, list by customer, status update, cancel

## How to run
1. Install Java 11+ and Maven.
2. From project root run:
   mvn spring-boot:run
3. App runs on http://localhost:8080
4. H2 console: http://localhost:8080/h2-console (jdbc url: jdbc:h2:mem:ecomdb, user sa)

## Endpoints (examples)
- POST /api/customers/register
- GET /api/customers
- POST /api/products
- GET /api/products
- POST /api/orders

