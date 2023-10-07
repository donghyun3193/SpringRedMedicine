package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.domain.vo.BookVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.SearchVo;
import com.example.redmedicine.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookingService {
    private final BookingMapper bookingMapper;

    //상담사 번호 조회
    public Long findCNumber(Long userNumber){
        return ofNullable(bookingMapper.selectCNumber(userNumber))
                .orElseThrow(()-> {throw new IllegalArgumentException(" 회원 번호 누락");
                });
    }

    // 데이터 입력
    public void inputData(BookDto bookDto){
        log.info(bookDto.toString());
        bookingMapper.insert(bookDto);
    }

<<<<<<< HEAD

    //상담회원 전체조회
    public List<BookVo> findAll(Criteria criteria, SearchVo searchVo, Long userCNumber){
        return bookingMapper.selectAll(criteria, searchVo, userCNumber);
    }

    //상담회원 수 조회
    public int getTotal(Long userCNumber){
        return bookingMapper.selectTotal(userCNumber);
    }

    //상담회원 회원수 조회
    public int searchTotal(SearchVo searchVo, Long userCNumber){
        return bookingMapper.searchTotal(searchVo, userCNumber);
    }

    //상담 예약 취소
    public void remove(Long bookNumber){
        if (bookNumber == null){
            throw new IllegalArgumentException("예약 번호 누락!!");
        }
        bookingMapper.delete(bookNumber);
=======
    //예약 조회
    public BookDto selectBook(Long userNumber){
        return bookingMapper.selectBook(userNumber);
>>>>>>> jiyoon1007
    }
}