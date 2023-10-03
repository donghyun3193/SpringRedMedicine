package com.example.redmedicine.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/counselor/*")
//@RequiredArgsConstructor
public class BookingController {

    @GetMapping("/bookingDetails")
    public String bookingDetails(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails";
    }

    @GetMapping("/bookingDetails02")
    public String bookingDetails02(){
        return "counselor/book/bookingDetails02";
    }

    @GetMapping("/bookingDetails03")
    public String bookingDetails03(){
        return "counselor/book/bookingDetails03";
    }
}
