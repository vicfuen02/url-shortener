FROM eclipse-temurin:25-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
COPY ./url-shortener-gateway-api/pom.xml ./service/
COPY ./url-shortener-gateway-api/src ./service/src


RUN sed -i 's/\r$//' mvnw  \
    && ./mvnw install -N \
    && cd service/ && ../mvnw dependency:go-offline -B \
    && ../mvnw clean package -DskipTests



FROM eclipse-temurin:25-jre-alpine

WORKDIR /home/app

COPY --from=builder /home/app/service/target/url-shortener-gateway-api-*.jar url-shortener-gateway-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/app/url-shortener-gateway-api.jar"]