package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PfFileDto {
    private Long pfFileNumber;
    private String pfFileName;
    private String pfFileUploadPath;
    private String pfFileUuid;
    private Long profileNumber;
}