package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CCommentDto;
import com.example.redmedicine.domain.vo.CCommentVo;
import com.example.redmedicine.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CCommentMapper {
    //    삽입
    public void insertCComment(CCommentDto cCommentDto);
    //    리스트 조회
    public List<CCommentVo> selectCCommentList(Long counselorNumber);
    //    단건 조회
    public CCommentVo selectCComment(Long cCommentNumber);
    //    수정
    public void updateCComment(CCommentDto cCommentDto);
    //    삭제
    public void deleteCComment(Long cCommentNumber);

    //    댓글 리스트 조회(페이징 처리)
    public List<CCommentVo> selectCCommentListPage(@Param("criteria") Criteria criteria, @Param("counselorNumber") Long counselorNumber);
    //여기서 @Param("매개변수는 개인이 정해서 사용할 수 있다!") -> 키와 값의 형태만 유지시키면 됨!

    //    리플 수 조회
    public int selectCCommentTotal(Long counselorNumber);
}
