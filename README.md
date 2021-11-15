# Spring Boot Starter Template

This package is a full implementation of Spring Boot with MVC and Rest API with CORS and ORM.
<br>
<br>
If you want to create a custom Spring Boot project you can use https://start.spring.io/

## Table of contents
1. Packages used
2. Database connection
3. Swagger UI
4. Models
5. Controllers
6. Responses
7. Services
8. Views

## Packages Used
This template uses the dependencies listed on *build.gradle*.

## Database Connection
This template uses mysql connection, the settings are found on *src/main/resources/application.properties*, swap the uppercase text with the corresponding data in your database.
https://spring.io/guides/gs/accessing-data-mysql

## Swagger UI
The Swagger UI API Documentation is found on *http://localhost:8080/swagger-ui.html* and the configuration file is located on *src/main/java/com.chatbonfire.server/SwaggerConfig.java*.

## Models
### Repositories
You can add methods to find Entities using the orm, you can find an example on *UserRepository*, where we implement a method to search by mail.
https://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#repositories.query-methods.query-creation

## Controllers

Reserved for REST API endpoints.

## Responses

A class of REST API responses.

## Services

Business logic

### AuthService

JWT and hashing.

## Views

Routes for rendering html, your templates and files should be located on the resources folder.