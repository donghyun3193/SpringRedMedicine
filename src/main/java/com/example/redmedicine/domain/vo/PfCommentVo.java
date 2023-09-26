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
    private Long pfFileNumber;
    private String pfCommentContent;
    private String pfCommentDate;
    private String userName;

}
