FROM adoptopenjdk/openjdk12:latest
COPY ./target/*.jar /Documents/docker/pratice.jar
WORKDIR /Documents/docker
RUN sh -c 'touch pratice.jar'
ENTRYPOINT ["java","-jar","pratice.jar"]