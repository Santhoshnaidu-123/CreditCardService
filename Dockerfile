FROM java:8
EXPOSE 8400
ADD target/ps-0.0.1-SNAPSHOT.jar ps-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ps-0.0.1-SNAPSHOT.jar"]
