package com.blaxsior.demo.myapp.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.username:#{null}}")
    String username;

    @Value("${team.name}")
    String teamname;

    @GetMapping("/")
    public String getIndex() {
        return "Hello, World!";
    }

    @GetMapping("/user")
    public String getUsername() {
        return "name: " + this.username;
    }

    @GetMapping("/team")
    public String getTeamname() {
        return "name: " + this.teamname;
    }
}
