package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setUserId("testId");
        userDto.setUserPassword("1234");
        userDto.setUserName("태스트");
        userDto.setUserEmail("aaa@naver.com");
        userDto.setUserPhone("010-1234-5678");
        userDto.setUserBirth("2023-09-18");
        userDto.setUserGender("M");
        userDto.setUserLevel(1L);

    }

    @Test
    void insert() {
        userMapper.insert(userDto);
    }

    @Test
    void selectUserNumber() {
        userMapper.selectUserNumber("testId","1234");
    }
}