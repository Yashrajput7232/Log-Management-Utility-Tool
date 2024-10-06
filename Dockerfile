# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Download all dependencies. This step is separated from copying source code
# to utilize Docker cache for faster builds when only dependencies change.
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the container
COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]