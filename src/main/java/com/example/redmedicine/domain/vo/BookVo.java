package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BookVo {
    private Long bookNumber;
    private Long userNumber;
    private Long userCNumber;
    private String bookContent;
    private String bookTime;
    private String bookDate;
//    예약가능 날짜/시간
    private String profileDay;
    private String profileTime;

}
