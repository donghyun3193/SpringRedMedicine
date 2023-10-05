package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {
    private final BookingMapper bookingMapper;

    // 데이터 입력
    public void inputData(BookDto bookDto){
        bookingMapper.insert();
    }

}