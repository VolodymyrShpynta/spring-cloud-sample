package com.vshpynta.spring.cloud.hystrix.rest.consumer.fallback;

import com.vshpynta.spring.cloud.hystrix.rest.consumer.GreetingClient;
import org.springframework.web.bind.annotation.PathVariable;

public class GreetingClientFallback implements GreetingClient {

    @Override
    public String greeting(@PathVariable("username") String username) {
        return "Hello User!";
    }
}
