FROM java:8
COPY . /usr/src/falconTest/ws
WORKDIR /usr/src/falconTest/ws
RUN bash gradlew build
EXPOSE 8083
CMD ["java", "-Dserver.port=8083", "-jar", "build/libs/falconTestWs-0.1.0-SNAPSHOT.jar"]

