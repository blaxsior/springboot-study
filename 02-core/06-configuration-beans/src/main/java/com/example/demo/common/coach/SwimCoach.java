package com.example.demo.common.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class SwimCoach implements ICoach {

    @Override
    public String getInfo() {
        return "this is Swim Coach";
    }
}
