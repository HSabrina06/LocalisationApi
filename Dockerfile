FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/localisation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/localisation-0.0.1-SNAPSHOT.jar"]