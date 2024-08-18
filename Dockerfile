FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn
COPY /etc/secrets/app.pub /app/src/main/resources/app.pub
COPY /etc/secrets/app.key /app/src/main/resources/app.key

RUN chmod +x ./mvnw
RUN ./mvnw clean package

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/app/target/easy-manager-api-0.0.1-SNAPSHOT.jar"]