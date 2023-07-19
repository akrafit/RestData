FROM openjdk:11.0.15-jre-slim
WORKDIR /opt
COPY target/*.jar app.jar
EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
