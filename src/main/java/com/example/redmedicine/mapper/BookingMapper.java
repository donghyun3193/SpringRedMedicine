package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.BookDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.BookVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookingMapper {
    //상담예약하기
    public void insert(BookDto bookDto);

    //상담사 번호 조회
    public Long selectCNumber(Long userNumber);

    //상담회원 전체조회
    public List<BookVo> selectAll(@Param("criteria") Criteria criteria,
                                  @Param("searchVo") SearchVo searchVo,
                                  @Param("userCNumber") Long userCNumber);

    //상담회원 회원수 조회
    public int selectTotal(Long userCNumber);

    //상담취소
    public void delete(Long bookNumber);

    //상담회원 검색 결과 회원 수 조회
    public int searchTotal(@Param("searchVo") SearchVo searchVo, @Param("userCNumber") Long userCNumber);

    //예약조회
    public BookDto selectBook(Long userNumber);

    //상담회원 모달 조회
    public BookVo selectModal(Long bookNumber);

    //상담 후 완료 처리
    public void update(Long bookNumber);
}
