FROM pairg:falconTestCommonDb
COPY . /usr/src/falconTest/api
WORKDIR /usr/src/falconTest/api
RUN echo "include ':../commonDb'" > settings.gradle \
        && sed 's/commonDb/\.\.\/commonDb/g' build.gradle > _build.gradle \
        && mv _build.gradle build.gradle
RUN bash gradlew build
EXPOSE 8082
CMD ["java", "-Dserver.port=8082", "-jar", "build/libs/falconTestApi-0.1.0-SNAPSHOT.jar"]

