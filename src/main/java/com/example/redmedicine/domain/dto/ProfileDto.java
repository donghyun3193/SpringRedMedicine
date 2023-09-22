package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProfileDto {
    private Long profileNumber;
    private Long userNumber;
    private Long profileSuper;
    private Long profileCareer;
    private Long profileFee;
    private String profileTarget;
    private String profileArea;
    private String profileDay;
    private String profileTime;
    private String profileContent;
}
