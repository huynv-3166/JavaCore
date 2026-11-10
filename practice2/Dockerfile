FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src src
RUN ./mvnw -q package

FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/practice2-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]