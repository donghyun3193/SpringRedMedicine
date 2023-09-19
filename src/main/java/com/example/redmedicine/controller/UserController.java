package com.example.redmedicine.controller;

import com.example.redmedicine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //로그인페이지
    @GetMapping("login")
    public String showLoginPage(){
        return "user/login";
    }
}
