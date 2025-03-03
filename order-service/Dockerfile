# Build stage
FROM maven:3.8.8-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy the whole multi-module project, not just order-service
COPY . .

# Build the parent module first (only if it hasn't been built)
RUN mvn -f /app/pom.xml clean install -N

# Build the specific service
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built JAR file from the correct path
COPY --from=builder /app/order-service/target/order-service-*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]