FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/Calculator-Application-0.0.1-SNAPSHOT.jar Calculator-Application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Calculator-Application.jar"]
