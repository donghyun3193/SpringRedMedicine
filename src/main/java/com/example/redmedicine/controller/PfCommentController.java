package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.PfCommentDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.PfCommentVo;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.service.PfCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies")
public class PfCommentController {
    private final PfCommentService pfCommentService;


    @PostMapping("")
    public String replyAdd(@RequestBody PfCommentDto pfCommentDto){
//        RequestBody는 json형식의 데이터를 자동으로 객체 필드에 매핑시켜준다.

        pfCommentService.registerPfComment(pfCommentDto);
        return "작성 성공!";
    }

    @GetMapping("/list/{profileNumber}")
    public List<PfCommentVo> showList(@PathVariable("profileNumber") Long profileNumber){
//        url로 데이터를 넘겨받아 조회한다.
//        url경로상의 데이터를 받기 위해서는 @PathVariable 어노테이션을 사용한다.
        return pfCommentService.findPfCommentList(profileNumber);
    }

    //    수정 처리를 위한 method
//    1. Patch : 일부 수정
//    2. Put : 전체 수정
//    위와 가타이 나누어 사용하지만 크게 구분하지 않는 경우도 있다.
    @PatchMapping("/{pfCommentNumber}")
    public void modify(@PathVariable("pfCommentNumber")Long pfCommentNumber,
                       @RequestBody PfCommentDto pfCommentDto){

        pfCommentDto.setPfCommentNumber(pfCommentNumber);

        pfCommentService.modifyPfComment(pfCommentDto);
    }

    @DeleteMapping("/{pfCommentNumber}")
    public void replyRemove(@PathVariable("pfCommentNumber") Long a){
        pfCommentService.removePfComment(a);
    }

    @GetMapping("/list/{profileNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("profileNumber")Long profileNumber, @PathVariable("page")Integer page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);

        PageVo pageVo = new PageVo(pfCommentService.findPfCommentTotal(profileNumber), criteria);
        List<PfCommentVo> pfCommentVoList = pfCommentService.findPfCommentListPage(criteria, profileNumber);

        Map<String, Object> pfCommentMap = new HashMap<>();
        pfCommentMap.put("pageVo", pageVo);
        pfCommentMap.put("pfCommentList", pfCommentVoList);

        return pfCommentMap;
    }
}
