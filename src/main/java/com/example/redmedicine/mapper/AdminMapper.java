package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //회원 정보 조회
//    public void select(Long userNumber);

    //유저 넘버 뽑아오기
    UserDto getUserNumber(Long userNumber);
}
