package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.NoticeVo;
import com.example.redmedicine.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {
    private final NoticeMapper noticeMapper;

    //    추가
    public void register(NoticeDto noticeDto){
        noticeMapper.insert(noticeDto);
    }

    //    조회
    public NoticeVo find(Long noticeNumber){
        if (noticeNumber == null) {
            throw new IllegalArgumentException("공지사항 글번호 누락!!");
        }

        return Optional.ofNullable(noticeMapper.select(noticeNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!"); });
    }
}
