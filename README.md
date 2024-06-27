TestManagement
TestManagement is a Spring Boot application for managing multiple-choice questions via REST API.

Table of Contents
Introduction
Technologies Used
Setup Instructions
Prerequisites
Clone the Repository
Database Configuration
Run the Application
API Endpoints
Create MCQ Question
Read All Questions
Read Specific Question
Update Question
Delete Question
Testing
Contributing
License
Introduction
This project, TestManagement, is designed to facilitate the management of multiple-choice questions (MCQs) through a RESTful API. It allows users to perform CRUD operations on MCQ questions stored in a PostgreSQL database. Each question includes details such as category, options, correct answer, and scoring.

Technologies Used
Java 21
Spring Boot 3 (latest)
PostgreSQL
Hibernate (as the JPA implementation)
JUnit 5
Maven (for dependency management)
Postman (for API testing)
Setup Instructions
Prerequisites
Make sure you have the following installed:

Java 21 SDK
Maven
PostgreSQL
Clone the Repository
Clone the TestManagement repository from GitHub:

bash
Copy code
git clone <repository_url>
cd TestManagement
Database Configuration
Create Database:

Create a PostgreSQL database named TestManagementDB.

Configure Database Connection:

Update application.properties file located in src/main/resources with your PostgreSQL database configuration:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/TestManagementDB
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Run the Application
Navigate to the root directory of the project and run the following Maven command:

mvn spring-boot:run
The application will start on the default port 8080.

API Endpoints
Create MCQ Question
POST /api/questions

Create a new MCQ question using JSON payload in the request body.

Example Request Body:

json
Copy code
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
Read All Questions
GET /api/questions

Retrieve all MCQ questions stored in the database.

Read Specific Question
GET /api/questions/{questionId}

Retrieve a specific MCQ question by its questionId.

Update Question
PUT /api/questions/{questionId}

Update an existing MCQ question identified by questionId using JSON payload in the request body.

Delete Question
DELETE /api/questions/{questionId}

Delete an existing MCQ question identified by questionId.

Testing
Use Postman or any API testing tool to test the endpoints defined above. Ensure to test all CRUD operations thoroughly.

Contributing
Contributions are welcome! If you have any suggestions or improvements, please fork the repository and create a pull request.
