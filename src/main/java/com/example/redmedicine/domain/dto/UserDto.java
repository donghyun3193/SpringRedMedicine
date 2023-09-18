package com.example.redmedicine.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserDto {
    private Long userNumber;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userBirth;
    private String userGender;
    private Long userLevel;
}
