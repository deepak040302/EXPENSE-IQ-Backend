# EXPENSE-IQ-Backend

# EXPENSE-IQ Backend

**EXPENSE-IQ** is a Spring Boot-based backend for an expense tracker application that helps users manage their income, expenses, and financial goals. This backend provides REST APIs for performing various operations related to expense tracking, authentication, and reporting.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [License](#license)

---

## Features

- User Authentication & Authorization
- Manage Income and Expenses
- Track Balance and Transaction History
- Currency Settings with Conversion
- Notifications and Reminders
- Graphs and Analytics
- Smart Search for Transactions

## Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** - for data management
- **Oracle SQL** - as the database
- **Spring Security** - for user authentication
- **gRPC** (for communication, if used in advanced features)
- **Llama 3 Model** (for smart search functionalities)
  
## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/username/EXPENSE-IQ-Backend.git
   cd EXPENSE-IQ-Backend
2. **Configure the Database:** Update the application.properties with your database settings.
3. Build and Run the Application:
   ```bash
   mvn clean install
   mvn spring-boot:run
