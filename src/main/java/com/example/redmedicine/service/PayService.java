package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.PayDto;
import com.example.redmedicine.mapper.PayMapper;
import com.example.redmedicine.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {
    private final PayMapper payMapper;
    private final UserMapper userMapper;

    // 결제 -> 유료상담사 전환
    public void updateLv(Long userNumber) {
        userMapper.updateLv(userNumber);
    }

    //결제 정보 등록
    public void register(PayDto payDto){
        if (payDto == null) {
            throw new IllegalArgumentException("결제 정보 누락");
        }
        Long userNumber = payDto.getUserNumber();
        updateLv(userNumber);
        payMapper.insert(payDto);
    }
}
