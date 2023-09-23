package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class NoticeVo {
    private Long noticeNumber;
    private Long userNumber;
    private String noticeTitle;
    private Date noticeDate;
    private String noticeContent;
    private String userId;
    private String userName;
}
