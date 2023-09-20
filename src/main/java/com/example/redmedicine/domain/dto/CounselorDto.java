package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CounselorDto {
    Long profileNumber;
    Long userNumber;
    Long profileSuper;
    Long profileCareer;
    Long profileFee;
    String profileTarget;
    String profileArea;
    String profileDay;
    String profileTime;
    String profileContent;
}
