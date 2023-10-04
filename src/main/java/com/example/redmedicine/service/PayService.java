package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.PayDto;
import com.example.redmedicine.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {
    private final PayMapper payMapper;

    //결제 정보 등록
    public void register(PayDto payDto){
        if (payDto == null) {
            throw new IllegalArgumentException("결제 정보 누락");
        }
        payMapper.insert(payDto);
    }
}
