package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.DiaryVo;
import com.example.redmedicine.domain.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    //추가
    public void insert(DiaryDto diaryDto);

    //조회
    public DiaryVo select(Long diaryNumber);

    //전체 조회
    public List<DiaryVo> selectAll(Criteria criteria);

    //전체 게시물 수 조회
    public int selectTotal();

    //    삭제
    public void delete(Long diaryNumber);

    //    수정
    public void update(DiaryDto diaryDto);

    //회원 이름 조회
    public String selectUserName(Long userNumber);
}
