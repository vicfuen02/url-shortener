FROM eclipse-temurin:25-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
RUN sed -i 's/\r$//' mvnw && ./mvnw dependency:go-offline -B
COPY src ./src

RUN ./mvnw clean package -DskipTests



FROM eclipse-temurin:25-jre-alpine

WORKDIR /home/app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} url-shortening-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/app/url-shortening-service.jar"]