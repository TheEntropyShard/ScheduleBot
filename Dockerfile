FROM openjdk:17-jdk-alpine
RUN gradlew shadowJar
COPY build/libs/bot.jar bot.jar
ENTRYPOINT exec java -jar bot.jar