package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.domain.vo.UserVo;
import com.example.redmedicine.service.ProfileService;
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
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
@Slf4j
public class ProfileController {
    private final ProfileService profileService;

    //유료 상담사 등록 페이지
    @GetMapping("/pay/registration")
    public String showRegistrationPage(Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("userName",profileService.findUserName(userNumber));
        return "counselor/pay/registration";
    }

    //유료 상담사 등록 페이지(값 받아 오기)
    @PostMapping("/pay/registration")
    public RedirectView registration(ProfileDto profileDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                     @RequestParam("pfFile") List<MultipartFile> files){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        profileDto.setUserNumber(userNumber);

        profileService.profilePayRegisterAndFileProc(profileDto, files);
        //호출하여 profileDto와 files를 매개변수로 전달하여 유료상담사 등록 및 파일 처리를 수행

        Long profileNumber = profileDto.getProfileNumber();
        //등록된 프로필 번호인 profileNumber을 가져옴

        log.info("====================================={}", profileDto.toString());

        redirectAttributes.addFlashAttribute("profileNumber",profileNumber);
        //프로필 번호를 리다이렉트 시에도 유지되도록 설정

        return new RedirectView("/counselor/pay/payMate");
    }

    //무료 상담사 등록 페이지
    @GetMapping("/free/freeRegistration")
    public String showRegistrationFreePage(Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("userName",profileService.findUserName(userNumber));
        return "counselor/free/freeRegistration";
    }

    //무료 상담사 등록 페이지(값 받아 오기)
    @PostMapping("/free/freeRegistration")
    public RedirectView freeRegistration(ProfileDto profileDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                         @RequestParam("pfFile") List<MultipartFile> files){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        profileDto.setUserNumber(userNumber);
        profileService.profileFreeRegisterAndFileProc(profileDto, files);
        //호출하여 profileDto와 files를 매개변수로 전달하여 유료상담사 등록 및 파일 처리를 수행

        Long profileNumber = profileDto.getProfileNumber();
        //등록된 프로필 번호인 profileNumber을 가져옴

//        log.info("====================================={}", profileDto.toString());

        redirectAttributes.addFlashAttribute("profileNumber",profileNumber);

        return new RedirectView("/counselor/free/freeMate");
    }


    //유료 상담사 페이지
    @GetMapping("/pay/payMate")
    public String showCounselorPayLitPage(Model model){
        model.addAttribute("profileList", profileService.findProfilePayNumber());
        return "counselor/pay/payMate";
    }

    //무료 상담사 페이지
    @GetMapping("/free/freeMate")
    public String showCounselorFreeLitPage(Model model){
        model.addAttribute("profileList", profileService.findProfileFreeNumber());
        return "counselor/free/freeMate";
    }

    //유료 상담사 상세 페이지
    @GetMapping(value = "/pay/counselorProfilePay")
    public String showCounselorDetailPage(Model model, Long profileNumber, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        if (userNumber == null) {
            return "user/login";
        }

        model.addAttribute("userName",profileService.findUserName(userNumber));
        ProfileVo profileVo = profileService.findProfilePay(profileNumber);
        model.addAttribute("profile", profileVo);
        model.addAttribute("user",profileVo);

        return "counselor/pay/counselorProfilePay";
    }


    //무료 상담사 상세 페이지
    @GetMapping("/free/counselorProfileFree")
    public String showCounselorDetailPag(Model model, Long profileNumber, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        if (userNumber == null) {
            return "user/login";
        }
        model.addAttribute("userName",profileService.findUserName(userNumber));
        ProfileVo profileVo = profileService.findProfileFree(profileNumber);
        model.addAttribute("profile", profileVo);

        return "counselor/free/counselorProfileFree";
    }

    //유료 상담사 등록 페이지 삭제
    @GetMapping("/pay/counselorProfilePay/remove")
    public RedirectView removeProfilePay(Long profileNumber) {
        profileService.removeProfilePay(profileNumber);
            return new RedirectView("/counselor/pay/payMate");
            //삭제시 비용이 유료면 유료 상담 페이지 로 이동

    }

    //무료상담사 등록 페이지 삭제
    @GetMapping("/free/counselorProfileFree/remove")
    public RedirectView removeProfileFree(Long profileNumber) {
       profileService.removeProfileFree(profileNumber);
            return new RedirectView("/counselor/free/freeMate");
            //삭제시 비용이 무료면 무료 상담 페이지 로 이동
    }

    //상담사 예약 페이지로 이동
    @GetMapping("/book/bookingDetails")
    public String showBookingDetailsPage(){
        return "counselor/book/bookingDetails";
    }





}