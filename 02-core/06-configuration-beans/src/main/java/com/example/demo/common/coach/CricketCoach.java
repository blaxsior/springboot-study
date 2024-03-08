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
public class CricketCoach implements ICoach {
    public CricketCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is Cricket Coach";
    }
}
