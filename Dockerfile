# Etapa de build com JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests


FROM openjdk:21-jdk-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]