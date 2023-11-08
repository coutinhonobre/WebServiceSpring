# Use a image Java 11
FROM openjdk:16-jdk-slim 

# Set the working directory to /app
WORKDIR /app

# Copy your project source code to the container
COPY . /app

# Permission
RUN chmod +x mvnw

# Build the application with Maven
RUN ./mvnw package -DskipTests

# Run application
CMD ["java", "-jar", "target/ifgoias.jar"]

