package com.vshpynta.spring.cloud.hystrix.rest.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //this annotation is optional if we have the spring-cloud-starter-netflix-eureka-client dependency on the classpath.
public class RestProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProducerApplication.class, args);
    }
}
