FROM eclipse-temurin:25-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
COPY ./url-shortener-cassandra-common/pom.xml ./common/
COPY ./url-redirect-service/pom.xml ./service/

COPY ./url-shortener-cassandra-common/src ./common/src
COPY ./url-redirect-service/src ./service/src


RUN sed -i 's/\r$//' mvnw  \
    && ./mvnw install -N \
    && cd common/ && ../mvnw dependency:go-offline -B \
    && cd common/ && ../mvnw clean package install -DskipTests \
    && cd service/ && ../mvnw dependency:go-offline -B \
    && cd service/ && ../mvnw clean package -DskipTests



FROM eclipse-temurin:25-jre-alpine

WORKDIR /home/app

COPY --from=builder /home/app/service/target/url-redirect-service-*.jar url-redirect-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/app/url-redirect-service.jar"]