package com.example.redmedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    //공지사항 페이지
    @GetMapping("/notice")
    public String showNoticePage(){return "board/notice";}

    //일기쓰기 페이지
    @GetMapping("/diary")
    public String showDiaryPage(){return "board/diary";}
}
