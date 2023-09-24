package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.NoticeVo;
import com.example.redmedicine.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {
    private final NoticeMapper noticeMapper;

    // 추가
    public void register(NoticeDto noticeDto){
        noticeMapper.insert(noticeDto);
    }

    // 조회
    public NoticeVo find(Long noticeNumber){
        if (noticeNumber == null) {
            throw new IllegalArgumentException("공지사항 글번호 누락!!");
        }

        return Optional.ofNullable(noticeMapper.select(noticeNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!"); });
    }

    //전체 조회
    public List<NoticeVo> findAll(Criteria criteria){
        return noticeMapper.selectAll(criteria);
    }

    //전체 게시물 수 조회
    public int getTotal(){
        return noticeMapper.selectTotal();
    }

    //삭제
    public void remove(Long noticeNumber){
        if (noticeNumber == null) {
            throw new IllegalArgumentException("공지사항 글 번호 누락!!");
        }

        noticeMapper.delete(noticeNumber);
    }

    //수정
    public void modify(NoticeDto noticeDto){
        noticeMapper.update(noticeDto);
    }
}
