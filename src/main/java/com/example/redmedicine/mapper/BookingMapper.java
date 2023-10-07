package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper {
    //
    public void insert(BookDto bookDto);

    //예약조회
    public BookDto selectBook(Long userNumber);
}
