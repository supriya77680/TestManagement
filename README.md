<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TestManagement</title>
</head>
<body>
    <h1>TestManagement</h1>

    <h2>Introduction</h2>
    <p>TestManagement is a Spring Boot application for managing multiple-choice questions via REST API. It allows users to perform CRUD operations on MCQ questions stored in a PostgreSQL database. Each question includes details such as category, options, correct answer, and scoring.</p>

    <h2>Technologies Used</h2>
    <ul>
        <li>Java 21</li>
        <li>Spring Boot 3 (latest)</li>
        <li>PostgreSQL</li>
        <li>Hibernate (as the JPA implementation)</li>
        <li>JUnit 5</li>
        <li>Maven (for dependency management)</li>
        <li>Postman (for API testing)</li>
    </ul>

    <h2>Setup Instructions</h2>

    <h3>Prerequisites</h3>
    <p>Make sure you have the following installed:</p>
    <ul>
        <li>Java 21 SDK</li>
        <li>Maven</li>
        <li>PostgreSQL</li>
    </ul>

    <h3>Clone the Repository</h3>
    <p>Clone the TestManagement repository from GitHub:</p>
    <pre><code>git clone &lt;repository_url&gt;
cd TestManagement
    </code></pre>

    <h3>Database Configuration</h3>
    <p>Create Database:</p>
    <p>Create a PostgreSQL database named <code>TestManagementDB</code>.</p>
    <p>Configure Database Connection:</p>
    <p>Update <code>application.properties</code> file located in <code>src/main/resources</code> with your PostgreSQL database configuration:</p>
    <pre><code>spring.datasource.url=jdbc:postgresql://localhost:5432/TestManagementDB
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
    </code></pre>

    <h3>Run the Application</h3>
    <p>Navigate to the root directory of the project and run the following Maven command:</p>
    <pre><code>mvn spring-boot:run
    </code></pre>
    <p>The application will start on the default port 8080.</p>

    <h2>API Endpoints</h2>

    <h3>Create MCQ Question</h3>
    <p><strong>POST</strong> <code>/api/questions</code></p>
    <p>Create a new MCQ question using JSON payload in the request body.</p>
    <p>Example Request Body:</p>
    <pre><code>{
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
    </code></pre>

    <h3>Read All Questions</h3>
    <p><strong>GET</strong> <code>/api/questions</code></p>
    <p>Retrieve all MCQ questions stored in the database.</p>

    <h3>Read Specific Question</h3>
    <p><strong>GET</strong> <code>/api/questions/{questionId}</code></p>
    <p>Retrieve a specific MCQ question by its <code>questionId</code>.</p>

    <h3>Update Question</h3>
    <p><strong>PUT</strong> <code>/api/questions/{questionId}</code></p>
    <p>Update an existing MCQ question identified by <code>questionId</code> using JSON payload in the request body.</p>

    <h3>Delete Question</h3>
    <p><strong>DELETE</strong> <code>/api/questions/{questionId}</code></p>
    <p>Delete an existing MCQ question identified by <code>questionId</code>.</p>

    <h2>Testing</h2>
    <p>Use Postman or any API testing tool to test the endpoints defined above. Ensure to test all CRUD operations thoroughly.</p>

    <h2>Contributing</h2>
    <p>Contributions are welcome! If you have any suggestions or improvements, please fork the repository and create a pull request.</p>

    <h2>License</h2>
    <p>This project is licensed under the MIT License.</p>

    <p><strong>Notes:</strong></p>
    <ul>
        <li>Replace <code>&lt;repository_url&gt;</code>, <code>your_username</code>, and <code>your_password</code> with appropriate values according to your setup.</li>
        <li>Ensure to keep the README updated with any changes or additions to the project.</li>
        <li>Provide detailed instructions on how to use and test the API endpoints.</li>
        <li>Include any additional information specific to your project setup or configuration.</li>
    </ul>

    <p>This README file serves as a guide for anyone cloning and working with your TestManagement project, ensuring they can easily set up the environment, understand the project structure, and effectively utilize the provided REST API. Adjust the contents as per your project's specific details and requirements.</p>
</body>
</html>
