FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/Proba.jar
COPY ${JAR_FILE} Proba.jar
ENTRYPOINT java -jar Proba.jar $SERVER_IP