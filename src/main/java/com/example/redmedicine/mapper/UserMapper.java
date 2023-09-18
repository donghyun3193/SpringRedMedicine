package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //회원 정보 삽입
    public void insert(UserDto userDto);
    //회원 번호 조회
    public Long selectUserNumber(@Param("userId") String userId, @Param("userPassword") String userPassword);
}
