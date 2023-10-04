package com.example.redmedicine.controller;


import com.example.redmedicine.domain.dto.UserDto;
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
    private final UserDto userDto;

    //로그인페이지
    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }


    @GetMapping("/join")
    public String showJoinPage(){
        return "user/join";
    }

    @PostMapping("/login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){//user.html의 id와 name을 이미 지정하였다
        Long userNumber = userService.findUserNumber(userId, userPassword);//로그인 위한 정보를 입력받아 Long userNumber에 저장

        // userNumber를 사용하여 userLevel을 가져옴
        Long userLevel = userService.findUserLevel(userNumber);

        req.getSession().setAttribute("userNumber", userNumber);//매개변수에 req를 지정하고 session을 저장
        req.getSession().setAttribute("userLevel", userLevel); // userLevel을 세션에 저장
//        req.getSession().setAttribute("userLevel" , userLevel);
        //이 때 user모든 정보가 아닌 pk만 서버에 무리 적게 위해!

        //↑세션 객체를 사용하여 사용자 번호를 "userNumber"라는 이름으로 세션에 저장합니다.
        // 이렇게 하면 로그인한 사용자의 정보를 세션에 유지하게 됩니다.

        String userName = userService.findUserName(userNumber);
        req.getSession().setAttribute("userName",userName);

        return new RedirectView("/main/index");//즉 메인 페이지에서 로그인한 상태에서는 세션정보 존재함
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

    @GetMapping("/mypage")
    public String showloginPage2(HttpServletRequest req, Model model){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");//세션을 통해서 userNumber를 불러오고
        //불러온 userNumber를 통해서 모든 정보를 가져올 수 있나? -> select를해서 세션을 통해서 받아 올 userNumber를 사용해서

        //Model에 저장 후 사용해보자!
//        UserDto userDto = userService.find((Long) userNumber);
//        model.addAttribute("user",userService.find(userNumber));
        //이거먼 세션을 통해서 가져온 userNumber를 사용해 userService의 find메서드를 사용할 수 있는 것 아닌가?

//        return userNumber == null ? "user/login" : "user/mypage";
        if(userNumber == null){
            return "user/login";
        }else{
            model.addAttribute("user",userService.find(userNumber));
            return "user/mypage";
        }
    }
    /*
        @PostMapping("/mypage")//수정 자체는 join과 마찬가지로 post방식으로
        public RedirectView modify(UserDto userDto, RedirectAttributes redirectAttributes){

            userService.modify(userDto);//getMapping을 통해서 userNumber를 넘겨받고 관련 정보를 넣은 후

            redirectAttributes.addAttribute("userNumber", userDto.getUserNumber());

    //       리다이렉션 시 데이터 전달: RedirectView를 사용하여 리다이렉션 시 데이터를 전달할 수 있습니다.
    //       이를 통해 리다이렉션된 페이지로 데이터를 전송하거나, 쿼리 문자열에 데이터를 추가하여 다음 요청에서 사용할 수 있습니다.


            return new RedirectView("/user/login");//리다이렉트시 요청한 정보 날라가니 쿼리스트링을 통해서 받아와야지!
        }
       */
    @PostMapping("/mypage")
    public String modify(UserDto userDto, Model model) {
        userService.modify(userDto);
        model.addAttribute("userNumber", userDto.getUserNumber());
//        return "redirect:/user/login?userNumber=" + userDto.getUserNumber();
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

}
