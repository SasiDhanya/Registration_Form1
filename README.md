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

* Use the form to insert new records click on insert Data tab at top right corner and for view records click on view records tab
  
![home](https://github.com/paragERJ2EE/registration/assets/147278310/cbfc5647-3179-4d29-bc7c-38e80796319b)

*  Use the form to insert new records click on insert Data tab
![insert data](https://github.com/paragERJ2EE/registration/assets/147278310/2eda3ceb-59c2-4c07-8d80-b14026108852)

* Inserting new data
![record inserted](https://github.com/paragERJ2EE/registration/assets/147278310/e4d610c3-63e2-479b-b87e-79591b6a815d)

* Display Message: “Record inserted successfully”
![record inserted mgs](https://github.com/paragERJ2EE/registration/assets/147278310/304861ac-ad5a-46c6-a44a-7cecf430038b)

* Validation rules are applied for data entered in the registration form, and appropriate error messages are displayed if validation fails.
*  For Pin (6 digit numeric), Email (use validation Only email allowed),
![validation error](https://github.com/paragERJ2EE/registration/assets/147278310/e808a263-f8cd-419b-8e3a-9c3f846a2b6c)

* For Contact (10 digit numeric)
![validation error](https://github.com/paragERJ2EE/registration/assets/147278310/85f6c255-5dfb-4f93-a287-5800b51a9ebe)


*  View existing records
![page 1 hv 8 data](https://github.com/paragERJ2EE/registration/assets/147278310/c6e59a1d-cd6d-44b2-aa07-e14e19da9ac6)


* View Record with Paging : 1 to 8 record > then (2nd)next page with Records are paginated with 8 records per page.
![page 1 hv 8 data](https://github.com/paragERJ2EE/registration/assets/147278310/c6e59a1d-cd6d-44b2-aa07-e14e19da9ac6)

* And (2nd)next page with Records are paginated with 8 records per page.
![page 2](https://github.com/paragERJ2EE/registration/assets/147278310/886d177d-7c39-4eb9-88de-6eccee5188fa)

* Edit existing records, Here ID 1 name i am updating you can update any other field as well
![ID 1 existing records update with name](https://github.com/paragERJ2EE/registration/assets/147278310/e6f700c9-ab09-4def-8bd3-68592c9893fa)

* I am changing name sharma to kumar
![update 1 name](https://github.com/paragERJ2EE/registration/assets/147278310/b37b7d7c-2fe6-4799-a59c-523e5a0172d8)

* Now you can see name updated successfully
![name update](https://github.com/paragERJ2EE/registration/assets/147278310/169721e5-bb62-4c47-a94c-9a34ed2fb5c9)

* I am Deleting ID 13 From records 
# ![Delete](https://github.com/paragERJ2EE/registration/assets/147278310/4ba047b7-0b1a-4155-9467-fba392855372)

* ID 13 Deleted successfully from Records List
# ![Deleted records](https://github.com/paragERJ2EE/registration/assets/147278310/35feb310-3beb-43c4-be32-9225016dce4c)

*  ID 13 Deleted successfully from Mysql Database also
# ![Deleted records from mysql database also](https://github.com/paragERJ2EE/registration/assets/147278310/c3594213-5642-42c6-a66e-db6a023d32cb)


* List of all records save in Mysql Database
# ![List of all records save in Mysql Database](https://github.com/paragERJ2EE/registration/assets/147278310/e8fc3b23-e59e-40da-9df4-b7b9cf89d0e2)


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

# Additional Note
* Remember to configure the application.properties file with the correct database connection details
