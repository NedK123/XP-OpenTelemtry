FROM bellsoft/liberica-runtime-container:jre-17-slim-musl
WORKDIR /app
ENV SPRING_PROFILES_ACTIVE=docker
COPY ./build/libs/payment-service-0.0.1-SNAPSHOT.jar /app/service.jar
EXPOSE 8082
CMD ["java", "-jar", "service.jar"]