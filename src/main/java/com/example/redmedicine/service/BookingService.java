package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookingService {
    private final BookingMapper bookingMapper;

    // 데이터 입력
    public void inputData(BookDto bookDto){
        log.info(bookDto.toString());
        bookingMapper.insert(bookDto);
    }

    //예약 조회
    public BookDto selectBook(Long userNumber){
        return bookingMapper.selectBook(userNumber);
    }
}