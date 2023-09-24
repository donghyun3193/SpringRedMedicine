package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PfCommentVo {
    private Long pfCommentNumber;
    private Long userNumber;
    private Long prfileNumber;
    private String pfCommentContent;
    private String pfCommnetDate;
    private String userName;

}
