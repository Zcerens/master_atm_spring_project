# ATM Project

This project presents an ATM (Automatic Teller Machine) simulation developed using Java Spring framework. The project enables users to perform basic banking operations such as withdrawing money, taking out loans, and paying debts.

## Features

- **Withdrawal:** Users can withdraw a certain amount of money from their accounts.
- **Loan Request:** Users can request loans within their credit limits.
- **Debt Payment:** Users can pay off their debts from their accounts.
- **Viewing Interest on Installments:** Users can calculate and view the amount of money with interest based on the number of installments.
- **Validation:** User inputs are validated according to validation rules. For example, if an invalid withdrawal amount or installment number is entered, error messages are displayed to the user.

## Technologies

- **Java Spring Framework:** The project is developed using the Java language with the Spring framework.
- **Eureka Server:** Eureka server is used for microservice architecture.
- **PostgreSQL Database:** PostgreSQL is chosen for data storage.
- **Docker:** PostgreSQL database is run in a Docker container.

## Audit Table

The project includes an audit table to track operations performed. This table records user operations along with date/time information to ensure data integrity.

## Getting Started

To run the project on your local machine, follow the steps below:

1. Clone the repository:

```bash
git clone https://github.com/user/repo.git

2. Start the PostgreSQL database Docker container:

docker-compose up -d

3.Navigate to the project directory and start the application:

cd atm-project
mvn spring-boot:run
Once the application has started, you can access the ATM simulation at http://localhost:8080
