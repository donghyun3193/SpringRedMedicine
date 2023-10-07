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

    //회원 정보 조회
    public UserDto find(Long userNumber){//세션에서 받을 userNumber를 가지고 모든 정보를 조회 후 꽂겠다
        if(userNumber == null){
            throw new IllegalArgumentException("회원 번호 누락!");
        }
        return Optional.ofNullable(userMapper.select(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원번호");});
    }
    //유저 이름 찾기
    public String findUserName(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return Optional.ofNullable(userMapper.selectUserName(userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 유저 번호 누락!!"); });
    }
    //유저 레벨 찾기
    public Long findUserLevel(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return Optional.ofNullable(userMapper.selectUserLevel(userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 유저 번호 누락!!"); });
    }

    //회원 정보 수정
    public void modify(UserDto userDto){
        userMapper.update(userDto);
    }

    //비밀번호 변경
    public void modifyPw(String userName, String userPhone, String newPassword){ userMapper.updatePw(userName, userPhone, newPassword);}

    //아이디 찾기
    public String findId(String userName, String userPhone){
        String resultText ="";
        String result =userMapper.selectUserId(userName,userPhone);

         if(result == null){
            resultText = "일치하는 회원정보가 없습니다.";
        }else{
             resultText = "회원님의 아이디는 " + result + " 입니다";
         }
        return resultText;
    }

    //    회원 아이디 중복 검사
    public int checkId(String userId){
        return userMapper.selectId(userId);
    }

    // 회원 휴대폰 번호 조회
    public String findUserPhoneNumber(Long userNumber){
       String userPhoneNumber = userMapper.selectUserPhoneNumber(userNumber);
       return userPhoneNumber;
    }
}