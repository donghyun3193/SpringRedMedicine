package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //회원 정보 삽입
    public void insert(UserDto userDto);

    //회원 번호 조회 -> 입력받은 ID와 PW를 이용해서 userNumber를 가져오겠다?
    public Long selectUserNumber(@Param("userId") String userId, @Param("userPassword") String userPassword);

    //회원 정보 조회
    public UserDto selectAll();

    //조회
    public UserDto select(Long userNumber);

    //회원 정보 수정 - update
    public void update(UserDto userDto);

    //비밀번호 변경
    public void updatePw(Long userNumber, String userPassword);


}
