package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.ProfileDto;
import com.example.redmedicine.domain.vo.ProfileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileMapper {
    //상담사등록
    public void insert(ProfileDto profileDto);
    //상담사 삭제
    public void delete(Long profileNumber);
    //상담사 수정
    public void update(ProfileDto profileDto);
    //유료상담사목록
    public List<ProfileVo> selectProfilePayNumber();
    //무료상담사목록
    public List<ProfileVo> selectProfileFreeNumber();
    //유료상담사상세조회
    public ProfileVo selectProfilePay(Long profileNumber);
    //무료상담사상세조회
    public ProfileVo selectProfileFree(Long profileNumber);
}
