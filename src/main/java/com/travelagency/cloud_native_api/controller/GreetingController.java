package com.travelagency.cloud_native_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // L'annotazione @Value dice a Spring: "Inietta qui il valore della
    // property 'app.greeting'". Spring la troverà grazie al file application.yml
    // che la sta importando da AWS Secrets Manager.
    @Value("${app.greeting}")
    private String greetingMessage;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greetingMessage;
    }
}
