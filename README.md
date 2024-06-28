# TestManagement

TestManagement is a Spring Boot application for managing multiple-choice questions via REST API.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Database Configuration](#database-configuration)
  - [Run the Application](#run-the-application)
- [API Endpoints](#api-endpoints)
  - [Create MCQ Question](#create-mcq-question)
  - [Read All Questions](#read-all-questions)
  - [Read Specific Question](#read-specific-question)
  - [Update Question](#update-question)
  - [Delete Question](#delete-question)


## Introduction
This project, TestManagement, is designed to facilitate the management of multiple-choice questions (MCQs) through a RESTful API. It allows users to perform CRUD operations on MCQ questions stored in a PostgreSQL database. Each question includes details such as category, options, correct answer, and scoring.

## Technologies Used
- Spring Boot 3 (latest)
- PostgreSQL
- Hibernate (as the JPA implementation)
- JUnit 5
- Graddle (for dependency management)
- Postman (for API testing)

## Setup Instructions
### Prerequisites
Make sure you have the following installed:
- Java 21 SDK
- Graddle
- PostgreSQL

### Clone the Repository
Clone the TestManagement repository from GitHub:
- git clone <repository_url>
- cd TestManagement

## Database Configuration

### Create Database

Create a PostgreSQL database named TestManagementDB.

### Configure Database Connection

Update `application.properties` file located in `src/main/resources` with your PostgreSQL database configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/TestManagementDB
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Setup Instructions

### Run the Application
To start the application, navigate to the root directory of the project and run:
```bash
mvn spring-boot:run
```

## API Endpoints

### Create MCQ Question

**POST** `(http://localhost:8080/mcq/createQuestion)`

Create a new MCQ question using JSON payload in the request body.

#### Example Request Body:

```json
{
    "category": "SpringBoot",
    "question": "In Spring Boot @RestController annotation is equivalent to",
    "optionOne": "@Controller and @PostMapping",
    "optionTwo": "@Controller and @Component",
    "optionThree": "@Controller and @ResponseBody",
    "optionFour": "@Controller and @ResponseStatus",
    "correctOption": "@Controller and @ResponseBody",
    "positiveMark": 3,
    "negativeMark": -1
}
```
## API Endpoints

### Read All Questions

**GET** `(http://localhost:8080/mcq/getAllQuestion)`

Retrieve all MCQ questions stored in the database.

### Read Specific Question

**GET** `(http://localhost:8080/mcq/getQuestion/3)`

Retrieve a specific MCQ question by its `questionId`.

### Update Question

**PUT** `(http://localhost:8080/mcq/updateQuestion/3?category=Core Java&question=Which access modifier cannot access other than its own class&option_one=public&option_two=default&option_three=private&option_four=protected&correct_option=private)`

Update an existing MCQ question identified by `questionId` using JSON payload in the request body.

### Delete Question

**DELETE** `(http://localhost:8080/mcq/deleteQuestion/3)`

Delete an existing MCQ question identified by `questionId`.








