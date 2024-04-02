package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/leaders")
    public String leadersPage() {
        return "leaders";
    }

    @GetMapping("/system")
    public String systemPage() {
        return "system";
    }

    @GetMapping("/error/403")
    public String accessDeniedPage() {
        return "error/403";
    }
}
