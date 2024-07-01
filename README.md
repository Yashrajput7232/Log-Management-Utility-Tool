

This project is a log management system built with Spring Boot, designed to ingest logs over HTTP and provide a user-friendly interface for querying logs based on various parameters. The system leverages the robustness of Java and the efficiency of Spring Boot to handle log data efficiently.

Owner of the Repo-
- Name: Yash Rajput
- Email: yashrajput02.scoe.comp@gmail.com

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation and Configuration](#installation-and-configuration)
- [System Overview](#system-overview)
- [Usage](#usage)
- [Run using Docker](#run-using-docker)
- [Features](#features)
- [Optional: Video/Presentation](#optional-videopresentation)

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Java JDK 11 or later
- Maven 3.6 or later
- Docker (for Docker deployment)

## Installation and Configuration

To install and configure this Spring Boot application, follow these steps:
1. Clone the repository.
2. Navigate to the project directory and run `mvn clean install` to build the project.
3. Configure application properties in `src/main/resources/application.properties`.

## System Overview

This Spring Boot application is structured following MVC architecture, ensuring separation of concerns and ease of maintenance. It integrates with an MongoDB database for log storage and retrieval.

## Usage

To run the application:
1. Execute `mvn spring-boot:run` to start the application.
2. Access the log query interface at `http://localhost:3000`frontend .
3. To Inject the log you can use curl command 
    ```bash
        curl -X POST -H "Content-Type: application/json" -d '{
    "level": "error",
    "message": "Failed to connect to DB",
    "resourceId": "server-1234",
    "timestamp": "2023-09-15T08:00:00Z",
    "traceId": "abc-xyz-123",
    "spanId": "span-456",
    "commit": "5e5342f",
    "metadata": {
        "parentResourceId": "server-0987"
    }
    }' http://localhost:3000/ingest
    ```


4. Now a search page 
    ![screenshots](screenshots/index.png)

5. Now query accordingly you will get the results below
     ![screenshots](screenshots/query.png)
     ![screenshots](screenshots/output.png)
    
## Run-Using-Docker

1. Pull the image using command
    ```bash
        docker pull yash7232/log-query-manager5:latest
    ```
2. Run the conatiner suing the command 
    ``` bash 
        docker run -p 3000:3000 yash7232/log-query-manager5:latest
    ```


## features 

   1. Log ingestion over HTTP.
   2. Real-time log searching.
   3. Full-text search with regular expressions.
   4. Search filters based on log parameters.
   5. Search within specific date ranges.
   6. Scalability: Adaptability to increasing volumes of logs/queries.(Dockerized the appliction)
   7. Usability: Intuitive, user-friendly interface.
