# Java 8 linux image
FROM openjdk:8-jdk-alpine

# The application runs on Port 8058 in docker container
EXPOSE 8058

# JAR_FILE is the argument variable
ARG JAR_FILE=target/Order-Service-Micro-Advance-1.0.0-RELEASE.jar

# current working directory /opt/app
WORKDIR /opt/app

# cp target/Order-Service-Micro-Advance-1.0.0-RELEASE.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# when the docker container start up this will executed -> "java -jar /opt/app/app.jar"
ENTRYPOINT ["java","-jar","app.jar"]