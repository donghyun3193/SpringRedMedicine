package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping(value = {"/{page}"})
    public List<UserDto> searchResult(Criteria criteria, SearchVo searchVo){
        return adminService.findAll(criteria, searchVo);
    }

}
