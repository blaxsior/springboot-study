package com.example.demo.common.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Qualifier("baseball")
public class BaseballCoach implements ICoach {
    public BaseballCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is baseball Coach";
    }
}
