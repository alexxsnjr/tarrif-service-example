# Tariff Service

This project is a service for obtaining the tariff of a product.

## Prerequisites

- Java 17 installed

## Configuration

The project uses Spring Boot and an in-memory H2 database. Below are the relevant configurations:

### `application.yml` file

The `application.yml` file contains the project configurations.

```yml
server:
  port: 8080

spring:
  h2:
    console:
      path: /h2-console
      settings.web-allow-others: false
      enabled: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    defer-datasource-initialization: true
  datasource:
    url: jdbc:h2:mem:pricedb
    username: sa
    password: password
    driverClassName: org.h2.Driver
```

Here you can configure `server port:8080` , and `datasource.password`

For show the H2 console access to http://localhost:8080/h2-console

## Running Instructions
Follow the steps below to run the project:

Clone the project repository:

```bash
git clone https://github.com/alexxsnjr/tarrif-service-example.git


```
Compile and pass the test
```bash
./mvnw clean install
```

Run the project:

```bash
./mvnw spring-boot:run
```
The service will be available at http://localhost:8080.

## Running Tests
The project includes unit tests and integration tests. Here's how to run them:


Run the following command to execute the unit tests:

```bash
./mvnw clean test
```
Run the following command to execute the integration tests and unit test:

```bash
./mvnw clean verify
```



## API Reference

#### Get tarrif by product, brand and date

```http
  GET /api/prices?{date}&{productId}&{brandId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `date`    | `DateTimeFormat` | **Required**. pattern = "yyyy-MM-dd HH:mm:ss" |
| `productid`    | `Long` | **Required**. id of Product |
| `brandId`    | `Long` | **Required**. id of brand |



Takes the parameter and search in database what is the tariff for that moment in that product.

