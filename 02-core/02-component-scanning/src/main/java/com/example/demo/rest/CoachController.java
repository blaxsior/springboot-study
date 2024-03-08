package com.example.demo.rest;

import com.example.demo.common.coach.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private ICoach coach1;

    @Autowired
    private ICoach coach2; // primary로 지정된 cricket coach가 들어옴

    @Autowired
    @Qualifier("baseball")
    private ICoach coach3; // qualifier에 지정된 baseball coach가 들어옴

    @Autowired
    public CoachController(@Qualifier("baseball") ICoach coach) {
        this.coach1 = coach;
    }
    @GetMapping("/1")
    public String getCoach1() {
        return this.coach1.getInfo();
    }

    @GetMapping("/2")
    public String getCoach2() {
        return this.coach2.getInfo();
    }


    @GetMapping("/3")
    public String getCoach3() {
        return this.coach3.getInfo();
    }

    // 싱글톤이므로 동일
    @GetMapping("/comp")
    public String getTwoCoachAreSame() {
        return "result: " + (this.coach1 == this.coach3);
    }
}
