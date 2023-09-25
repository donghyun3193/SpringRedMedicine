package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.domain.vo.DiaryVo;
import com.example.redmedicine.domain.vo.NoticeVo;
import com.example.redmedicine.mapper.DiaryMapper;
import com.example.redmedicine.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {
    private final DiaryMapper diaryMapper;

    // 추가
    public void register(DiaryDto diaryDto){
        diaryMapper.insert(diaryDto);
    }

    // 조회
    public DiaryVo find(Long diaryNumber){
        if (diaryNumber == null) {
            throw new IllegalArgumentException("일기쓰기 글번호 누락!!");
        }

        return Optional.ofNullable(diaryMapper.select(diaryNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!"); });
    }

    //회원 이름 조회
    public String findUserName(Long userNumber){
        if (userNumber == null) {
            return "user/login";
        }
       return diaryMapper.selectUserName(userNumber);
    }

    //전체 조회
    public List<DiaryVo> findAll(Criteria criteria){
        return diaryMapper.selectAll(criteria);
    }

    //전체 게시물 수 조회
    public int getTotal(){
        return diaryMapper.selectTotal();
    }

    //삭제
    public void remove(Long diaryNumber){
        if (diaryNumber == null) {
            throw new IllegalArgumentException("일기쓰기 글 번호 누락!!");
        }

        diaryMapper.delete(diaryNumber);
    }

    //수정
    public void modify(DiaryDto diaryDto){
        diaryMapper.update(diaryDto);
    }
}
