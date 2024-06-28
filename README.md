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
- [Category and Subcategory Operations](#category-and-subcategory-operations)
    - [Category CRUD Operations](#category-crud-operations)
      - [Create Category](#create-category)
      - [Read All Categories](#read-all-categories)
      - [Update Category](#update-category)
      - [Delete Category](#delete-category)
    - [Subcategory CRUD Operations](#subcategory-crud-operations)
      - [Create Subcategory](#create-subcategory)
      - [Read All Subcategories](#read-all-subcategories)
      - [Update Subcategory](#update-subcategory)
      - [Delete Subcategory](#delete-subcategory)


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
    "question": "Which of the following are not OOPs pillars?",
    "option_one": "Abstraction",
    "option_two": "Inheritance",
    "option_three": "static",
    "option_four": "Polymorphism",
    "correct_option": "static",
    "positive_mark": "3",
    "negative_mark": "-1",
    "subcategory": {
        "subcategory_name": "OOPs",
        "subcategory_description": "OOPs for Java",
        "category": {
            "category_name": "Java",
            "category_description": "Core Java Category"
        }
    }
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


# Category and Subcategory Operations

## Category CRUD Operations

### Create Category

**POST** `http://localhost:8080/category/createCategory`

Create a new category using JSON payload in the request body.

### Read All Categories

**GET** `http://localhost:8080/category/getCategory`

Retrieve all categories stored in the database.

### Update Category

**PUT** `http://localhost:8080/category/updateCategory/{id}`

Update an existing category identified by categoryId using JSON payload in the request body.

### Delete Category

**DELETE** `http://localhost:8080/category/deleteCategaory/{id}`

Delete an existing category identified by categoryId.

## Subcategory CRUD Operations

### Create Subcategory

**POST** `http://localhost:8080/subcategory/createSubcategory`

Create a new subcategory using JSON payload in the request body.

### Read All Subcategories

**GET** `http://localhost:8080/subcategory/getSubcategory`

Retrieve all subcategories stored in the database.

### Update Subcategory

**PUT** `http://localhost:8080/subcategory/updateSubcategory/{id}`

Update an existing subcategory identified by subcategoryId using JSON payload in the request body.

### Delete Subcategory

**DELETE** `http://localhost:8080/subcategory/deleteCategory/{id}`

Delete an existing subcategory identified by subcategoryId.






