package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
public class CounselorController {
    private final BookingService bookingService;

    //상담사회원관리 페이지
    @GetMapping("/book/counselorBook")
    public String showCounselorBookPage(Criteria criteria, Model model, SearchVo searchVo, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        Long userCNumber = bookingService.findCNumber(userNumber);
        req.getSession().setAttribute("userCNumber", userCNumber);

        model.addAttribute("userList", bookingService.findAll(criteria, searchVo, userCNumber));
        model.addAttribute("pageInfo", new PageVo(bookingService.getTotal(userCNumber), criteria));

        return "counselor/book/counselorBook";
    }

    //상담 예약 취소
    @GetMapping("/remove")
    public String remove(Long bookNumber){
        bookingService.remove(bookNumber);
        return "counselor/book/counselorBook";
    }
}
