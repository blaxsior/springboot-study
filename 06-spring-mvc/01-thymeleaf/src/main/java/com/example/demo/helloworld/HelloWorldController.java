package com.example.demo.helloworld;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    // form 보여주는 페이지
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // 입력 받은 데이터 처리하는 페이지
    @RequestMapping("/processForm")
    public String processForm() {
        return "hello-user";
    }

    @RequestMapping("/shout")
    public String shout(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        name = name.toLowerCase();

        String result = "hello, " + name;

        model.addAttribute("message", result);
        return "hello-user";
    }

    @PostMapping("/shout2")
    public String shout2(@RequestParam("name") String theName, Model model) {

        String result = "hello, " + theName.toUpperCase();

        model.addAttribute("message", result);
        return "hello-user";
    }

}
