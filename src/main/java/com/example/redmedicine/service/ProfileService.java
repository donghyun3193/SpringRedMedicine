package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import com.example.redmedicine.mapper.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    private final ProfileMapper profileMapper;

    //유료상담사등록
    public void profilePayRegister(ProfileDto profileDto){
        profileMapper.insertProfilePay(profileDto);
    }
    //무료상담사등록
    public void profileFreeRegister(ProfileDto profileDto){
        profileMapper.insertProfileFree(profileDto);
    }


    //상담사 삭제
    public void remove(Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("상담사 등록 번호 누락!");
        }
        profileMapper.delete(profileNumber);
    }
    //상담사 수정
    public void modify(ProfileDto profileDto){
        profileMapper.update(profileDto);
    }

    //유료상담사목록
    public List<ProfileVo> findProfilePayNumber(){
        return profileMapper.selectProfilePayNumber();

    }

    //무료상담사목록
    public List<ProfileVo> findProfileFreeNumber(){
        return profileMapper.selectProfileFreeNumber();
    }



    //유료상담사상세조회
    public ProfileVo findProfilePay(Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("프로필 번호 누락!!");
        }
        return Optional.ofNullable(profileMapper.selectProfilePay(profileNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 프로필 번호 누락!!"); });
    }

    //무료상담사상세조회
    public ProfileVo findProfileFree(Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("프로필 번호 누락!!");
        }
        return Optional.ofNullable(profileMapper.selectProfileFree(profileNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 프로필 번호 누락!!"); });
    }


}
