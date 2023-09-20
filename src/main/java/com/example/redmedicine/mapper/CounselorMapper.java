package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselorMapper {
    //상담사등록
    public void insert(CounselorDto counselorDto);
    //상담사 삭제
    public void delete(long profileNumber);
    //상담사 수정
    public void update(CounselorDto counselorDto);
//    //상담사 확인
//    public CounselorDto selectProfileNumber(Long counselorNumber);
    //유료상담사목록
    public List<CounselorVo> selectProfilePayNumber();
    //무료상담사목록
    public List<CounselorVo> selectProfileFreeNumber();
}
