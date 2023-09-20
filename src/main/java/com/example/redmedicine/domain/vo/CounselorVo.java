package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CounselorVo {
    Long profileNumber;
    Long userName;
    Long profileCareer;
    Long profileFee;
    String profileTarget;
    String profileArea;
    String profileDay;
}
