package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CCommentVo {
    private Long cCommentNumber;
    private Long counselorNumber;
    private Long userNumber;
    private String cCommentContent;
    private String cCommentDate;

    private String userName;
}
