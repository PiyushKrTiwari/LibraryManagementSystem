# Library Management System

## 📚 Project Description

The Library Management System is a Java-based application developed to manage books, students, and book issue/return operations in a library.

The project uses Java for programming, MySQL for database management, JDBC for database connectivity, Maven for dependency management, and IntelliJ IDEA as the development environment.

## 🚀 Features

- Add new books
- View all books
- Search books
- Add students
- View students
- Issue books
- Return books
- Store information in MySQL database
- Java-MySQL connectivity using JDBC

## 🛠️ Technologies Used

- Java
- MySQL
- JDBC
- Maven
- IntelliJ IDEA
- Git
- GitHub

## 📂 Project Structure

```text
LibraryManagementSystem
│
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   ├── Main.java
│                   ├── config
│                   │   └── DBConnection.java
│                   ├── model
│                   │   ├── Book.java
│                   │   └── Student.java
│                   └── dao
│                       ├── BookDAO.java
│                       ├── StudentDAO.java
│                       └── IssueDAO.java
│
├── pom.xml
├── .gitignore
└── README.md
```

## 🗄️ Database

**Database Name:** `librarydb`

The application uses MySQL to store library information.

### Main Tables

- `books`
- `students`
- `issued_books`

## 🔌 Database Connectivity

The project connects Java with MySQL using JDBC.

```text
Java Application
       ↓
      JDBC
       ↓
     MySQL
```

## ⚙️ How to Run the Project

1. Install Java JDK.
2. Install MySQL.
3. Create a database named `librarydb`.
4. Create the required tables.
5. Open the project in IntelliJ IDEA.
6. Open `DBConnection.java`.
7. Enter your own MySQL username and password.
8. Make sure the MySQL JDBC dependency is available in `pom.xml`.
9. Run `Main.java`.

## 📖 Documentation

The complete project documentation is available in:

**Library Management System Project Guide PDF**

## 🎯 Learning Objectives

This project helps in understanding:

- Java programming
- Object-Oriented Programming
- JDBC
- MySQL
- SQL
- Maven
- Git
- GitHub
- Database connectivity

## 👨‍💻 Author

**Piyush Tiwari**

## 📌 Project Status

Completed as a beginner-level Java and MySQL project.
