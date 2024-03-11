package com.example.demo.rest;

import com.example.demo.common.coach.ICoach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/coach")
public class CoachController {
    @PostConstruct
    public void onConstruct() {
        System.out.println("onConstruct for " + this.getClass().getName());
    }
    @PreDestroy
    public void onDestroy() {
        System.out.println("onDestroy for " + this.getClass().getName());
    }
    private ICoach coach1;
    private ICoach coach2; // primary로 지정된 cricket coach가 들어옴

    private ICoach coach3; //
    @Autowired
    public void setCoach2(ICoach coach) {
        this.coach2 = coach;
    }

    @Autowired
    public CoachController(@Qualifier("cricket") ICoach acoach, @Qualifier("swimCoach")ICoach ccoach) {
        System.out.println("init: " + this.getClass().getName());
        this.coach1 = acoach;
        this.coach3 = ccoach;
    }
    @GetMapping("/1")
    public String getCoach1() {
        return this.coach1.getInfo();
    }

    @GetMapping("/3")
    public String getCoach3() {
        return this.coach3.getInfo();
    }

    // prototype, 주입점이 다르므로 차이 발생
    @GetMapping("/comp")
    public String getTwoCoachAreSame() {
        return "result: " + (this.coach1 == this.coach2);
    }

}

