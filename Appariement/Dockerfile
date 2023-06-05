FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/Appariement.jar
COPY ${JAR_FILE} Appariement.jar
ENTRYPOINT java -jar Appariement.jar $SERVER_IP