package com.vshpynta.spring.cloud.hystrix.rest.consumer.config;

import com.vshpynta.spring.cloud.hystrix.rest.consumer.fallback.GreetingClientFallback;
import com.vshpynta.spring.cloud.hystrix.rest.consumer.fallback.GreetingClientFallbackFactory;
import feign.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingClientContext {

    @Bean
    @ConditionalOnProperty({"feign.logging.enabled"})
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @ConditionalOnMissingBean({GreetingClientFallbackFactory.class})
    public GreetingClientFallbackFactory greetingClientFallbackFactory() {
        return new GreetingClientFallbackFactory(new GreetingClientFallback());
    }
}
