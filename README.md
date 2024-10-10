# Simple Banking Application API

## Overview

This is a RESTful API for a banking application built using Spring Boot. The API allows users to manage bank accounts, including creating accounts, depositing and withdrawing funds, and retrieving account information.

## Features

- Create a new bank account
- Deposit money into an account
- Withdraw money from an account
- Retrieve account details by ID
- List all accounts
- Delete an account

## Technologies Used

- **Java**: Version 17
- **Spring Boot**: Version 3.3.4
- **Spring Data JPA**: For database interactions
- **MySQL**: Database for storing account information
- **Lombok**: For reducing boilerplate code
- **Maven**: For project management and dependency management

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- MySQL Server

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/banking-api.git
   cd banking-api
   ```

2. Create a MySQL database:

   ```sql
   CREATE DATABASE banking_app;
   ```

3. Update the `src/main/resources/application.properties` file with your MySQL credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/banking_app
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build the project using Maven:

   ```bash
   ./mvnw clean install
   ```

5. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

### API Endpoints

- **Create Account**
  - `POST /api/accounts`
  - Request Body: `{"accountHolderName": "John Doe", "balance": 1000.0}`

- **Get Account by ID**
  - `GET /api/accounts/{id}`

- **Deposit Money**
  - `PUT /api/accounts/{id}/deposit`
  - Request Body: `{"amount": 500.0}`

- **Withdraw Money**
  - `PUT /api/accounts/{id}/withdraw`
  - Request Body: `{"amount": 200.0}`

- **Get All Accounts**
  - `GET /api/accounts`

- **Delete Account**
  - `DELETE /api/accounts/{id}`

