package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.PfCommentDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.PfCommentVo;
import com.example.redmedicine.mapper.PfCommentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PfCommentService {
    private final PfCommentMapper pfCommentMapper;

    //    삽입
    public void registerPfComment(PfCommentDto pfCommentDto){
        pfCommentMapper.insertPfComment(pfCommentDto);
    }
    //    리스트 조회
    public List<PfCommentVo> findPfCommentList(Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return pfCommentMapper.selectPfCommentList(profileNumber);
    }
    //    단건 조회
    public PfCommentVo selectPfComment(Long pfCommentNumber){
        if (pfCommentNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return Optional.ofNullable(pfCommentMapper.selectPfComment(pfCommentNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 댓글");});
    }
    //    수정
    public void modifyPfComment(PfCommentDto pfCommentDto){
        pfCommentMapper.updatePfComment(pfCommentDto);
    }
    //    삭제
    public void removePfComment(Long pfCommentNumber){
        if (pfCommentNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        pfCommentMapper.deletePfComment(pfCommentNumber);
    }
    //    리스트 조회(페이징 처리)
    public List<PfCommentVo> findPfCommentListPage(@Param("criteria") Criteria criteria, @Param("profileNumber") Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return pfCommentMapper.selectPfCommentListPage(criteria, profileNumber);
    }
    //    리플 수 조회
    public int findPfCommentTotal(Long profileNumber){
        if (profileNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return pfCommentMapper.selectPfCommentTotal(profileNumber);
    }
}
