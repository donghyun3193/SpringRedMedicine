package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.mapper.MyDaybookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyDaybookService {
    private final MyDaybookMapper myDaybookMapper;

//    다이어리 조회
    public List<DiaryDto> myDiary(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호 글번호 누락");
        }
        return Optional.ofNullable(myDaybookMapper.selectDiary(userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!");
                });
    }

//    상담 게시글 조회
    public List<CounselorDto> myCounsel(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호 글번호 누락");
        }
        return Optional.ofNullable(myDaybookMapper.selectCounselor(userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!");
                });
    }

}
