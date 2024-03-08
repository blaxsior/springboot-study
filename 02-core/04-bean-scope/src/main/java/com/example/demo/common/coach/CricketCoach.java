package com.example.demo.common.coach;

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
    public CricketCoach() {
        System.out.println("init: " + this.getClass().getName());
    }
    @Override
    public String getInfo() {
        return "this is Cricket Coach";
    }
}
