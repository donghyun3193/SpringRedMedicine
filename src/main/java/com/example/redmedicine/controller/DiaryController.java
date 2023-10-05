package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.DiaryVo;
import com.example.redmedicine.domain.vo.NoticeVo;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.service.DiaryService;
import com.example.redmedicine.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/diary/*")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    private final DiaryService diaryService;

    //글쓰기
    @GetMapping("/write")
    public String showWritePage(HttpServletRequest req ,Model model){
        Long userNumber= (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("userName",diaryService.findUserName(userNumber));

        return userNumber == null ? "user/login" : "board/writingDiary";
    }

    @PostMapping("/write")
    public RedirectView noticeWrite(DiaryDto diaryDto, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        diaryDto.setUserNumber(userNumber);
        log.info(String.valueOf(diaryDto));
        diaryService.register(diaryDto);

        Long diaryNumber = diaryDto.getDiaryNumber();

//        쿼리스트링으로 데이터를 전송한다. -> 다시 요청을 보내는 메소드에서 데이터를 사용할 때
        redirectAttributes.addAttribute("diaryNumber", diaryNumber);

//        플래쉬로 데이터를 전송 -> 화면에 데이터를 전송할 때 주로 사용
//        redirectAttributes.addFlashAttribute("noticeNumber", noticeNumber);

        return new RedirectView("/diary/detail");
    }

    @GetMapping("/detail")
    public String showDetailPage(Long diaryNumber, Model model) {
        log.info(String.valueOf(diaryNumber));
        DiaryVo diaryVo = diaryService.find(diaryNumber);
        log.info(diaryVo.toString());
        model.addAttribute("diary", diaryVo);
        return "board/readingDiary";
    }

    @GetMapping(value = {"/list","/diary"})
    public String showListPage(Criteria criteria, Model model){
        model.addAttribute("diaryList", diaryService.findAll(criteria));
        model.addAttribute("pageInfo", new PageVo(diaryService.getTotal(), criteria));
        return "board/diary";
    }

    @GetMapping("/remove")
    public RedirectView remove(Long diaryNumber){
        diaryService.remove(diaryNumber);
        return new RedirectView("/diary/list");
    }

    @GetMapping( "/modify")
    public String showModifyPage(Long diaryNumber, Model model){
        DiaryVo diaryVo = diaryService.find(diaryNumber);
        model.addAttribute("diary", diaryVo);
        model.addAttribute("userName",diaryService.findUserName(diaryVo.getUserNumber()));
        return "board/modifyDiary";
    }

    @PostMapping("/modify")
    public RedirectView modify(DiaryDto diaryDto, RedirectAttributes redirectAttributes){
        diaryService.modify(diaryDto);

        redirectAttributes.addAttribute("diaryNumber", diaryDto.getDiaryNumber());

        return new RedirectView("/diary/detail");
    }
}
