# Build stage
FROM maven:3.8.8-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy the whole multi-module project, not just inventory-service
COPY . .

# Build the parent module first
RUN mvn -f /app/pom.xml clean install -N

# Build the specific service
RUN mvn -f /app/inventory-service/pom.xml clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built JAR file from the correct path
COPY --from=builder /app/inventory-service/target/inventory-service.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]