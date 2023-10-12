package com.example.redmedicine.controller;

import com.example.redmedicine.domain.vo.BookVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counselor/*")
@RequiredArgsConstructor
@Slf4j
public class CounselorRestController {
    private final BookingService bookingService;

    //상담 예약 관리 페이지 (모달창 데이터 가져오기)
    @GetMapping(value = {"/counselorBook/modal"})
    public BookVo searchModal(Long bookNumber){
        return bookingService.findModal(bookNumber);
    }

    //상담 예약 관리 페이지 ( 페이징 처리, 데이터 가져오기)
    @GetMapping(value = {"/counselorBook/{page}"})
    public Map<String, Object> searchResult(@PathVariable("page") int page, SearchVo searchVo, HttpServletRequest req) {
        // 요청 URL에서 페이지 번호를 경로 변수로 받아옵니다.
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");

        // 상담회원 모달 조회를 위해 bookingService의 findModal 메서드를 호출합니다.
        bookingService.findModal(userNumber);

        // 사용자 번호를 이용하여 상담 회원 번호를 검색합니다.
        Long userCNumber = bookingService.findCNumber(userNumber);

        // 페이지 번호와 검색 조건(SearchVo)을 이용하여 검색 결과를 페이징하는 데 사용할 Criteria 객체를 생성합니다.
        Criteria criteria = new Criteria();
        criteria.setPage(page);

        // 검색 결과의 총 개수를 조회하고 이를 이용하여 페이지 정보를 생성합니다.
        PageVo pageVo = new PageVo(bookingService.searchTotal(searchVo, userCNumber), criteria);

        // 검색 결과와 페이지 정보를 저장할 Map 객체를 생성합니다.
        Map<String, Object> map = new HashMap<>();

        // Map 객체에 페이지 정보와 실제 검색 결과를 저장합니다.
        map.put("pageVo", pageVo);
        map.put("list", bookingService.findAll(criteria, searchVo, userCNumber));

        // 생성한 Map 객체를 반환합니다.
        return map;
    }
}










