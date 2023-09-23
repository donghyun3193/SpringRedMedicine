package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //회원 정보 조회
    public UserDto select(Long userNumber);

    //전체 회원 조회
    public List<UserDto> selectAll();


}
