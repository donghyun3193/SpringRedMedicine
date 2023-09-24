package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.PfCommentDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PfCommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PfCommentMapper {
    //    삽입
    public void isertPfComment(PfCommentDto pfCommentDto);
    //    리스트 조회
    public List<PfCommentVo> selectPfCommentList(Long profileNumber);
    //    단건 조회
    public PfCommentVo selectPfComment(Long pfCommentNumber);
    //    수정
    public void updatePfComment(PfCommentDto pfCommentDto);
    //    삭제
    public void deletePfComment(Long pfCommentNumber);
    //    리스트 조회(페이징 처리)
    public List<PfCommentVo> selectPfCommentListPage(@Param("criteria") Criteria criteria, @Param("profileNumber") Long profileNumber);
    //    리플 수 조회
    public int selectPfCommentTotal(Long profileNumber);
}
