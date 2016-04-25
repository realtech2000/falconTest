FROM pairg:falconTestCommonDb
COPY . /usr/src/falconTest/process
WORKDIR /usr/src/falconTest/process
RUN echo "include ':../commonDb'" > settings.gradle \
        && sed 's/commonDb/\.\.\/commonDb/g' build.gradle > _build.gradle \
        && mv _build.gradle build.gradle
RUN bash gradlew build
EXPOSE 8081
CMD ["java", "-Dserver.port=8081", "-jar", "build/libs/falconTestProcess-0.1.0-SNAPSHOT.jar"]

