package com.chrischlin.spring.learn.service;

import com.chrischlin.spring.learn.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
        super();
    }

    @Loggable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
