# Use OpenJDK base image
FROM openjdk:17

# Set working directory inside container
WORKDIR /simple-api-example

# Copy Gradle wrapper and build scripts
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src src

# Make the Gradle wrapper executable
RUN chmod +x gradlew

# Run tests by default
CMD ["./gradlew", "test"]
