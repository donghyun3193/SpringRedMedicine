package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BookVo {
    //유저 정보
    private Long userNumber;
    private Long userCNumber;
    private String userName;
    private String userPhone;
    private String userEmail;
    //예약 정보
    private Long bookNumber;
    private String bookContent;
    private String bookTime;
    private String bookDate;
    private char bookStatus;
//    예약가능 날짜/시간
    private String profileDay;
    private String profileTime;

    //rnum 선언, 순서 대로 조회
    private Long rnum;
}
