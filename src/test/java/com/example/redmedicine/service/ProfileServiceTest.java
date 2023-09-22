package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.mapper.ProfileMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @Mock
    ProfileMapper profileMapper;

    @InjectMocks
    ProfileService profileService;

    ProfileDto profileDto;
    ProfileVo profileVo;

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
    void register() {
//        stubbing -> 목객체의 행위를 정의한다. (insert메소드를 정의)
        doNothing().when(profileMapper).insert(any(ProfileDto.class));
//      stubbing한 메소드가 실행될 수 있는 상황을 만들어준다.
        profileService.register(profileDto);
//        검증
        Mockito.verify(profileMapper, times(2)).insert(any(ProfileDto.class));
    }

    @Test
    void remove() {
        doNothing().when(profileMapper).delete(any(Long.class));

        profileService.remove(1L);

        verify(profileMapper,times(1)).delete(any(Long.class));
    }

    @Test
    void modify() {
        doNothing().when(profileMapper).update((any(ProfileDto.class)));

        profileService.modify(new ProfileDto());

        verify(profileMapper, times(1)).update(any(ProfileDto.class));

    }

//    @Test
//    void findProfilePayNumber() {
//        doReturn(List.of(new ProfileVo(),new ProfileDto())).when(profileMapper).selectProfilePayNumber();
//
//        List<ProfileVo> counselorList = profileService.findProfilePayNumber();
//
//        assertThat(counselorList.size()).isEqualTo(2);
//    }
//
//    @Test
//    void findProfileFreeNumber() {
//        doReturn(List.of(new ProfileVo(),new ProfileDto())).when(profileMapper).selectProfileFreeNumber();
//
//        List<ProfileVo> counselorList = profileService.findProfileFreeNumber();
//
//        assertThat(counselorList.size()).isEqualTo(2);
//    }
}