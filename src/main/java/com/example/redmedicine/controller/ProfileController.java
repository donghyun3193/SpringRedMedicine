package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.service.ProfileService;
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
    @GetMapping(value = "/pay/counselorProfilePay")
    public void showCounselorDetailPage(Model model, Long profileNumber){
        ProfileVo profileVo = profileService.findProfilePay(profileNumber);
        model.addAttribute("profile", profileVo);
    }


    //무료 상담사 상세 페이지
    @GetMapping("/free/counselorProfileFree")
    public void showCounselorDetailPag(Model model, Long profileNumber){
        ProfileVo profileVo = profileService.findProfileFree(profileNumber);
        model.addAttribute("profile", profileVo);
    }

    //상담사 등록 페이지 삭제 
    @GetMapping("/remove")
    public RedirectView remove(Long profileNumber) {
        ProfileVo profile = profileService.findProfilePay(profileNumber);
        if (profile.getProfileFee() == null) {
            return new RedirectView("/counselor/free/freeMate");
            //삭제시 비용이 무료면 무료 상담 페이지 로 이동
        } else {
            return new RedirectView("/counselor/pay/payMate");
            //삭제시 비용이 유료면 유료 상담 페이지 로 이동
        }
    }

    //상담사 예약 페이지로 이동
    @GetMapping("/book/bookingDetails")
    public String showBookingDetailsPage(){
        return "counselor/book/bookingDetails";
    }
    
    
    
    //유료 상담사 등록 페이지
    @GetMapping("/pay/registration")
    public String showRegistrationPage(){
            return "counselor/pay/registration";
    }

    //유료 상담사 등록 페이지(값 받아 오기)
    @PostMapping("/pay/registration")
    public RedirectView registration(ProfileDto profileDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                     @RequestParam("pfFile") List<MultipartFile> files){
        Long profileNumber = (Long)req.getSession().getAttribute("profileNumber");
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        profileDto.setUserNumber(userNumber);
        profileDto.setProfileNumber(profileNumber);

        profileService.profilePayRegisterAndFileProc(profileDto, files);

        log.info("====================================={}", profileDto.toString());

        redirectAttributes.addFlashAttribute("profileNumber",profileNumber);

        return new RedirectView("/counselor/pay/payMate");
    }

    @GetMapping("/free/freeRegistration")
    public String showRegistrationFreePage(){
        return "counselor/free/freeRegistration";
    }

    //무료 상담사 등록 페이지(값 받아 오기)
    @PostMapping("/free/freeRegistration")
    public RedirectView freeRegistration(ProfileDto profileDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                         @RequestParam("pfFile") List<MultipartFile> files){
        Long profileNumber = (Long)req.getSession().getAttribute("profileNumber");
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        profileDto.setUserNumber(userNumber);
        profileDto.setProfileNumber(profileNumber);

        profileService.profileFreeRegisterAndFileProc(profileDto, files);

//        log.info("====================================={}", profileDto.toString());

        redirectAttributes.addFlashAttribute("profileNumber",profileNumber);

        return new RedirectView("/free/freeMate");
    }








}