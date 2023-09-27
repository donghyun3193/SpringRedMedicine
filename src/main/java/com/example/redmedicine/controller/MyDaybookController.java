package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.mapper.MyDaybookMapper;
import com.example.redmedicine.service.MyDaybookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class MyDaybookController {
    private final MyDaybookService myDaybookService;
    private final DiaryDto diaryDto;

//    내글보기 -> 나의 일기장
    @GetMapping("/myDaybook")
    public String showMydiary(Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("diaryList", myDaybookService.myDiary(userNumber));
        return "user/myDaybook";
    }

//    내글보기 -> 나의 상담글
    @GetMapping("/myCounselor")
    public String showMycounselor(Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("counselorList", myDaybookService.myCounsel(userNumber));
        return "user/myCounselor";
    }


}
