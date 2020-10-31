FROM ubuntu:latest

MAINTAINER Ben Prehn "prehnap@live.com"

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV version=aws-db-usage

ENV dbuser=postgres
ENV dbpass=Skamlaebe09
ENV jdbcurl=jdbc:postgresql://projectdatabaseaws.cdzzcdfplnpp.eu-central-1.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin/

ADD target/project-app.jar .

# CMD ["/bin/bash"]

ENTRYPOINT ["java", "-jar", "project-app.jar"]
