# Currency Exchange Demo

This is a demo project for a Currency Exchange Service using Spring Boot. It demonstrates how to build a REST API that validates user input and performs currency conversions based on static exchange rates.

## Features

- Currency conversion with validation for source, target, and amount.
- Amounts can be input with or without thousands separators (e.g., "1,525" or "1525").
- Results are rounded to two decimal places and formatted with thousands separators.
- Docker Compose is use for easy environment setup and deployment.

## Technologies

- Spring Boot 3.2.5
- Maven for dependency management
- Java 17
- Docker and Docker Compose for containerization and orchestration

## Running the Application

0. **Before running this application, ensure that Docker and Docker Compose are installed on your machine.**

1. **Clone the repository:**

   ```bash
   git clone https://github.com/aa8100225/CurrencyExchangeDemo.git

   cd CurrencyExchangeDemo
   ```
2. **Run using Docker Compose:**

   ```bash
   docker-compose up
   ```

## API Usage
- GET /convert?source=USD&target=JPY&amount=1,525 

