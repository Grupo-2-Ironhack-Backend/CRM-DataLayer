FROM maven:3.8.6 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package
RUN rm target/original*

FROM openjdk:19-jdk-alpine3.16
ARG JAR_FILE=/app/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]
