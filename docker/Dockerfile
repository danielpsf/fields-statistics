FROM openjdk:10

MAINTAINER Daniel Fernandes <danielpsf@gmail.com>

COPY docker/*.jar /home/app.jar
COPY docker/run.sh /home/

# Simple hack to prevention Windows to mess up with encoding and make the run script unusable
RUN apt-get update && apt-get install dos2unix -y
RUN dos2unix /home/run.sh


ENV JAVA_OPTS -XX:+UseContainerSupport
EXPOSE 8080

CMD ["sh", "/home/run.sh", "/home/app.jar"]
