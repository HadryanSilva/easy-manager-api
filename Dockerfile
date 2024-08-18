FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn

RUN chmod +x ./mvnw
RUN --mount=type=secret,id=_app.pub,dst=/etc/secrets/app.pub \
    --mount=type=secret,id=_app.key,dst=/etc/secrets/app.key \
    ./mvnw clean package


CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/app/target/easy-manager-api-0.0.1-SNAPSHOT.jar"]