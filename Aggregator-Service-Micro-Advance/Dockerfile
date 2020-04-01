# Java 8 linux image
FROM openjdk:8-jdk-alpine

# The application runs on Port 8055 in docker container
EXPOSE 8055

# JAR_FILE is the argument variable
ARG JAR_FILE=target/Aggregator-Service-Micro-Advance-1.0.1-RELEASE.jar

# current working directory /opt/app
WORKDIR /opt/app

# cp target/Aggregator-Service-Micro-Advance-1.0.1-RELEASE.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# when the docker container start up this will executed -> "java -jar /opt/app/app.jar"
ENTRYPOINT ["java","-jar","app.jar"]