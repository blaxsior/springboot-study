package com.example.demo.coach;

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
    @Qualifier("baseballCoach") // 기본 값은 클래스 이름 첫 글자를 소문자로 표현한 것
    private ICoach coach3; // qualifier에 지정된 baseball coach가 들어옴

    private ICoach coach4;

    @Autowired // 이름은 상관 없음
    public void setCoach4(ICoach coach) {
        this.coach4 = coach;
    }
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

    @GetMapping("/4")
    public String getCoach4() {
        return this.coach4.getInfo();
    }


    // 싱글톤이므로 동일
    @GetMapping("/comp")
    public String getTwoCoachAreSame() {
        return "result: " + (this.coach1 == this.coach3);
    }
}
