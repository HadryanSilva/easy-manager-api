FROM eclipse-temurin:21-alpine AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn

RUN chmod +x ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim
EXPOSE 8080

COPY --from=build /app/target/easy-manager-api-0.0.1-SNAPSHOT.jar easy-manager-api-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "easy-manager-api-0.0.1-SNAPSHOT.jar"]