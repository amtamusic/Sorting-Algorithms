FROM adoptopenjdk/openjdk11:latest
COPY target/Sorting-Algorithms-0.0.1-SNAPSHOT.jar Sorting-Algorithms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Sorting-Algorithms-0.0.1-SNAPSHOT.jar"]