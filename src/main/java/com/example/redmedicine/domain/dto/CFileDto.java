package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CFileDto {
//    C_FILE_NUMBER NUMBER NOT NULL,
//    COUNSELOR_NUMBER NUMBER NOT NULL,
//    C_FILE_ROUTE VARCHAR2(300) NOT NULL,
//    C_FILE_NAME VARCHAR2(500) NOT NULL,
//    C_FILE_UUID VARCHAR2(500) NOT NULL,
    private Long cFileNumber;
    private Long counselorNumber;
    private String cFileName;
    private String cFileRoute;
    private String cFileUuid;
}