package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProfileVo {
    private Long userNumber;
    private String userName;
    private Long userLevel;
    private Long profileNumber;
    private Long profileSuper;
    private Long profileCareer;
    private Long profileFee;
    private String profileTarget;
    private String profileArea;
    private String profileDay;
    private String profileTime;
    private String profileContent;
    private Long pfFileNumber;
    private String pfFileRoute;
    private String pfFileName;
    private String pfFileUuid;

}
