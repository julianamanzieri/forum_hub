# Forum Hub: Discussion Forum API

Welcome to **Forum Hub**, a Java application for managing discussion forums with functionality such as user registration, topic creation, and commenting on topics. This project was developed as a hands-on challenge to implement a robust backend API using Spring Boot and modern development practices.

## Description

**Forum Hub** provides a RESTful API for managing users, courses, topics, and responses in a discussion forum. The application supports secure authentication using JWT and enforces data validation to ensure consistency. Built with Spring Boot, it leverages JPA for database management and Flyway for database migrations.

## Features

- **User Management**: Allows registration of new users with secure password hashing.
- **Topic Management**: Enables users to create and manage discussion topics.
- **Response System**: Users can post responses to existing topics.
- **Course Integration**: Topics can be associated with specific courses.
- **JWT Authentication**: Secures the API with token-based authentication.
- **Validation**: Validates input data for all endpoints to ensure data integrity.
- **API Documentation**: Provides interactive API documentation using OpenAPI (via SpringDoc).

## API Endpoints

### Authentication
- **POST /login**: Authenticates a user and returns a JWT token.

### Users
- **POST /register**: Registers a new user.

### Topics
- **POST /topics**: Creates a new discussion topic.
- **GET /topics**: Lists all discussion topics.
- **GET /topics/{id}**: Retrieves details of a specific topic.

### Responses
- **POST /responses**: Adds a response to a topic.

### Courses
- **GET /courses**: Lists all available courses.

## Requirements

- Java 17 or later.
- Maven 3.8.0 or later.
- A database system (default: MySQL).

## How to Use

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/julianamanzieri/forum_hub.git
    ```

2. **Install dependencies and build the project with Maven**:

    ```bash
    mvn clean install
    ```

3. **Configure the Database**:
   - Update the `src/main/resources/application.properties` file with your database credentials.

    Example configuration for MySQL:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=validate
    ```

4. **Run Database Migrations**:

    ```bash
    mvn flyway:migrate
    ```

5. **Run the Project**:

    ```bash
    mvn spring-boot:run
    ```

6. **Access the API Documentation**:
   - Navigate to `http://localhost:8080/swagger-ui.html` to explore the API endpoints.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Security**
- **JPA (Java Persistence API)**
- **MySQL** (or other relational databases)
- **Flyway** (for database migrations)
- **JWT (JSON Web Token)** (for secure authentication)
- **SpringDoc OpenAPI** (for API documentation)

## Author

Developed by Juliana Manzieri. Connect with me on [LinkedIn](https://www.linkedin.com/in/julianamanzieri/).

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

