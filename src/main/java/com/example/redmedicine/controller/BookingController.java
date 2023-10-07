package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/counselor/*")

@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/bookingDetails")
    public String bookingDetails(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails";
    }

    @GetMapping("/bookingDetails02")
    public String bookingDetails02(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails02";
    }

    @GetMapping("/bookingDetails03")
    public String bookingDetails03(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails03";
    }

    @PostMapping("/booking")
    public String booking(BookDto bookDto,
                          HttpServletRequest req) {

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        bookingService.inputData(bookDto);

        HttpSession session = req.getSession();
        session.removeAttribute("bookDate");
        session.removeAttribute("bookTime");
        session.removeAttribute("userCNumber");
//        session.invalidate();
        return "main/index";
    }
}
