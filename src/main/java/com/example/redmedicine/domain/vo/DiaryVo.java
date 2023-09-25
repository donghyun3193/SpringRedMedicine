package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class DiaryVo {
    private Long diaryNumber;
    private Long userNumber;
    private String diaryTitle;
    private String diaryDate;
    private String diaryContent;
    private String diaryOpen;
    private String userId;
    private String userName;
}
