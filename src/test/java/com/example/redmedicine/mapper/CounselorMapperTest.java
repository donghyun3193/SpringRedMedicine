package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
class CounselorMapperTest {

    @Autowired
    CounselorMapper counselorMapper;

    CounselorDto counselorDto;
    UserDto userDto;

    @BeforeEach
    void setUp(){
        counselorDto = new CounselorDto();
        counselorDto.setProfileSuper(3L);
        counselorDto.setUserNumber(1L);
        counselorDto.setProfileCareer(2L);
        counselorDto.setProfileFee(10000L);
        counselorDto.setProfileTarget("성인");
        counselorDto.setProfileArea("가정폭력");
        counselorDto.setProfileDay("월");
        counselorDto.setProfileTime("09:00~10:00");
        counselorDto.setProfileContent("아뵤뵤");

        userDto = new UserDto();
        userDto.setUserName("칸쵸");
    }




    @Test
    void register() {
        counselorMapper.insert(counselorDto);
    }

    @Test
    @DisplayName("삭제")
    void remove() {
        counselorMapper.delete(counselorDto.getProfileNumber());

//        CounselorDto counselorDto = counselorMapper.selectProfileNumber(this.counselorDto.getProfileNumber());
//
//        assertThat(this.counselorDto).isNull();
    }

    @Test
    void update() {
        counselorMapper.update(counselorDto);


    }

    @Test
    void selectProfilePayNumber() {
    }

    @Test
    void selectProfileFreeNumber() {
    }
}