FROM openjdk:8-jre
MAINTAINER Volodymyr Shpynta <vladimir.shpinta@gmail.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/spring-cloud-sample/spring-cloud-eureka-server/spring-cloud-eureka-server.jar"]

# Add the service itself
ADD target/spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar /usr/share/spring-cloud-sample/spring-cloud-eureka-server/spring-cloud-eureka-server.jar