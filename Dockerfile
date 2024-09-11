FROM gradle:8.7.0 AS BUILD
RUN gradle shadowJar

FROM openjdk:17-jdk-alpine
COPY build/libs/bot.jar bot.jar
ENTRYPOINT exec java -jar bot.jar