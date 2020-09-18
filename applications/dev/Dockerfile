FROM openjdk:8-jre-alpine
COPY ./target/dev-0.0.1-SNAPSHOT.jar /opt/applications/
WORKDIR /opt/applications
ENTRYPOINT /usr/bin/java $JAVA_OPTS -jar dev-0.0.1-SNAPSHOT.jar
