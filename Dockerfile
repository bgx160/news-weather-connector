# Use an official OpenJDK image as a parent image
FROM openjdk:17-jdk-alpine

RUN mvn clean package

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file to the container
COPY target/*.jar app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
