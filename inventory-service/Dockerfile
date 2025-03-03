# Build stage
FROM maven:3.8.8-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy the whole multi-module project
COPY . .

# Build the parent module first (non-recursive)
RUN mvn clean install -N

# Build the inventory-service module
WORKDIR /app/inventory-service
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built JAR file with the correct name
COPY --from=builder /app/inventory-service/target/inventory-service-*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]