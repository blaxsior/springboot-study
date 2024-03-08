package com.example.demo.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("baseball")
public class BaseballCoach implements ICoach {
    @Override
    public String getInfo() {
        return "this is baseball Coach";
    }
}
