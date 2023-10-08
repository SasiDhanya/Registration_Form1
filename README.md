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

# ![new db](https://github.com/paragERJ2EE/registration/assets/147278310/c5d178f5-34ff-4e12-b972-363d0e51788e)

# Running the Application
* Open the project in your IDE
* Build the project using Maven
* Start the Spring Boot application
* Access the application in your web browser at http://localhost:8080/registration/

# Usage
* Visit http://localhost:8080/registration/ to access the registration form and manage registration records.

* Use the form to insert new records click on insert Data tab at top right corner and for view records click on view records tab
  
# ![home](https://github.com/paragERJ2EE/registration/assets/147278310/9ef1c7d4-53df-43da-88c6-029fb1ef775c)

*  Use the form to insert new records click on insert Data tab
# ![insert data](https://github.com/paragERJ2EE/registration/assets/147278310/a687738c-088a-47c4-ad92-4048c6d1d723)

* Inserting new data
# ![record inserted](https://github.com/paragERJ2EE/registration/assets/147278310/5b30b35a-b201-4c96-bb12-1a4e20e6307b)

* Display Message: “Record inserted successfully”
# ![record inserted mgs](https://github.com/paragERJ2EE/registration/assets/147278310/1b8d55fc-3f0d-439c-9f97-39d4b84d8cf8)

* Validation rules are applied for data entered in the registration form, and appropriate error messages are displayed if validation fails.
*  For Pin (6 digit numeric), Email (use validation Only email allowed),
# ![validation error 2](https://github.com/paragERJ2EE/registration/assets/147278310/02dd695b-37c6-42a8-86e0-98a43c4c686f)

* For Contact (10 digit numeric)
# ![validation error](https://github.com/paragERJ2EE/registration/assets/147278310/b0abc6b3-95e6-4d34-953d-6a9f8d3f9381)


*  View existing records
# ![page 1 hv 8 data](https://github.com/paragERJ2EE/registration/assets/147278310/05169dd7-ad9e-422e-8615-caef52aefa60)


* View Record with Paging : 1 to 8 record > then (2nd)next page with Records are paginated with 8 records per page.
# ![page 1 hv 8 data](https://github.com/paragERJ2EE/registration/assets/147278310/acc2995a-027b-42f3-87fd-4d6bb0226af5)


* And (2nd)next page with Records are paginated with 8 records per page.
# ![page 2](https://github.com/paragERJ2EE/registration/assets/147278310/56f5c308-1299-4ee3-bf2c-5f07d18bb1ab)


* Edit existing records, Here ID 1 name i am updating you can update any other field as well
# ![ID 1 existing records update with name](https://github.com/paragERJ2EE/registration/assets/147278310/8358688b-ec43-4b4f-9c1f-9b5b001d709e)

* I am changing name sharma to kumar
# ![update 1 name](https://github.com/paragERJ2EE/registration/assets/147278310/48f4859f-d37a-410f-8e94-3c8f2ef90b07)

* Now you can see name updated successfully
# ![name update](https://github.com/paragERJ2EE/registration/assets/147278310/14c4f76c-0dc0-4d40-aba2-2885c6791a5a)

* I am Deleting ID 13 From records 
# ![Delete](https://github.com/paragERJ2EE/registration/assets/147278310/4ba047b7-0b1a-4155-9467-fba392855372)

* ID 13 Deleted successfully from Records List
# ![Deleted records](https://github.com/paragERJ2EE/registration/assets/147278310/35feb310-3beb-43c4-be32-9225016dce4c)

*  ID 13 Deleted successfully from Mysql Database also
# ![id de](https://github.com/paragERJ2EE/registration/assets/147278310/335f6707-8a0c-44d0-a3ff-7aba32d7c441)

* List of all records save in Mysql Database
# ![db list](https://github.com/paragERJ2EE/registration/assets/147278310/cc78da86-492a-41bf-9be2-1d9c7b97884b)


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
