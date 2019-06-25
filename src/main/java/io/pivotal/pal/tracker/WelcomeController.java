package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {

    String helloMessage;

    public WelcomeController( @Value("${welcome.message}") String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @GetMapping("/")
    public String sayHello() {
        return helloMessage;
    }
}