# 🎓 Student OS | Modern Management System

![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![UI](https://img.shields.io/badge/UI-Glassmorphism-purple.svg)

**Student OS** is a premium, high-end Student Management System built with a focus on modern aesthetics and secure, scalable backend architecture. Featuring a stunning **Glassmorphism UI**, it provides a seamless experience for managing student records with role-based access control.

---

## ✨ Key Features

- **🎨 Glassmorphism UI**: A futuristic, transparent design system with vibrant gradients and smooth micro-animations.
- **🔐 Secure Authentication**: JWT-based stateless authentication with secure login and registration.
- **👤 Role-Based Access Control (RBAC)**:
  - **ADMIN**: Full CRUD permissions (Add, Edit, Delete, View).
  - **USER**: Read-only access to student records.
- **📊 Advanced Data Handling**:
  - Server-side pagination for high performance.
  - Real-time search/filtering functionality.
  - Form validation with descriptive error messages.
- **📱 Responsive Design**: Fully optimized for desktops, tablets, and mobile devices.
- **🛠 Database Flexibility**: Out-of-the-box support for H2 (In-Memory) and easy configuration for MySQL.

---

## 🛠 Tech Stack

### Backend
- **Framework**: Spring Boot 3.4.0
- **Security**: Spring Security + JWT (JSON Web Tokens)
- **Data**: Spring Data JPA
- **Database**: H2 (Development) / MySQL (Production)
- **Utilities**: Lombok, Jakarta Validation

### Frontend
- **Logic**: Vanilla JavaScript (Modern ES6+)
- **Styling**: Custom CSS3 (Glassmorphism, Flexbox/Grid)
- **Icons**: Font Awesome 6.4.0
- **Fonts**: Google Fonts (Outfit)

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Node.js (Optional, for advanced frontend tooling)

### Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd Studentapp/studentapp
   ```

2. **Configure Database**:
   By default, the app uses **H2 In-Memory Database**. To use MySQL, update `src/main/resources/application.properties`:
   ```properties
   # Uncomment for MySQL
   # spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   # spring.datasource.username=your_username
   # spring.datasource.password=your_password
   ```

3. **Build and Run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the App**:
   Open `http://localhost:8080` in your browser.

---

## 🔑 Default Credentials

The system comes pre-loaded with the following accounts for testing:

| Role | Username | Password |
| :--- | :--- | :--- |
| **Administrator** | `admin` | `admin123` |
| **Standard User** | `user` | `user123` |

### 🛠 Database Console
- **H2 Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:student_db`
- **Username**: `sa`
- **Password**: `(empty)`

---

## 📡 API Endpoints Summary

### Auth API (`/api/auth`)
- `POST /login` - User login (returns JWT)
- `POST /register` - User registration

### Student API (`/api/students`)
- `GET /` - List all students (paginated + search)
- `GET /{id}` - Get student by ID
- `POST /` - Add new student (**ADMIN only**)
- `PUT /{id}` - Update student (**ADMIN only**)
- `DELETE /{id}` - Delete student (**ADMIN only**)

---

## 📂 Project Structure

```text
.
├── studentapp/             # Main Spring Boot Project
│   ├── src/main/java/
│   │   └── com/example/studentapp/
│   │       ├── config/     # Security, JWT, Data Init
│   │       ├── controller/ # REST Controllers
│   │       ├── dto/        # Data Transfer Objects
│   │       ├── exception/  # Global Exception Handling
│   │       ├── model/      # JPA Entities
│   │       ├── repository/ # Data Access Layer
│   │       └── service/    # Business Logic
│   └── src/main/resources/
│       ├── static/         # Frontend Assets (Glassmorphism UI)
│       └── templates/      # (Optional) Server-side templates
└── README.md               # Project Documentation
```

---

## 📝 License
Built with ❤️ by ❤️ for 4th Semester Project.
