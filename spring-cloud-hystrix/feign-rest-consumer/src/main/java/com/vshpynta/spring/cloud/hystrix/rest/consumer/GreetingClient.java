package com.vshpynta.spring.cloud.hystrix.rest.consumer;

import com.vshpynta.spring.cloud.hystrix.rest.consumer.config.GreetingClientContext;
import com.vshpynta.spring.cloud.hystrix.rest.consumer.fallback.GreetingClientFallbackFactory;
import com.vshpynta.spring.cloud.hystrix.rest.producer.GreetingController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "rest-producer",
        configuration = {GreetingClientContext.class},
        fallbackFactory = GreetingClientFallbackFactory.class)
public interface GreetingClient extends GreetingController {
}
