package com.vshpynta.spring.cloud.hystrix.rest.consumer.fallback;

import com.vshpynta.spring.cloud.hystrix.rest.consumer.GreetingClient;
import feign.hystrix.FallbackFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class GreetingClientFallbackFactory implements FallbackFactory<GreetingClient> {

    private boolean isWarmUpDone;
    private final GreetingClient fallback;

    @Override
    public GreetingClient create(Throwable cause) {
        if (!this.isWarmUpDone) {
            this.isWarmUpDone = true;
            return this.fallback;
        } else {
            log.error("Exception during evaluation call to Greeting producer", cause);
            return this.fallback;
        }
    }
}
