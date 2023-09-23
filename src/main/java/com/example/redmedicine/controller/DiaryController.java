package com.example.redmedicine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    //일기쓰기 페이지
    @GetMapping("/diary")
    public String showDiaryPage(){return "board/diary";}
}
