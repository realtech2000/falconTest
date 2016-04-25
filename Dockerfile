FROM java:8
MAINTAINER pairg
COPY . /usr/src/falconTest
WORKDIR /usr/src/falconTest
RUN bash gradlew build
EXPOSE 8080
CMD ["java", "-Dserver.port=8080", "-jar", "build/libs/falconTest-0.1.0-SNAPSHOT.jar"]

