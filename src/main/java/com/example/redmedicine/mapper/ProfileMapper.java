package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileMapper {
    //유료 상담사 등록
    public void insertProfilePay(ProfileDto profileDto);
    //유료 상담사 등록
    public void insertProfileFree(ProfileDto profileDto);
    //유료 상담사 삭제
    public void deleteProfilePay(Long profileNumber);
    //무료 상담사 삭제
    public void deleteProfileFree(Long profileNumber);
    //후기 유저 이름 찾기
    public String selectUserName(Long userNumber);
    //후기 유저 이름 찾기
    public Long selectUserLevel(Long userNumber);
    //유료상담사목록
    public List<ProfileVo> selectProfilePayNumber();
    //무료상담사목록
    public List<ProfileVo> selectProfileFreeNumber();
    //유료상담사상세조회
    public ProfileVo selectProfilePay(Long profileNumber);
    //무료상담사상세조회
    public ProfileVo selectProfileFree(Long profileNumber);


}
