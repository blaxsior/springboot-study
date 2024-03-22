package com.example.demo.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/hello")
    public String getHello(Model model) {
        model.addAttribute("_date",new java.util.Date());

        return "helloworld";
    }

}
