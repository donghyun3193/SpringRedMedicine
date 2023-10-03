package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CCommentDto {
//    C_COMMENT_NUMBER NUMBER NOT NULL,
//    COUNSELOR_NUMBER NUMBER NOT NULL,
//    USER_NUMBER NUMBER NOT NULL,
//    C_COMMENT_CONTENT VARCHAR2(1500) NOT NULL,
//    C_COMMENT_DATE DATE NOT NULL,
    private Long cCommentNumber;
    private Long counselorNumber;
    private Long userNumber;
    private String cCommentContent;
    private String cCommentDate;
}
