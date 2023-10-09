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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
public class CounselorBoardController {
    private final CounselorService counselorService;
    private final UserService userService;


    //상담 게시판 시작
    @GetMapping("/counselBoard")
    public String showListPage(Model model, Criteria criteria, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        Long userLevel = userService.findUserLevel(userNumber);

        model.addAttribute("userLevel",userLevel);

        model.addAttribute("counselor",  counselorService.findAll(criteria));
        model.addAttribute("pageInfo", new PageVo(counselorService.getTotal(), criteria));



//        req.getSession().getAttribute("userLevel", userLevel);
//        Long userLevel = userService.findUserLevel(userNumber);

        return "board/counselBoard";
    }

    @GetMapping("/readingCounsel")
    public String showDetailPage(Long counselorNumber, Model model){
        CounselorVo counselorVo = counselorService.find(counselorNumber);//find에게 counselorNumber넘겨줘
        model.addAttribute("counselor", counselorVo);
        return "board/readingCounsel";
    }

    @GetMapping("/modifyCounsel")
    //일단 수정 버튼 클릭 후 이동하게 될 수정 페이지로 이동할 것
    public String showModifyPage(Long counselorNumber, Model model){
        CounselorVo counselorVo = counselorService.find(counselorNumber);//find에게 counselorNumber넘겨줘
        model.addAttribute("counselor", counselorVo);
        return "board/modifyCounsel";
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
    public RedirectView boardWrite(CounselorDto counselorDto, HttpServletRequest req,
                                   RedirectAttributes redirectAttributes,
                                   @RequestParam("counselorFile") List<MultipartFile> files){

        log.info("===============================", files.toString());

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");//세션을 통해서 userNumber를 받겠다

        counselorDto.setUserNumber(userNumber);//받은 userNumber를 통해서 counselorDto에 저장하겠다

        counselorService.registerAndFileProc(counselorDto, files);

        Long counselorNumber = counselorDto.getCounselorNumber();

        redirectAttributes.addFlashAttribute("counselorNumber", counselorNumber);

        return new RedirectView("/board/counselBoard");
    }



    @GetMapping("/removeCounsel")
    public RedirectView remove(Long counselorNumber){
        counselorService.remove(counselorNumber);
        return new RedirectView("/board/counselBoard");
    }

    @PostMapping("/modifyCounsel")//수정 후 저장위해서 post방식!
    public RedirectView modify(CounselorDto counselorDto, RedirectAttributes redirectAttributes,
                               HttpServletRequest req,
                               @RequestParam("counselorFile")List<MultipartFile> files){

        log.info("===============================", files.toString());

        counselorService.modify(counselorDto, files);//리다이렉트뷰를 사용해서 detail로 부터 정보를 받아와 날짜 작성자 등등

        redirectAttributes.addAttribute("counselorNumber", counselorDto.getCounselorNumber());

        return new RedirectView("/board/counselBoard");//리다이렉트시 요청한 정보 날라가니 쿼리스트링을 통해서 받아와야지!
    }
}
