package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
class ProfileMapperTest {

    @Autowired
    ProfileMapper profileMapper;

    @Autowired
    UserMapper userMapper;

    ProfileDto profileDto;
    ProfileVo profileVo;
    UserDto userDto;

    @BeforeEach
    void setUp(){
        profileDto = new ProfileDto();
        profileDto.setProfileSuper(3L);
        profileDto.setUserNumber(1L);
        profileDto.setProfileCareer(2L);
        profileDto.setProfileFee(10000L);
        profileDto.setProfileTarget("성인");
        profileDto.setProfileArea("가정폭력");
        profileDto.setProfileDay("월");
        profileDto.setProfileTime("09:00~10:00");
        profileDto.setProfileContent("아뵤뵤");

        profileVo = new ProfileVo();
        profileVo.setProfileSuper(3L);
        profileVo.setUserNumber(1L);
        profileVo.setProfileCareer(2L);
        profileVo.setProfileFee(10000L);
        profileVo.setProfileTarget("성인");
        profileVo.setProfileArea("가정폭력");
        profileVo.setProfileDay("월");
        profileVo.setProfileTime("09:00~10:00");
        profileVo.setProfileContent("아뵤뵤");



        userDto = new UserDto();
        userDto.setUserName("칸쵸");
        userDto.setUserPhone("01023421234");
        userDto.setUserId("aaa");
        userDto.setUserBirth("20201029");
        userDto.setUserEmail("aaa@naver.com");
        userDto.setUserGender("M");
        userDto.setUserPassword("123");
        userDto.setUserLevel(1L);
        userDto.setUserJoindate("1111");


        userMapper.insert(userDto);

        profileDto.setUserNumber(userDto.getUserNumber());

        profileMapper.insertProfilePay(profileDto);
        profileMapper.insertProfileFree(profileDto);
    }


    @Test
    void insertProfilePayTest() {
        profileMapper.insertProfilePay(profileDto);
    }

    @Test
    void insertProfileFreeTest() {
        profileMapper.insertProfilePay(profileDto);
    }

    @Test
    @DisplayName("삭제")
    void deleteTest() {
        profileMapper.delete(profileDto.getUserNumber());

    }

    @Test
    @DisplayName("유료상담사목록조회")
    void selectProfilePayNumberTest() {
        List<ProfileVo> counselorList = profileMapper.selectProfilePayNumber();
        // 여기서 CounselorVo는 select 쿼리 결과를 매핑한 VO 클래스

        // 쿼리 실행 결과가 비어 있지 않은지 확인
        assertEquals(false, counselorList.isEmpty());
    }


    @Test
    @DisplayName("무료상담사목록조회")
    void selectProfileFreeNumberTest() {
        List<ProfileVo> counselorList = profileMapper.selectProfileFreeNumber();
        // 여기서 ProfileVo는 select 쿼리 결과를 매핑한 VO 클래스

        // 쿼리 실행 결과가 비어 있지 않은지 확인
        assertEquals(false,counselorList.isEmpty());
    }

    @Test
    @DisplayName("유료상담사상세조회")
    void selectProfilePay(){
        ProfileVo profileVo = profileMapper.selectProfilePay(profileDto.getProfileNumber());

        assertThat(profileVo.getUserName()).isEqualTo(userDto.getUserName());
    }

    @Test
    @DisplayName("무료상담사상세조회")
    void selectProfileFree(){
        ProfileVo profileVo = profileMapper.selectProfileFree(profileDto.getProfileNumber());

        assertThat(profileVo.getUserName()).isEqualTo(userDto.getUserName());
    }
}