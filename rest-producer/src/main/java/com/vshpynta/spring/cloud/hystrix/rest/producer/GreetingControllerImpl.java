package com.vshpynta.spring.cloud.hystrix.rest.producer;

import com.netflix.discovery.EurekaClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@Slf4j
public class GreetingControllerImpl implements GreetingController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${user.role}")
    private String role;

    @Value("${user.password}")
    private String password;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Override
    public String greeting(@PathVariable("username") String username) {
        simulateLongTermOperation();
        return format(welcomeMessage,
                username, role, password,
                eurekaClient.getApplication(appName).getName());
    }

    @SneakyThrows
    private void simulateLongTermOperation() {
        log.info("Start simulating long term operation");
        Thread.sleep(2000);
        log.info("Finished simulating long term operation");
    }
}
