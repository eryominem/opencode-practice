FROM openjdk:17 as build
ARG JAR_FILE=target/opencode-practice-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]