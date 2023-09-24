package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.mapper.ProfileMapper;
import com.example.redmedicine.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @Mock
    ProfileMapper profileMapper;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    ProfileService profileService;

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
    void payRegister() {
//        stubbing -> 목객체의 행위를 정의한다. (insert메소드를 정의)
        doNothing().when(profileMapper).insertProfilePay(any(ProfileDto.class));
//      stubbing한 메소드가 실행될 수 있는 상황을 만들어준다.
        profileService.profilePayRegister(profileDto);
//        검증
        Mockito.verify(profileMapper, times(2)).insertProfilePay(any(ProfileDto.class));
    }
    @Test
    void freeRegister() {
//        stubbing -> 목객체의 행위를 정의한다. (insert메소드를 정의)
        doNothing().when(profileMapper).insertProfileFree(any(ProfileDto.class));
//      stubbing한 메소드가 실행될 수 있는 상황을 만들어준다.
        profileService.profileFreeRegister(profileDto);
//        검증
        Mockito.verify(profileMapper, times(1)).insertProfileFree(any(ProfileDto.class));
    }

    @Test
    void remove() {
        doNothing().when(profileMapper).delete(any(Long.class));

        profileService.remove(1L);

        verify(profileMapper,times(1)).delete(any(Long.class));
    }

    @Test
    void findProfilePay(){
        doReturn(profileVo).when(profileMapper).selectProfilePay(any(Long.class));

        ProfileVo profileList = profileService.findProfilePay(1L);

        assertThat(profileList.getProfileContent()).isEqualTo(profileVo.getProfileContent());
    }

    @Test
    void findProfileFree(){
        doReturn(profileVo).when(profileMapper).selectProfileFree(any(Long.class));

        ProfileVo profileList = profileService.findProfileFree(1L);

        assertThat(profileList.getProfileContent()).isEqualTo(profileVo.getProfileContent());
    }

}