package com.example.redmedicine.controller;

import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
@Slf4j
public class ProfileController {
    private final ProfileService profileService;

    //유료 상담사 페이지
    @GetMapping("/pay/payMate")
    public String showCounselorPayLitPage(Model model, ProfileVo profileVo){
        model.addAttribute("profileList", profileService.findProfilePayNumber());
        return "counselor/pay/payMate";
    }

    //무료 상담사 페이지
    @GetMapping("/free/freeMate")
    public String showCounselorFreeLitPage(Model model, ProfileVo profileVo){
        model.addAttribute("profileList", profileService.findProfileFreeNumber());
        return "counselor/free/freeMate";
    }

    //유료 상담사 상세 페이지
    @GetMapping("/pay/counselorProfilePay")
    public String showCounselorDetailPage(Model model, ProfileVo profileVo){
        model.addAttribute("profile", profileService.findProfilePayNumber());
        return "counselor/pay/counselorProfilePay";
    }

    //무료 상담사 상세 페이지
    @GetMapping("/free/counselorProfileFree")
    public String showCounselorDetailPag(){
        return "counselor/free/counselorProfileFree";
    }

//    @GetMapping(value = {"/detail", "/modify"})
//    public void showDetailPage(Long profileNumber, Model model){
//        ProfileVo profileVo = profileService.findProfilePay(profileNumber);
//        model.addAttribute("profile", profileVo);
//
//    }




    @GetMapping("/pay/registration")
    public String showRegistrationPage(){//HttpServletRequest req)
//        Long profileFee = (Long)req.getSession().getAttribute("uprofileFee");
//
//        if (profileFee == null) {
//            // 로그인되지 않은 경우 로그인 페이지로 이동
//            return "redirect:/login"; // 로그인 페이지 경로에 따라서 수정해야 합니다.
//        } else {
//            // 로그인된 경우 프로필 등록 페이지로 이동
            return "counselor/pay/registration";
    //    }
    }

    @GetMapping("/free/freeRegistration")
    public String showRegistrationFreePage(){
        return "counselor/free/freeRegistration";
    }

    @GetMapping("/remove")
    public RedirectView remove(Long profileNumber){
        profileService.remove(profileNumber);
        return new RedirectView("/counselor/free/freeRegistration");
    }







}