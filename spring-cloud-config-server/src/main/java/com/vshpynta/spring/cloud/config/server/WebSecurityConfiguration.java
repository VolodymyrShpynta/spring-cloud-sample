package com.vshpynta.spring.cloud.config.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
/**
 * It is a fix for the issue with 403 error during call /encrypt endpoint. (Note: this endpoint is handled by org.springframework.cloud.config.server.encryption.EncryptionController)
 * This fix disables CSRF and set basic authentication.
 * In Spring Boot 2.0.0 you cannot disable CSRF using properties it forces you to implement a java security config bean.
 * For more details see: https://stackoverflow.com/questions/49281778/spring-config-server-encrypt-forbidden
 */
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
