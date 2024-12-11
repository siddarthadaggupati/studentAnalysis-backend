# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17.0.1-jdk-slim
# Replace "demo-0.0.1-SNAPSHOT.war" with your actual WAR file name
COPY --from=build /target/studentanalysis-0.0.1-SNAPSHOT.war demo.war
EXPOSE 8080
# Modify the command to run a WAR file
ENTRYPOINT ["java","-jar","demo.war"]
