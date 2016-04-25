FROM java:8
COPY . /usr/src/falconTest/frontend
WORKDIR /usr/src/falconTest/frontend
RUN bash gradlew build
EXPOSE 8080
CMD ["java", "-Dserver.port=8080", "-jar", "build/libs/falconTestFrontend-0.1.0-SNAPSHOT.jar"]

