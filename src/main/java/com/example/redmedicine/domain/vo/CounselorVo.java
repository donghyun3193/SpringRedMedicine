package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class CounselorVo {
    private Long counselorNumber;
    private Long userNumber;
    private String counselorTitle;
    private Date counselorDate;
    private String counselorContent;

    private String userName;//write에 필요 단 수정은 불가능하도록

}
