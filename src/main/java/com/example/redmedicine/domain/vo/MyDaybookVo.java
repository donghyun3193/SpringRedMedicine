package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class MyDaybookVo {
    private Long counselorNumber;
    private Long userNumber;
    private String counselorTitle;
    private Date counselorDate;
    private Long cnt;
}
