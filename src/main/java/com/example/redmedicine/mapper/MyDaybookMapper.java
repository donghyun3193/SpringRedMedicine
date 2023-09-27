package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.domain.vo.DiaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyDaybookMapper {
//    다이어리 조회
    public List<DiaryDto> selectDiary(Long userNumber);

//    상담게시글 조회
    public List<CounselorDto> selectCounselor(Long userNumber);

}
