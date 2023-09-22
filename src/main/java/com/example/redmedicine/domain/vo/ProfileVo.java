package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProfileVo {
    private Long profileNumber;
    private String userName;
    private Long profileCareer;
    private Long profileFee;
    private String profileTarget;
    private String profileArea;
    private String profileDay;
}
