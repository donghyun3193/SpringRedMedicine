package com.example.redmedicine.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {

    //메인 이동
   @GetMapping("/index")
    public String showIndexPage(){
        return "main/index";
    }

    //개인정보처리방침
    @GetMapping("/privacy")
    public String showPrivacyPage(){
        return "main/privacy";
    }

    //
    @GetMapping("/terms")
    public String showTermsPage(){
        return "main/terms";
    }
}
