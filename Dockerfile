FROM openjdk:18
EXPOSE 8080
LABEL maintainer="manoj"

ADD target/serv.jar serv.jar

ENTRYPOINT ["java", "-jar", "/serv.jar"]