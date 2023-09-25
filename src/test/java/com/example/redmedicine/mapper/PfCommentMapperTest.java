package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.PfCommentDto;
import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.PfCommentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Slf4j
class PfCommentMapperTest {
    @Autowired
    PfCommentMapper pfCommentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProfileMapper profileMapper;

    PfCommentDto pfCommentDto;
    UserDto userDto;
    ProfileDto profileDto;

    @BeforeEach
    void setUp() {
        pfCommentDto = new PfCommentDto();
        pfCommentDto.setPfCommentContent("첫글");
        pfCommentDto.setPfCommnetDate("123");

        pfCommentMapper.insertPfComment(pfCommentDto);

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

        profileDto = new ProfileDto();
        profileDto.setProfileSuper(3L);
        profileDto.setProfileCareer(2L);
        profileDto.setProfileFee(10000L);
        profileDto.setProfileTarget("성인");
        profileDto.setProfileArea("가정폭력");
        profileDto.setProfileDay("월");
        profileDto.setProfileTime("09:00~10:00");
        profileDto.setProfileContent("아뵤뵤");

        profileMapper.insertProfilePay(profileDto);
    }


//    @Test
//    void selectPfCommentList() {
//        List<PfCommentVo> pfCommentVoList = pfCommentMapper.selectPfCommentList(profileDto.getProfileNumber());
//        assertThat(pfCommentVoList.size()).isNotEqualTo(0);
//    }

//    @Test
//    void selectPfComment() {
//        PfCommentVo pfCommentVo = pfCommentMapper.selectPfComment(pfCommentDto.getPfCommentNumber());
//        assertThat(pfCommentVo.getPfCommentContent()).isEqualTo(pfCommentDto.getPfCommentContent());
//    }

    @Test
    void updatePfComment() {
    }

    @Test
    void deletePfComment() {
    }

    @Test
    void selectPfCommentListPage() {
    }

    @Test
    void selectPfCommentTotal() {
    }
}