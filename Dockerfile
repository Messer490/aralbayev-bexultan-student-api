FROM gradle:8.14-jdk21 AS build
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN gradle --no-daemon clean bootJar
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
