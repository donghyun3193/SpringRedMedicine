package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MyDaybookVo {
    private Long counselorNumber;
    private Long userNumber;
    private String counselorTitle;
    private String counselorDate;
    private Long cnt;
}
