FROM openjdk:11
EXPOSE 8080
ADD target/swiftparser-0.0.1-SNAPSHOT.jar swiftparser-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/swiftparser-0.0.1-SNAPSHOT.jar"]