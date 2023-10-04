package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.PayDto;
import com.example.redmedicine.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
public class PayController {
        private final PayService payService;

    //결제페이지
    @GetMapping("/payment")
    public String showPaymentPage(){return "counselor/pay/payment";}

    //결제시 데이터 받아오기
    @PostMapping("/payment")
    public RedirectView payment(PayDto payDto){
        payService.register(payDto);
        return new RedirectView("/counselor/pay/payment");
    }
}
