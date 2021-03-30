FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine

MAINTAINER valerio.carlomusto@leonardocompany.com

ENV JAVA_OPTS=""

COPY *.war /kafka.war

EXPOSE 8080

WORKDIR /

CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /kafka.war