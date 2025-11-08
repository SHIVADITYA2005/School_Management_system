<!-- PROJECT LOGO -->
<p align="center">
  <img src="https://img.icons8.com/color/96/school-building.png" alt="Logo" width="100" height="100">
</p>

<h1 align="center">🎓 Student Management System</h1>

<p align="center">
  <i>A comprehensive Java-based desktop application for automating school operations and academic data management.</i>
</p>

<p align="center">
  <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/Java-17-orange?logo=java&logoColor=white" alt="Java Badge"></a>
  <a href="https://www.mysql.com/"><img src="https://img.shields.io/badge/MySQL-Database-blue?logo=mysql&logoColor=white" alt="MySQL Badge"></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-green.svg" alt="MIT License"></a>
  <a href="#"><img src="https://img.shields.io/badge/IDE-VSCode-blue?logo=visualstudiocode&logoColor=white" alt="VSCode Badge"></a>
  <a href="#"><img src="https://img.shields.io/badge/Build-Stable-success?logo=githubactions&logoColor=white" alt="Build Status"></a>
</p>

---

## 🏫 Project Overview

The **Student Management System (SMS)** is a Java desktop application built using **Java Swing**, **MySQL**, and **JDBC**.  
It helps educational institutions **automate and centralize** administrative tasks such as managing students, teachers, subjects, attendance, and enrollment data.

> 💡 Designed with modular architecture, intuitive GUI, and real-time data handling — this project bridges the gap between traditional record systems and digital management.

---

## ✨ Key Features

| Module | Description |
|---------|-------------|
| 🎓 **Student Management** | Add, edit, delete, and view student records. |
| 👩‍🏫 **Teacher Management** | Manage teacher details, subjects, and salary. |
| 📚 **Subject Management** | Assign subjects and link them to teachers. |
| 🏫 **Classroom Management** | Manage classrooms, lab/theory types, and floors. |
| 🧾 **Enrollment Management** | Enroll students into subjects with unique IDs. |
| 📅 **Attendance Tracking** | Mark and monitor daily attendance. |
| 💾 **Database Integration** | Data stored securely using MySQL and JDBC. |
| 💻 **GUI** | Built with Java Swing for a desktop-friendly experience. |

---

## 🧠 System Architecture

```plaintext
┌────────────────────────┐
│    Frontend (GUI)      │ ← Java Swing / AWT
└──────────┬─────────────┘
           │
┌──────────▼─────────────┐
│  Backend (Logic Layer) │ ← Core Java Classes (DAO, Models)
└──────────┬─────────────┘
           │
┌──────────▼─────────────┐
│  Database (Storage)    │ ← MySQL (via JDBC)
└────────────────────────┘
⚙️ Technologies Used
Category	Technology
Programming Language	Java (JDK 8 or above)
GUI Framework	Java Swing / AWT
Database	MySQL 5.5+
Connector	JDBC (mysql-connector-j-9.5.0.jar)
IDE	Visual Studio Code
Optional	StarUML for UML Diagrams

🗂 Folder Structure
graphql
Copy code
root/
│
├── src/
│   ├── attributes/      # POJO classes (Student, Teacher, Subject, etc.)
│   ├── execution/       # DAO classes (Database operations)
│   ├── frontend/        # Java Swing GUI files
│   ├── connection/      # Database connection (Connect.java)
│
├── lib/                 # JDBC driver (mysql-connector-j-9.5.0.jar)
├── bin/                 # Compiled .class files
└── README.md            # You’re reading it!
🧩 Installation & Execution
🪜 Step 1: Clone this Repository
bash
Copy code
git clone https://github.com/SHIVADITYA2005/School_Management_system.git
cd School_Management_system
🪜 Step 2: Configure MySQL Database
Install MySQL and create a database named:

sql
CREATE DATABASE school_management;
Import your tables and schema.

🪜 Step 3: Compile the Project
bash
javac -cp "lib/mysql-connector-j-9.5.0.jar;src" -d bin src/frontend/*.java src/execution/*.java src/attributes/*.java src/connection/*.java
🪜 Step 4: Run the Application
bash
java -cp "lib/mysql-connector-j-9.5.0.jar;bin" frontend.Main
📚 Learning Outcomes
Through this project, I learned:

🔹 Full-stack Java development (Frontend + Backend + Database)

🔹 Database connectivity with JDBC & DAO pattern

🔹 Secure query execution using PreparedStatements

🔹 GUI event-driven programming (Swing)

🔹 Project modularization and maintainable code structure

🖼️ Preview
🏠 Dashboard	🎓 Student Module	👩‍🏫 Teacher Module

📚 Subject Management	🧾 Enrollment	📅 Attendance


👨‍💻 Author
Developed by:
🧑‍💻 Shivaditya
🎓 B.Tech CSE (AIML), SRM Institute of Science & Technology, NCR Campus
📧 shivaditya2005@gmail.com
🔗 GitHub Profile

🪪 License
This project is open-source under the MIT License.
You can freely use, modify, and distribute it with attribution.

💬 Acknowledgements
Special thanks to

🧑‍🏫 Dr. S. Palanivel – Project Supervisor

🎓 Department of Computer Science & Engineering, SRM IST, NCR Campus
for their guidance and encouragement during this project.

---

```

<p align="center">
  <img src="https://img.icons8.com/color/96/java-coffee-cup-logo.png" width="70" alt="Java Logo">
</p>

<h3 align="center">"Empowering education through digital innovation."</h3>

<p align="center">
  <a href="https://github.com/SHIVADITYA2005/School_Management_system">
    <img src="https://img.shields.io/github/stars/SHIVADITYA2005/School_Management_system?style=social" alt="GitHub stars">
  </a>
  <a href="https://github.com/SHIVADITYA2005/School_Management_system/fork">
    <img src="https://img.shields.io/github/forks/SHIVADITYA2005/School_Management_system?style=social" alt="GitHub forks">
  </a>
</p>

