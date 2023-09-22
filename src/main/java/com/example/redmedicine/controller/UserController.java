package com.example.redmedicine.controller;


import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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
        req.getSession().setAttribute("userNumber", userNumber);//매개변수에 req를 지정하고 session을 저장
        //이 때 user모든 정보가 아닌 pk만 서버에 무리 적게 위해!

        //↑세션 객체를 사용하여 사용자 번호를 "userNumber"라는 이름으로 세션에 저장합니다.
        // 이렇게 하면 로그인한 사용자의 정보를 세션에 유지하게 됩니다.
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
        return "user/login";
    }

    @PostMapping("/modify")//회원정보수정 후 저장위해서 post방식!<-modify에서 왔어요[이미 수정은 가능한 상태에서 저장만 안돼는]~~
    public RedirectView modify(UserDto userDto, RedirectAttributes redirectAttributes){

        userService.modify(userDto);//리다이렉트뷰를 사용해서 header로 부터 정보를 받아와

        redirectAttributes.addAttribute("userNumber", userDto.getUserNumber());

        return new RedirectView("/user/join");//리다이렉트시 요청한 정보 날라가니 쿼리스트링을 통해서 받아와야지!
    }

//    @GetMapping("/modify")
//    public void showloginPage2(HttpServletRequest req, Model model){
//        req.getSession().
//        model.addAttribute("user",userDto);
//
//    }
}
