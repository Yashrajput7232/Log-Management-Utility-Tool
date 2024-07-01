# Log Ingestor and Query Interface

## Overview

This project implements a Log Ingestor and Query Interface for efficiently handling and searching log data. The system allows logs to be ingested over HTTP and provides a user-friendly interface for querying logs based on various parameters.
Owner of the Repo-
name-yash Rajput
email-yashrajput02.scoe.comp@gmail.com.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation and configurations](#installation)
- [System overview](#system-overview)
- [Usage](#usage)
- [Run using Docker](#Run-Using-Docker)
- [Features](#features)
- [Optional: Video/Presentation](#optional-videopresentation)

## Prerequisites of system

- Python
- Flask

## Installation

1. Clone the repository:
 ```bash
   https://github.com/dyte-submissions/november-2023-hiring-Yashrajput7232.git
   ```

2. Install the libraires by the following command
  ```bash 
   pip install -r requirements.txt
   ```
3. Navigate into app directory
    ```bash
       cd app
    ```

4. Configure MongoDB:

    (I have connected this application with my dummny MongoDb database you can use it too.but if you want to use your own database then follow the following commands)
    Create a MongoDB Atlas account.
    Replace username and password in app.py with your MongoDB credentials.
    Update the MongoDB connection string in app.py.


## system-overview
![screenshots](screenshots/sys.png)
![screenshots](screenshots/classdiag.png)


## Usage

make sure all the insatllation steps are completed

1. Once you are in app directory run folloeing command
    ```bash
    python main.py
    ```
    the flask app will start 
2. Open the browser and typre 
    ```bash
    http://localhost:3000/
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
    or you can use the ingestor.py file
    it is a python script which injest logs 

    first be in the directory where the injest.py file is there.

    ```bash
    python injest.py
    ```

3. Now a search page 
    ![screenshots](screenshots/index.png)

4. Now query accordingly you will get the results below
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

This Spring Boot application is structured following MVC architecture, ensuring separation of concerns and ease of maintenance. It integrates with an H2 database for log storage and retrieval but can be configured to use other SQL databases.

## Usage

To run the application:
1. Execute `mvn spring-boot:run` to start the application.
2. Access the log query interface at `http://localhost:8080`.

## Run using Docker

To containerize and run the application using Docker:
1. Build the Docker image: `docker build -t log-management-system .`
2. Run the container: `docker run -p 8080:8080 log-management-system`

## Features

- Log ingestion over HTTP
- User-friendly log query interface
- Support for various query parameters
- Docker support for easy deployment

## Optional: Video/Presentation

For a detailed walkthrough of the application, refer to the [Video/Presentation](#) link (if available).