package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    //추가
    public void insert(NoticeDto noticeDto);

    //조회
    public NoticeVo select(Long noticeNumber);

    //전체 조회
    public List<NoticeVo> selectAll(Criteria criteria);

    //전체 게시물 수 조회
    public int selectTotal();

    //    삭제
    public void delete(Long noticeNumber);

    //    수정
    public void update(NoticeDto noticeDto);

    //공지사항 1번글 조회
    public NoticeVo selectFirstNotice();

    //공지사항 2번글 조회
    public NoticeVo selectSecondNotice();
}
