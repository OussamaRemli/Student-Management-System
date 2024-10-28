# Student Registration System

## Overview

A simple JavaFX Desktop Application to manage student registration for a school system. This mini-project demonstrates basic JavaFX GUI, MySQL database integration, and PDF generation for records.

## Features

- **Student Registration**: Register new students with basic details.
- **Database Storage**: Save and retrieve data using MySQL.
- **PDF Generation**: Export student records as PDF files.

## Technologies Used

- **JavaFX** - For the user interface
- **MySQL** - For data storage
- **JDBC** - For database connection
- **PDF Library** (like iText) - For creating PDF reports

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/student-registration-system.git
   cd student-registration-system
2. **Set Up the MySQL Database**
   - Open MySQL and run the SQL script to create the database and tables:
     ```sql
     CREATE DATABASE student_registration;
     USE student_registration;

     CREATE TABLE students (
         id INT PRIMARY KEY AUTO_INCREMENT,
         name VARCHAR(100),
         age INT,
         grade VARCHAR(10),
         registration_date DATE
     );
     ```

3. **Configure Database Connection**
   - Open the Java source code and update the database connection settings:
     ```java
     String url = "jdbc:mysql://localhost:3306/student_registration";
     String username = "your_database_username";
     String password = "your_database_password";
     ```

4. **Add PDF Library**  
   - Download and add a PDF generation library (e.g., iText) to the project’s library or `lib` folder to support PDF exports.

5. **Run the Application**
   - You can run the project through your IDE (like IntelliJ IDEA or Eclipse), or using Maven with the command:
     ```bash
     mvn javafx:run
     ```

## Usage

1. **Launch the Application**
   - Open the application by running `Main.java`.

2. **Register Students**
   - Use the registration form to enter student details such as name, age, grade, and registration date.
   - Click "Register" to save the information to the database.

3. **View and Export Records**
   - Select a student record to view details.
   - Click "Generate PDF" to create and save a PDF document of the student’s information locally.

## Database Configuration

Make sure your MySQL database configuration matches the settings below in your Java code:

- **Database URL:** `jdbc:mysql://localhost:3306/student_registration`
- **Username:** `your_database_username`
- **Password:** `your_database_password`

## License

This project is for educational purposes, created to explore JavaFX, MySQL, and PDF generation in a mini-project setup.
