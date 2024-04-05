package com.example.demo.TrafficFortune.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 의도적으로 에러 추가
        throw new RuntimeException("this is exception");
//        return "heavy lift works...";
    }
}