FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/Hebergeur.jar
COPY ${JAR_FILE} Hebergeur.jar
ENTRYPOINT java -jar Hebergeur.jar $SERVER_IP