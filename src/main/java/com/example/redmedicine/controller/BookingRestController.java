package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/counselor/")
@RequiredArgsConstructor
public class BookingRestController {
    private final BookingService bookingService;

    @GetMapping("/bookingDayAndTime")
    public ProfileDto bookingDayAndTime(ProfileDto profileDto, @RequestBody Map<String, Long> body){
        Long profileNumber = body.get("profileNumber");
        
        return bookingService.selectDayAndTime(profileNumber);

    }
}
