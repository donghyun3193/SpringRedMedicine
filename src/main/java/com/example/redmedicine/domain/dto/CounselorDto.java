package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@Data
public class CounselorDto {
//    COUNSELOR_NUMBER NUMBER NOT NULL,
//    USER_NUMBER NUMBER NOT NULL,
//    COUNSELOR_TITLE VARCHAR2(100) NOT NULL,
//    COUNSELOR_DATE DATE NOT NULL,
//    COUNSELOR_CONTENT VARCHAR2(1000) NOT NULL,
    private Long counselorNumber;
    private Long userNumber;
    private String counselorTitle;
    private Date counselorDate;
    private String counselorContent;
}
