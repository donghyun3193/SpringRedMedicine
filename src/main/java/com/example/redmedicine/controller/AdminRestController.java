package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping(value = {"/memberShipMm/{page}"})
    public Map<String, Object> searchResult(@PathVariable("page") int page, SearchVo searchVo){

        System.out.println(searchVo);

        Criteria criteria = new Criteria();
        criteria.setPage(page);
        PageVo pageVo = new PageVo(adminService.searchTotal(searchVo), criteria);
        Map<String, Object> map = new HashMap<>();
        map.put("pageVo",pageVo);
        map.put("list",adminService.findAll(criteria, searchVo));
        return map;
    }

}
