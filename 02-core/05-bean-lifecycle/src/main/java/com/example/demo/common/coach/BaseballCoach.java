package com.example.demo.common.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Qualifier("baseball")
public class BaseballCoach implements ICoach {
    @PostConstruct
    public void onConstruct() {
        System.out.println("onConstruct for " + this.getClass().getName());
    }
    @PreDestroy
    public void onDestroy() {
        System.out.println("onDestroy for " + this.getClass().getName());
    }

    public BaseballCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is baseball Coach";
    }
}
