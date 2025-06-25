# Start with a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/todo-*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Set the command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
