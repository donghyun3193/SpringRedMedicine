package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.CCommentDto;
import com.example.redmedicine.domain.vo.CCommentVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.mapper.CCommentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CCommentService {
    private final CCommentMapper cCommentMapper;

    //    삽입
    public void registerCComment(CCommentDto cCommentDto){
        cCommentMapper.insertCComment(cCommentDto);
    }

    //    리스트 조회
    public List<CCommentVo> findCCommentList(Long counselorNumber){
        if (counselorNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return cCommentMapper.selectCCommentList(counselorNumber);
    }
    //    단건 조회
    public CCommentVo selectCComment(Long cCommentNumber){
        if (cCommentNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락!!");
        }
        return Optional.ofNullable(cCommentMapper.selectCComment(cCommentNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 댓글");});
    }
    //    수정
    public void modifyCComment(CCommentDto cCommentDto){
        cCommentMapper.updateCComment(cCommentDto);
    }

    //    삭제
    public void removeCComment(Long cCommentNumber){
        if (cCommentNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        cCommentMapper.deleteCComment(cCommentNumber);
    }

    //    리스트 조회(페이징 처리)
    public List<CCommentVo> findCCommentListPage(@Param("criteria") Criteria criteria, @Param("counselorNumber") Long counselorNumber){
        if (counselorNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return cCommentMapper.selectCCommentListPage(criteria, counselorNumber);
    }

    //    리플 수 조회
    public int findCCommentTotal(Long counselorNumber){
        if (counselorNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return cCommentMapper.selectCCommentTotal(counselorNumber);
    }
}
