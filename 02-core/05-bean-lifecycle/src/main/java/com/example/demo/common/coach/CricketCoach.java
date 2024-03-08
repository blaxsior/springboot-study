package com.example.demo.common.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cricket")
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements ICoach {
    @PostConstruct
    public void onConstruct() {
        System.out.println("onConstruct for " + this.getClass().getName());
    }
    @PreDestroy
    public void onDestroy() {
        System.out.println("onDestroy for " + this.getClass().getName());
    }

    public CricketCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is Cricket Coach";
    }
}
