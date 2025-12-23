FROM eclipse-temurin:25-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
COPY ./url-shortener-cassandra-common/pom.xml ./common/
COPY ./url-shortening-service/pom.xml ./service/

COPY ./url-shortener-cassandra-common/src ./common/src
COPY ./url-shortening-service/src ./service/src


RUN sed -i 's/\r$//' mvnw
RUN ./mvnw install -N
RUN cd common/ && ../mvnw dependency:go-offline -B \
    && ../mvnw clean package install -DskipTests
RUN cd service/ && ../mvnw dependency:go-offline -B \
    && ../mvnw clean package -DskipTests



FROM eclipse-temurin:25-jre-alpine

WORKDIR /home/app

COPY --from=builder /home/app/service/target/url-shortening-service-*.jar url-shortening-service.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/home/app/url-shortening-service.jar"]