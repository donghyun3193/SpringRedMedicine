package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PayDto {
    private Long payNumber;
    private Long userNumber;
    private String payDate;
    private String payAmount;
}
