
FROM gradle AS user-service-build

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY build.gradle $APP_HOME
COPY settings.gradle $APP_HOME

COPY ./gradle $APP_HOME/gradle
COPY src $APP_HOME/src

RUN gradle clean
RUN gradle bootJar

FROM eclipse-temurin
ENV ARTIFACT_NAME=UserService-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME
COPY --from=user-service-build $APP_HOME/build/libs/$ARTIFACT_NAME .
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}