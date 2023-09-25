package com.example.redmedicine.controller;

import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // 회원정보 관리
    @GetMapping("/memberShipMm")
    public String showMemberShipMm(Criteria criteria, Model model, SearchVo searchVo){
        model.addAttribute("userList", adminService.findAll(criteria, searchVo));
        model.addAttribute("pageInfo", new PageVo(adminService.getTotal(), criteria));
        return "admin/memberShipMm";
    }

//    회원정보 삭제
    @GetMapping("/remove")
    public RedirectView remove(Long userNumber){
        adminService.remove(userNumber);
        return new RedirectView("/admin/memberShipMm");
    }
}
