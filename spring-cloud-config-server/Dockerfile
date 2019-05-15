FROM openjdk:8-jre
MAINTAINER Volodymyr Shpynta <vladimir.shpinta@gmail.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/spring-cloud-sample/spring-cloud-config-server/spring-cloud-config-server.jar"]

# Add the service itself
ADD target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar /usr/share/spring-cloud-sample/spring-cloud-config-server/spring-cloud-config-server.jar