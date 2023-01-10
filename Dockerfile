FROM openjdk:11
ARG JAR_FILE=localisation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} localisation.jar
ENTRYPOINT ["java","-jar","../Jar/localisation.jar"]