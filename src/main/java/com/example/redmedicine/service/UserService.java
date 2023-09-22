package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    //회원 가입
    public void register(UserDto userDto){
        if (userDto == null) {
            throw new IllegalArgumentException("회원 정보 누락!");
        }
        //회원 가입 시 회원의 레벨을 1로 고정 -> 추후 상담사가 된다면 바뀔 것
        userDto.setUserLevel(1L);

//        userDto.setUserBirth("20000506");
        userMapper.insert(userDto);
    }

    //회원 번호 찾기
    public Long findUserNumber(String userId, String userPassword){
        return ofNullable(userMapper.selectUserNumber(userId,userPassword))
                .orElseThrow(()-> {throw new IllegalArgumentException("아이디와 패스워드가 일치하는 회원 정보가 없습니다.");
                });
    }

    //회원 정보 수정
    public void modify(UserDto userDto){
        userMapper.update(userDto);
    }

}
