FROM maven:3.8.6 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -e -B package
RUN mv target/homeworkCRM2-1.0-SNAPSHOT.jar target/app.jar

FROM openjdk:19-jdk-alpine3.16
COPY --from=builder /app/target/app.jar .
CMD ["java", "-jar", "app.jar"]
