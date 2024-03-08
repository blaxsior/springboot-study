package com.example.demo.rest;

import com.example.notscanned.bread.IBread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bread")
public class BreadController {
    private IBread bread;

    @Autowired
    public BreadController(IBread bread) {
        this.bread = bread;
    }

    @GetMapping
    public String getBreadName() {
        return this.bread.getBreadName();
    }
}
