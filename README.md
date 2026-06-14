# Hostel Management System

A desktop-based **Hostel Management System** built using **Java Swing**, **JDBC**, and **MySQL**.
The application provides a graphical interface to manage hostel room allocations and student records efficiently while following a clean layered architecture.

---

## Features

* Add student hostel records through GUI
* Allocate rooms to students
* View all hostel records in a table (JTable)
* Delete student records by ID
* Fetch student details by ID *(backend ready)*
* Update room allocation information *(backend ready)*
* Input validation through service layer

---

## Tech Stack

* Java (Swing)
* JDBC
* MySQL
* SQL

---

## Project Structure

```text
Hostel-Management-System/
│
├── src/
│   ├── dao/        → database interaction (JDBC)
│   ├── dto/        → hostel/student data model
│   ├── service/    → business logic & validation
│   ├── ui/         → Swing GUI
│   └── mysql-connector-j-9.x.x.jar
│
├── .gitignore
└── README.md
```

---

## Architecture Overview

The project follows a layered architecture to ensure clear separation of responsibilities:

* **DTO** – represents student and room allocation data
* **DAO** – handles database operations using JDBC
* **Service** – manages validations and business rules
* **UI** – provides a graphical interface for user interaction

---

## Database Setup

```sql
CREATE DATABASE rnsitdb;
USE rnsitdb;

CREATE TABLE hostel_students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    room_number INT,
    block_name VARCHAR(50),
    status VARCHAR(20)
);
```

---

## Running the Project

1. Ensure MySQL server is running
2. Update database credentials in:

   ```
   dao/HostelDAOImpl.java
   ```
3. Compile the project:

   ```bash
   javac -d . -cp src/mysql-connector-j-9.x.x.jar src/*/*.java
   ```
4. Run the application:

   ```bash
   java -cp ".;src/mysql-connector-j-9.x.x.jar" ui.HostelUI
   ```

---

## Future Improvements

* Room availability tracking
* Automatic room allocation
* Search students by room number
* Add authentication system
* Hostel fee management module
* Student check-in/check-out tracking

---

## What I Learned

* Structuring Java applications using layered architecture
* Integrating Java Swing with MySQL using JDBC
* Managing hostel records using SQL
* Building interactive desktop-based applications

---

## Author

Kulsum Aftab
