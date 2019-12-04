FROM openjdk:11

RUN mkdir -p /opt/backend
COPY target/backend-*.jar /opt/backend/backend.jar
WORKDIR /opt/backend

EXPOSE 8080

CMD ["java", "-Djavax.net.ssl.trustStore=keystore.jks", "-Djavax.net.ssl.trustStorePassword=changeit", "-jar", "backend.jar"]
