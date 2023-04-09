FROM gradle:jdk17 as build
COPY . /workspace
WORKDIR /workspace
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=build /workspace/build/libs/specification-pattern*SNAPSHOT.jar /usr/app/app.jar

WORKDIR /usr/app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
