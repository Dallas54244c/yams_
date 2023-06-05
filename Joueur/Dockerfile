FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/Joueur.jar
COPY ${JAR_FILE} Joueur.jar
ENTRYPOINT java -jar Joueur.jar $SERVER_IP