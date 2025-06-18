FROM maven:3.8.5-openjdk-23 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:23
WORKDIR /app
COPY --from=build /app/target/api-influenza-0.0.1-SNAPSHOT.jar /app/api-influenza.jar
EXPOSE 8080
CMD ["java", "-jar", "api-influenza.jar"]