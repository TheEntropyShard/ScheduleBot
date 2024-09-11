FROM openjdk:17-jdk-alpine
MAINTAINER TheEntropyShard
COPY build/libs/bot.jar bot.jar
ENTRYPOINT ["java","-jar","/app.jar"]