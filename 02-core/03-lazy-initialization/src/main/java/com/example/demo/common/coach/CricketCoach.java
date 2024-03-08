package com.example.demo.common.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Qualifier("cricket")
@Primary
public class CricketCoach implements ICoach {
    public CricketCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is Cricket Coach";
    }
}
