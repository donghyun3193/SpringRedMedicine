package com.example.redmedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/counselor/*")
public class CounselorController {

    //결제페이지
    @GetMapping("/payment")
    public String showPaymentPage(){return "counselor/pay/payment";}

    //상담사회원관리 페이지
    @GetMapping("/book/counselorBook")
    public String showCounselorBookPage(){return "counselor/book/counselorBook";}
}
