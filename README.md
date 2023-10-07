# Registration Application Form
* The Spring Boot Registration Application Form is a web-based registration form that allows users to insert, view, update, and delete registration records. It provides a user-friendly interface for managing registration information

# Table of Contents
* Features
* Prerequisites
* Getting Started
* Running the Application
* Usage
* Project Structure
* Technologies Used

# Features
* City
* Pin (6-digit numeric)
* State
* Email (validated for proper email format)
* Contact (10-digit numeric)
* View, Insert, Update, and Delete operations for registration records.
* Data validation during insertion with error messages.
* Paging of records (8 records per page).

# Prerequisites
Before you begin, ensure you have met the following requirements

* Java Development Kit (JDK) 1.8
* Maven (for building the project)
* MySQL Database (for database storage)
* IDE I am using IntelliJ IDEA

# Getting Started
* Installation
* Clone this repository to your local machine
* Create a MySQL database named application_form. You can change the database configuration in src/main/resources/application.properties if needed.

  ![new db](https://github.com/paragERJ2EE/registration/assets/147278310/e429199f-d2c2-42ce-a92d-ca40c80a5353)

  
# Running the Application
* Open the project in your IDE
* Build the project using Maven
* Start the Spring Boot application
* Access the application in your web browser at http://localhost:8080/registration/

# Usage
* Visit http://localhost:8080/registration/ to access the registration form and manage registration records.

  ![home](https://github.com/paragERJ2EE/registration/assets/147278310/cbfc5647-3179-4d29-bc7c-38e80796319b)

* Use the form to insert new records click on insert tab at to right corner.
  

*
*
*
*  view existing records, edit records, or delete records.
* Validation rules are applied for data entered in the registration form, and appropriate error messages are displayed if validation fails.
* Records are paginated with 8 records per page.











# Project Structure
The project is organized as follows

* src/main/java/com/registration: Java source code for the application.
* entity: Entity classes representing database tables.
* payload: DTO (Data Transfer Object) classes.
* repository: Spring Data JPA repositories.
* service: Service interfaces and implementations.
* controller: Controllers for handling HTTP requests.
* src/main/resources: Configuration files and Thymeleaf templates.
* pom.xml: Maven project configuration file.

# Technologies Used
* Spring Boot
* Spring Data JPA
* Thymeleaf (HTML template engine)
* MySQL Database
* ModelMapper
* Lombok
* Validation API
* Bootstrap (for styling)
* HTML (HyperText Markup Language)
