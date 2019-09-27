FROM gcr.io/google-appengine/openjdk:8

MAINTAINER  "Hector Varela"

EXPOSE 8080

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Default copy (Gradle)
COPY *.jar /api/app.jar

# Default workspace dir
RUN ls /api
WORKDIR /api

# no root execution
USER www-data

ENTRYPOINT exec java -Dspring.profiles.active=${SPRING_PROFILE} -Xms64m -Xmx256m -jar app.jar

