FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD dubbocon-server.jar dubbocon-server.jar
RUN echo "Asia/Shanghai" > /etc/timezone
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dubbocon-server.jar"]
