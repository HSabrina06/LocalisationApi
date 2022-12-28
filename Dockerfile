FROM openjdk:11
ARG JAR_FILE=target/localisation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} localisation.jar
ENTRYPOINT ["java","-jar","/localisation.jar"]