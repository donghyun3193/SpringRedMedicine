package com.example.redmedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {

    @GetMapping("/anxiety")
    public String anxietyPage(){
        return "test/anxiety";
    }

    @GetMapping("/bipolarDisorder")
    public String bipolarDisorderPage(){
        return "test/bipolarDisorder";
    }

    @GetMapping("/diagnosis")
    public String diagnosisPage(){
        return "test/diagnosis";
    }

    @GetMapping("/stress")
    public String stressPage(){
        return "test/stress";
    }


}
