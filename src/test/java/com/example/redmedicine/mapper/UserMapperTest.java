package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    @Test
    void update(){
        userDto.setUserId("updateTest");
        userMapper.update(userDto);
        /*
        ↑ userDto 객체를 사용하여 데이터베이스 내의 회원 정보를 업데이트하려는 것
        업데이트 작업은 userDto 객체의 내용을 데이터베이스의 해당 레코드에 반영합니다.
        */
        userDto = userMapper.select();

        Assertions.assertThat(userDto.getUserNumber()).isEqualTo("updateTest");
    }
}