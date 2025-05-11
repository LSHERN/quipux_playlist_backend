FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
COPY src/main/resources/import.sql /docker-entrypoint-initdb.d/import.sql
EXPOSE 7001
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
