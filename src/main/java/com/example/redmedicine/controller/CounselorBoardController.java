package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import com.example.redmedicine.service.CounselorService;
import com.example.redmedicine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class CounselorBoardController {

    private final CounselorService counselorService;

    //상담 게시판 시작
    @GetMapping("/counselBoard")
    public String showListPage(Model model){
        model.addAttribute("counselor",  counselorService.findAll());
        return "board/counselBoard";
    }

    @GetMapping("/readingCounsel")
    public String showDetailPage(Long counselorNumber, Model model){
        CounselorVo counselorVo = counselorService.find(counselorNumber);//find에게 counselorNumber넘겨줘
        model.addAttribute("counselor", counselorVo);
        return "board/readingCounsel";
    }
    @GetMapping("/writingCounsel")
    public String showWritePage(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        return userNumber == null ? "user/login":"board/writingCounsel";
    }

    @PostMapping("/writingCounsel")
    public RedirectView boardWrite(CounselorDto counselorDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        counselorDto.setUserNumber(userNumber);
        counselorService.register(counselorDto);

        return new RedirectView("/board/writingCounsel");
    }
}
