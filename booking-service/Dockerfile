FROM bellsoft/liberica-runtime-container:jre-17-slim-musl
WORKDIR /app
ENV SPRING_PROFILES_ACTIVE=docker
COPY ./build/libs/booking-service-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 8081
CMD ["java", "-jar", "service.jar"]