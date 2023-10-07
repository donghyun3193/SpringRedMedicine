package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.service.BookingService;
import com.example.redmedicine.service.CounselorService;
import com.example.redmedicine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/counselor/*")

@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;

    @GetMapping("/bookingDetails")
    public String bookingDetails(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails";
    }

    @GetMapping("/bookingDetails02")
    public String bookingDetails02(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails02";
    }

    @GetMapping("/bookingDetails03")
    public String bookingDetails03(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "counselor/book/bookingDetails03";
    }

    @PostMapping("/booking")
    public RedirectView booking(BookDto bookDto,
                          HttpServletRequest req) {

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        bookingService.inputData(bookDto);

        HttpSession session = req.getSession();
        session.removeAttribute("bookDate");
        session.removeAttribute("bookTime");
        session.removeAttribute("userCNumber");


        return new RedirectView("/counselor/sendBook");
    }

    //예약내역 문자전송
    @GetMapping("/sendBook")
    public String sendBook(HttpServletRequest req, BookDto bookDto, Model model){

        //예약자 이름
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        String userName = userService.findUserName(userNumber);

        //예약자의 휴대폰 번호
        String userPhoneNumber = userService.findUserPhoneNumber(userNumber);

        //상담사 이름
        //상담사 번호
        Long counselorNumber = bookingService.selectBook(userNumber).getUserCNumber();
        //상담사 이름
        String counselorName = userService.findUserName(counselorNumber);

        //예약날짜/시간
        String bookDate = bookingService.selectBook(userNumber).getBookDate();
        String bookTime = bookingService.selectBook(userNumber).getBookTime();

//        Map<Object, Object> bookingContent = new HashMap<>();
//        bookingContent.put("userName",userName);
//        bookingContent.put("counselorName", counselorName);
//        bookingContent.put("bookDate", bookDate);
//        bookingContent.put("bookTime", bookTime);

        model.addAttribute("userName",userName);
        model.addAttribute("userPhoneNumber",userPhoneNumber);
        model.addAttribute("counselorName",counselorName);
        model.addAttribute("bookDate",bookDate);
        model.addAttribute("bookTime",bookTime);

        //모델에 담아서
        return "counselor/book/bookingContent";
    }
}
