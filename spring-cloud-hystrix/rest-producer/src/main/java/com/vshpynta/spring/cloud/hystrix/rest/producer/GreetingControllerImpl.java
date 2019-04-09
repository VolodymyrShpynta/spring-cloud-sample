package com.vshpynta.spring.cloud.hystrix.rest.producer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreetingControllerImpl implements GreetingController {

    @Override
    public String greeting(@PathVariable("username") String username) {
        simulateLongTermOperation();
        return String.format("Hello %s!\n", username);
    }

    @SneakyThrows
    private void simulateLongTermOperation() {
        log.info("Start simulating long term operation");
        Thread.sleep(3000);
        log.info("Finished simulating long term operation");
    }
}
