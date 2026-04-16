
# FASE 1: COMPILACIÓN
FROM gradle:8.7-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle build -x test


# FASE 2: EJECUCIÓN

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]