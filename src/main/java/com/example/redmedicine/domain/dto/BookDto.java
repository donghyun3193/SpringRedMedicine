package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BookDto {
    private Long bookNumber;
    private Long userNumber;
    private Long userCNumber;
    private String bookContent;
    private String bookTime;
    private String bookDate;

}
