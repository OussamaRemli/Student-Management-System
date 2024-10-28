# Student Management JavaFX Application

This JavaFX-based desktop application allows users to manage a list of students, supporting operations such as adding, viewing, updating, deleting, and printing student details. It connects to a database for data storage and retrieval.

## Features

- **Add New Students**: Form for adding student details (first name, last name, CNE, email).
- **View Student List**: Table view displaying the list of students stored in the database.
- **Update Student Information**: Edit and save updates to a student's details.
- **Delete Students**: Remove a student from the database by CNE.
- **Print Student Information**: Print a formatted student record using the system's default printer.
- **Data Validation**: Validate email addresses and ensure unique CNE values for each student.

## Technologies Used

- **Java**: Core programming language.
- **JavaFX**: UI toolkit for building modern desktop applications.
- **JDBC**: For database connectivity.
- **CSS**: Custom stylesheet for JavaFX components.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- JavaFX SDK
- A compatible database (configured in the config class)
- IDE with JavaFX support (e.g., IntelliJ IDEA, Eclipse)

## Installation

### Clone the Repository

```bash
git clone https://github.com/OussamaRemli/Student-Management-System.git
cd Student-Management-System
```
### Database Setup

1. Ensure your database is set up and configured as specified in `database/config`.
2. Create a table named `etudiant` with columns for `firstname`, `lastname`, `identifiant`, and `email`. 

### Configure Database Connection

Adjust the `config` class to include your database's connection details.

### Run the Application

Compile and run the application using your IDE or command line.

