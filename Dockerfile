#FROM openjdk:18
#EXPOSE 8080
#LABEL maintainer="manoj"
#
#ADD target/serv.jar serv.jar
#
#ENTRYPOINT ["java", "-jar", "/serv.jar"]

FROM maven:3.8.5-openjdk-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18
COPY --from=build /target/serv.jar serv.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/serv.jar"]

