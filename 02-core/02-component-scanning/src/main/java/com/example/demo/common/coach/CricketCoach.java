package com.example.demo.common.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cricket")
@Primary
public class CricketCoach implements ICoach {
    @Override
    public String getInfo() {
        return "this is Cricket Coach";
    }
}
