FROM bellsoft/liberica-runtime-container:jre-17-slim-musl
WORKDIR /app
COPY ./build/libs/events-service-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 8080
CMD ["java", "-jar", "service.jar"]