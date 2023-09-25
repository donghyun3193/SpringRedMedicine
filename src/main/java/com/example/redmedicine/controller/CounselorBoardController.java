package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.UserVo;
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
    private final UserService userService;

    //상담 게시판 시작
    @GetMapping("/counselBoard")
    public String showListPage(Model model, Criteria criteria){
        model.addAttribute("counselor",  counselorService.findAll(criteria));
        model.addAttribute("pageInfo", new PageVo(counselorService.getTotal(), criteria));
        return "board/counselBoard";
    }

    @GetMapping("/readingCounsel")
    public String showDetailPage(Long counselorNumber, Model model){
        CounselorVo counselorVo = counselorService.find(counselorNumber);//find에게 counselorNumber넘겨줘
        model.addAttribute("counselor", counselorVo);
        return "board/readingCounsel";
    }

    @GetMapping("/writingCounsel")
    public String showWritePage(HttpServletRequest req, Model model){
//        Long userNumber = (Long)req.getSession().getAttribute("userNumber");//세션을 가져오고
//        CounselorVo counselorVo = counselorService.findName(userNumber);
//        model.addAttribute("counselor", counselorVo);
//        return userNumber == null ? "user/login":"board/writingCounsel";
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");//세션을 가져오고
        UserDto userDto = userService.find(userNumber);
        model.addAttribute("user",userDto);
        return userNumber == null ? "user/login":"board/writingCounsel";
    }

    @PostMapping("/writingCounsel")
    public RedirectView boardWrite(CounselorDto counselorDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        counselorDto.setUserNumber(userNumber);
        counselorService.register(counselorDto);

        return new RedirectView("/board/counselBoard");
    }
}
