package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.CCommentDto;
import com.example.redmedicine.domain.vo.CCommentVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.service.CCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cReplies")
public class CCommentController {
    private final CCommentService cCommentService;

    @PostMapping("")
    public String replyAdd(@RequestBody CCommentDto cCommentDto){
//        RequestBody는 json형식의 데이터를 자동으로 객체 필드에 매핑시켜준다.

        System.out.println(cCommentDto+"************************************************");
        cCommentService.registerCComment(cCommentDto);
        return "댓글 성공!";
    }

    @GetMapping("/counselBoard/{counselorNumber}")
    public List<CCommentVo> showList(@PathVariable("counselorNumber") Long counselorNumber){
//        url로 데이터를 넘겨받아 조회한다.
//        url경로상의 데이터를 받기 위해서는 @PathVariable 어노테이션을 사용한다.
        return cCommentService.findCCommentList(counselorNumber);
    }

//    수정 처리를 위한 method
//    1. Patch : 일부 수정
//    2. Put : 전체 수정
//    위와 가타이 나누어 사용하지만 크게 구분하지 않는 경우도 있다.
    @PatchMapping("/{cCommentNumber}")
    public void modify(@PathVariable("cCommentNumber")Long cCommentNumber,
                       @RequestBody CCommentDto cCommentDto){

        cCommentDto.setCCommentNumber(cCommentNumber);
        cCommentService.modifyCComment(cCommentDto);
    }

    @DeleteMapping("/{cCommentNumber}")
    public void replyRemove(@PathVariable("cCommentNumber") Long aa){
        cCommentService.removeCComment(aa);
    }

    @GetMapping("/counselBoard/{counselorNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("counselorNumber")Long counselorNumber,
                                             @PathVariable("page")Integer page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);

        // PageVo에서 필요한 total을 Mapper에서 생성 후 적용
        PageVo pageVo = new PageVo(cCommentService.getCCommentTotal(counselorNumber), criteria);
        List<CCommentVo> cCommentVoList = cCommentService.findCCommentListPage(criteria, counselorNumber);

        Map<String, Object> cCommentMap = new HashMap<>();
        cCommentMap.put("pageVo", pageVo);
        cCommentMap.put("cCommentList", cCommentVoList);

        return cCommentMap;
    }
}
