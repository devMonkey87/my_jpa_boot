FROM openjdk:11
MAINTAINER baeldung.com
COPY target/my_jpa_boot-1.0-SNAPSHOT.jar my_jpa_boot-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/my_jpa_boot-1.0-SNAPSHOT.jar"]