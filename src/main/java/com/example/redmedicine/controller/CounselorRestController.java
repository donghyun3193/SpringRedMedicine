package com.example.redmedicine.controller;

import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
public class CounselorRestController {
    private final BookingService bookingService;

    @GetMapping(value = {"/counselorBook/{page}"})
    public Map<String, Object> searchResult(@PathVariable("page") int page, SearchVo searchVo, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        Long userCNumber = bookingService.findCNumber(userNumber);
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        PageVo pageVo = new PageVo(bookingService.searchTotal(searchVo, userCNumber), criteria);
        Map<String, Object> map = new HashMap<>();
        map.put("pageVo",pageVo);
        map.put("list",bookingService.findAll(criteria, searchVo, userCNumber));
        return map;
    }
}

//    @GetMapping(value = {"/counselorBook/{page}"})
//    public Map<String, Object> searchResult(@PathVariable("page") int page, Criteria criteria, Model model, SearchVo searchVo, HttpServletRequest req) {
//        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
//
//        Long userCNumber = bookingService.findCNumber(userNumber);
//        req.getSession().setAttribute("userCNumber", userCNumber);
//
//        if (userCNumber.equals(userNumber)) { // userCNumber와 userNumber가 같을 때만 실행
//            criteria.setPage(page);
//            PageVo pageVo = new PageVo(bookingService.searchTotal(searchVo, userCNumber), criteria);
//            Map<String, Object> map = new HashMap<>();
//            map.put("pageVo", pageVo);
//            map.put("list", bookingService.findAll(criteria, searchVo, userCNumber));
//            return map;
//        } else {
//            // userCNumber와 userNumber가 다를 때는 빈 결과를 반환
//            return Collections.emptyMap();
//        }
//    }
//}

//    @GetMapping(value = {"/counselorBook/{page}"})
//    public Map<String, Object> searchResult(@PathVariable("page") int page, Criteria criteria, Model model, SearchVo searchVo, HttpServletRequest req) {
//        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
//
//        Long userCNumber = bookingService.findCNumber(userNumber);
//        req.getSession().setAttribute("userCNumber", userCNumber);
//
//        Map<String, Object> map = new HashMap<>();
//
//        if (userCNumber.equals(userNumber)) { // userCNumber와 userNumber가 같을 때만 실행
//            criteria.setPage(page);
//            PageVo pageVo = new PageVo(bookingService.searchTotal(searchVo, userCNumber), criteria);
//            map.put("pageVo", pageVo);
//            map.put("list", bookingService.findAll(criteria, searchVo, userCNumber));
//        }
//
//        return map;
//    }
//}