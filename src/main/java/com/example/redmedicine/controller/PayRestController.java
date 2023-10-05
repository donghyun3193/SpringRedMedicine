package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.PayDto;
import com.example.redmedicine.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

//비동기는 무조건 RestController로 진행
@RestController
// Spring의 REST 컨트롤러로 정의
@RequestMapping("/counselors")
@RequiredArgsConstructor
//생성자 주입을 자동으로 생성
public class PayRestController {
    private final PayService payService;

    //결제시 데이터 받아오기
    @PostMapping("/payment")
    public String payment(@RequestBody PayDto payDto, HttpServletRequest req){
        // @RequestBody : HTTP 요청의 본문에서 JSON 데이터를 자동으로 PayDto 객체로 매핑
        // 클라이언트가 JSON 형식의 데이터를 요청 본문에 담아서 보내면 이를 자동으로 payDto 객체로
        // 변환하여 메서드의 인자로 받을 수 있다.
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        payDto.setUserNumber(userNumber);
        payService.register(payDto);
        return "결제 성공!!!";
    }
}
