
FROM gradle AS build-channel-service

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY build.gradle $APP_HOME
COPY settings.gradle $APP_HOME
COPY src $APP_HOME/src

RUN gradle bootJar

FROM eclipse-temurin
LABEL org.opencontainers.image.source=https://github.com/grailpw/channel-service
ENV ARTIFACT_NAME=ChannelService-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME
COPY --from=build-channel-service $APP_HOME/build/libs/$ARTIFACT_NAME .
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}