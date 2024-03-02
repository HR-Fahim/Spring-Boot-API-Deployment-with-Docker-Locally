# Spring Boot API Deployment with Docker Locally

This repository provides instructions and configurations to deploy a Spring Boot API using Docker Locally. The purpose of this repository was to understand the process of containerizing a Spring Boot application with Docker.

## Prerequisites

- Docker installed and running on local machine.

- Basic knowledge of Docker and Spring Boot Framework.

## Step-by-Step Local Deployment

### Step 1: Containerize Spring Boot Application with Docker

1. **Dockerfile**: Create a Dockerfile in Spring Boot project directory as follows:

    ```Dockerfile
    # Stage 1: Build the application
    FROM maven:3.8.4-openjdk-17 AS builder

    WORKDIR /app

    # Copy the Maven project file to download dependencies
    COPY pom.xml .

    # Download dependencies only
    RUN mvn dependency:go-offline -B

    # Copy the project source
    COPY src ./src

    # Package the application
    RUN mvn package -DskipTests

    # Stage 2: Create the runtime image
    FROM openjdk:17-jdk-slim AS runtime

    WORKDIR /app

    # Copy the packaged jar file from the builder stage
    COPY --from=builder /app/target/*.jar app.jar

    # Expose the port
    EXPOSE 8080

    # Command to run the application
    CMD ["java", "-jar", "app.jar"]
    ```

2. **Build Docker Image**: Run the following command to build Docker image:

    ```
    docker build -t spring-boot-app .
    ```

3. **Verify**: After building the Docker image, verify it by running:

    ```
    docker images
    ```

### Step 2: Run Docker Container Locally

1. **Run Container**: Once the Docker image is built, run a container locally with the following command:

    ```
    docker run -p 8080:8080 spring-boot-app
    ```
![Docker Spring-Boot](https://github.com/HR-Fahim/Spring-Boot-API-Deployment-with-Docker-Locally/assets/66734379/188f984a-8023-449d-9184-7a1cd8f77286)

2. **Test**: Test Spring Boot application by accessing [API](http://localhost:8080/actuator/health) in Postman.

![Postman API](https://github.com/HR-Fahim/Spring-Boot-API-Deployment-with-Docker-Locally/assets/66734379/27c0a091-f83e-4be6-8287-8574af610886)

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify this project according to the terms of the license.
