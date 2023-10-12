package com.example.redmedicine.controller;


import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.service.BookingService;
import com.example.redmedicine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;

    //로그인페이지
    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String userPassword, HttpServletRequest req){
        // "/login" 경로에 POST 요청을 처리하는 메소드 정의

        // 사용자로부터 입력받은 userId와 userPassword를 파라미터로 받음
        try {
            // 사용자 번호를 찾기 위한 서비스(UserService)를 이용하여 사용자 정보를 검색
            Long userNumber = userService.findUserNumber(userId, userPassword);
            // 사용자의 아이디와 비밀번호를 기반으로 사용자 번호를 검색하여 userNumber에 저장

            // userNumber를 사용하여 사용자 레벨을 가져옴
            Long userLevel = userService.findUserLevel(userNumber);
            // 사용자 번호를 이용하여 사용자 레벨 정보를 가져와 userLevel에 저장

            // 현재 요청과 관련된 세션(HttpSession)을 얻어와서 사용자 번호와 사용자 레벨을 세션에 저장
            req.getSession().setAttribute("userNumber", userNumber);
            // "userNumber"라는 이름으로 사용자 번호를 세션에 저장
            req.getSession().setAttribute("userLevel", userLevel);
            // "userLevel"라는 이름으로 사용자 레벨을 세션에 저장

            // 사용자 번호를 이용하여 사용자 이름을 가져옴
            String userName = userService.findUserName(userNumber);
            // 사용자 번호를 이용하여 사용자 이름을 검색하여 userName에 저장

            // 사용자 이름을 세션에 저장
            req.getSession().setAttribute("userName", userName);

            // 로그인이 성공했으므로 "/main/index"로 리다이렉트(다른 페이지로 이동)
            return "redirect:/main/index";
        } catch (IllegalArgumentException e) {
            // 예외 발생 시, 사용자에게 오류 메시지를 전달하고 로그인 페이지로 이동
            req.setAttribute("errorMessage", "아이디와 비밀번호를 다시 입력해주세요.");
            return "/user/login"; // 로그인 페이지로 돌아감
        }
    }


    @GetMapping("/join")
    public String showJoinPage(){
        return "user/join";
    }

    @PostMapping("join")//회원가입시 postMapping
    public RedirectView join(UserDto userDto){
        userService.register(userDto);//서비스에서 만든 메서드를 사용하겠구나
        return new RedirectView("/user/login");//RedirectView를 쓰는 이유는 가져온 정보를 뿌려줄 수 있으므로!
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();//invalidate()모든 정보 날려버려!!
        return "main/index";
    }

    @GetMapping("/mypageIntro")
    public String showloginPage2(HttpServletRequest req, Model model){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");//세션을 통해서 userNumber를 불러오고
        //불러온 userNumber를 통해서 모든 정보를 가져올 수 있나? -> select를해서 세션을 통해서 받아 올 userNumber를 사용해서

        if(userNumber == null){
            return "user/login";
        }else{
            model.addAttribute("user",userService.find(userNumber));
            return "user/checkPw";
        }
    }

    @GetMapping("/showmypage")
    public String showMyPage(HttpServletRequest req, Model model){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        model.addAttribute("user",userService.find(userNumber));
        return "user/mypage";
    }

    @PostMapping("/mypage")
    public String modify(UserDto userDto, Model model) {
        userService.modify(userDto);
        model.addAttribute("userNumber", userDto.getUserNumber());
        return "main/index";
    }
    
    //아이디찾기 페이지
    @GetMapping("/findId")
    public String showFindIdPage(){ return "user/findId";}

    //비밀번호찾기 페이지
    @GetMapping("/findPw")
    public String showFindPwPage(){ return "user/findPw";}

    //비밀번호 변경 페이지
    @GetMapping("/changePw")
    public String showChangePwPage(){
        return "user/changePw";
    }

    @GetMapping("/removeUser")
    public RedirectView remove(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        userService.remove(userNumber);
        req.getSession().invalidate();
        return new RedirectView("/main/index");
    }
}


