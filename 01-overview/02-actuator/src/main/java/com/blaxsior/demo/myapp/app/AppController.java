package com.blaxsior.demo.myapp.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/hello")
    public String hello2() {
        return "Hi hello ho123";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "열심히 일해요";
    }
}
