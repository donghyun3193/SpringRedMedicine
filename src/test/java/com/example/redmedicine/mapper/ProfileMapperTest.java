package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.ProfileDto;
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
//    UserDto userDto;

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

//        userDto = new UserDto();
//        userDto.setUserName("칸쵸");
//        userDto.setUserPhone("01023421234");
//        userDto.setUserId("aaa");
//        userDto.setUserBirth("20201029");
//        userDto.setUserEmail("aaa@naver.com");
//        userDto.setUserGender("M");
//        userDto.setUserPassword("123");
//        userDto.setUserLevel(1L);
//
//
//        userMapper.insert(userDto);
//
//        counselorDto.setUserNumber(userDto.getUserNumber());

        profileMapper.insert(profileDto);

    }


    @Test
    void insertTest() {
        profileMapper.insert(profileDto);
    }

    @Test
    @DisplayName("삭제")
    void deleteTest() {
        profileMapper.delete(profileDto.getUserNumber());

    }

    @Test
    void updateTest() {
        profileDto.setProfileContent("update test");

        profileMapper.update(profileDto);
    }

    @Test
    @DisplayName("유료상담사조회")
    void selectProfilePayNumberTest() {
        List<ProfileVo> counselorList = profileMapper.selectProfilePayNumber();
        // 여기서 CounselorVo는 select 쿼리 결과를 매핑한 VO 클래스

        // 쿼리 실행 결과가 비어 있지 않은지 확인
        assertEquals(false, counselorList.isEmpty());
    }


    @Test
    @DisplayName("무료상담사조회")
    void selectProfileFreeNumberTest() {
        List<ProfileVo> counselorList = profileMapper.selectProfileFreeNumber();
        // 여기서 CounselorVo는 select 쿼리 결과를 매핑한 VO 클래스

        // 쿼리 실행 결과가 비어 있지 않은지 확인
        assertEquals(false,counselorList.isEmpty());
    }
}