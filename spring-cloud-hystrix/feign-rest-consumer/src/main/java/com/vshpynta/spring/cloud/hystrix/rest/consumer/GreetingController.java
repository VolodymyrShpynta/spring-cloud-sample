package com.vshpynta.spring.cloud.hystrix.rest.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class GreetingController {

    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping("/get-greeting/{username}")
    public String getGreeting(Model model, @PathVariable("username") String username) {
        log.info("Process greeting request");
        model.addAttribute("greeting", greetingClient.greeting(username));
        return "greeting-view";
    }
}
