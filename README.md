# Spring Security JWT Authentication Framework

## Overview

This repository offers a template for a Spring Boot application that leverages JSON Web Token (JWT) for user
authentication and authorization with role-based access control. It integrates Spring Security to safeguard RESTful APIs
and facilitate an implicit authentication flow.

## Stack and Tools

- [Spring Boot 3](https://spring.io/projects/spring-boot)
- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Gradle](https://gradle.org/)
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/)
- [JWT](https://jwt.io/)
- [Lombok](https://projectlombok.org/)
- [Liquibase](https://www.liquibase.org/)

## Configuration Guide

Create an `.env` file in the root directory of the project and add the following environment variables:

```shell
MYSQL_DATABASE=<database_name>
MYSQL_ROOT_PASSWORD=<root_password>
MYSQL_USER=<mysql_user>
MYSQL_PASSWORD=<mysql_user_password>
SERVER_PORT=8080
DATASOURCE_URL=jdbc:mysql://localhost:3306/<database_name>
DATASOURCE_USERNAME=<mysql_user>
DATASOURCE_PASSWORD=<mysql_user_password>
JWT_SECRET=<jwt_secret_key>
```

## Getting Started Locally

1. Initialize the MySQL database:

    ```shell
    docker compose up -d
    ```

2. Build and run the application:
    ```shell
    ./gradlew build
    ./gradlew bootRun
    ```

The application setup includes an initial admin user with credentials:

```text
username: admin@test.com
password: adminpassword
```

## API Quickstart

Base URL:

```
http://localhost:8080/api/v1
```

The following endpoints are available post-deployment:

- Sign Up: `/auth/signup`
- Sign In: `/auth/signin`
- Refresh Token: `/auth/refresh`
- Sample Admin Endpoint: `/admin` (requires 'ADMIN' role)
- Sample User Endpoint: `/user` (requires 'USER' role)

Use the JWT token returned by the `/auth/signin` endpoint to access the
`/admin` and `/user` endpoints.

Authenticate by providing the JWT obtained from /auth/signin. Refresh tokens can be acquired via /auth/refresh.

## Detailed Authentication Workflow

Endpoints for authentication services:

- POST `/auth/signup`: Register a new user.
    ```json
    {
    "firstName": "<firstName>",
    "lastName": "<lastName>",
    "email": "<email>",
    "password": "<password>"
    }
    ```
- POST `/auth/signin`: Login and receive an access token.
    ```json
    {
    "email": "<email>",
    "password": "<password>"
    }
    ```
  Response:
    ```json
    {
    "token": "<token>",
    "refreshToken": "<refreshToken>"
    }
    ```

- POST `/auth/refresh`: Refresh an access token.
    ```json
    {
      "token": "<refreshToken>"
    }
    ```

  Response:
    ```json
    {
    "token": "<token>",
    "refreshToken": "<refreshToken>"
    }
    ```

## Comprehensive API Reference

Access the OpenAPI documentation at:

```
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config`
```

## Testing

For unit testing, run the following command:

```shell
./gradlew test
```

For API testing, a Postman collection is provided:
[Postman Collection](https://justinegeorge96.postman.co/workspace/Personal-Workspace~bb9080f9-e940-4d7b-a0b9-38757158c030/folder/4363598-eb6131a4-ab9e-4aaf-a3e1-70a8bde57c67?action=share&creator=4363598&ctx=documentation&active-environment=4363598-ccef5eaf-e186-44e9-9b93-f3f06867cd53)

Ensure that the following environment variables are set:
[Environment](https://justinegeorge96.postman.co/workspace/Personal-Workspace~bb9080f9-e940-4d7b-a0b9-38757158c030/environment/4363598-ccef5eaf-e186-44e9-9b93-f3f06867cd53?action=share&creator=4363598&active-environment=4363598-ccef5eaf-e186-44e9-9b93-f3f06867cd53)

Pre-request scripts are provided to automate the process of obtaining a JWT token and refreshing it.

## License

This project is licensed under the [MIT License](LICENSE).