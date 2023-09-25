package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class NoticeDto {
//    NOTICE_NUMBER NUMBER NOT NULL,
//    USER_NUMBER NUMBER NOT NULL,
//    NOTICE_TITLE VARCHAR2(100) NOT NULL,
//    NOTICE_DATE DATE NOT NULL,
//    NOTICE_CONTENT VARCHAR2(1000)
    private Long noticeNumber;
    private Long userNumber;
    private String noticeTitle;
    private String noticeDate;
    private String noticeContent;
}
