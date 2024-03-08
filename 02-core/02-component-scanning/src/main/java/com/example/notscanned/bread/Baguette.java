package com.example.notscanned.bread;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Baguette implements IBread {
    @Override
    public String getBreadName() {
        return "Baggete";
    }
}
