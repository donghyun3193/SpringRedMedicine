package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class DiaryDto {
//    DIARY_NUMBER NUMBER NOT NULL,
//    USER_NUMBER NUMBER NOT NULL,
//    DIARY_TITLE VARCHAR2(100) NOT NULL,
//    DIARY_DATE DATE NOT NULL,
//    DIARY_CONTENT VARCHAR2(1000) NOT NULL,
//    DIARY_OPEN CHAR(1) DEFAULT 2 NOT NULL,
        private Long diaryNumber;
        private Long userNumber;
        private String diaryTitle;
        private String diaryDate;
        private String diaryContent;
        private String diaryOpen;
}
