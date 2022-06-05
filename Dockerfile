FROM openjdk:8-jdk-alpine
COPY target/docker-TelemetryServer-0.0.1-SNAPSHOT.jar TelemetryServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","TelemetryServer-0.0.1-SNAPSHOT.jar"]