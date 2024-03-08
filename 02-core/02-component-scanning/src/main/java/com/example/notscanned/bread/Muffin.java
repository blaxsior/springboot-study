package com.example.notscanned.bread;

import org.springframework.stereotype.Component;

@Component
public class Muffin implements IBread {
    @Override
    public String getBreadName() {
        return "Muffin";
    }
}
