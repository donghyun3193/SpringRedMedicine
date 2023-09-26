package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PageVo;
import com.example.redmedicine.domain.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //회원 정보 조회
    public UserDto select(Long userNumber);

    //전체 회원 조회
    public List<UserDto> selectAll(@Param("criteria") Criteria criteria, @Param("searchVo") SearchVo searchVo);

//    전체 회원 수 조회
    public int selectTotal();

//    회원 삭제
    public void delete(Long userNumber);

//    검색 결과 회원 수 조회
    public int searchTotal(SearchVo searchVo);


}
