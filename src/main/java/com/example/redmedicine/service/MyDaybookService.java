package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.DiaryDto;
import com.example.redmedicine.domain.vo.Criteria;
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
    public List<DiaryDto> myDiary(Criteria criteria, Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호 글번호 누락");
        }
        return Optional.ofNullable(myDaybookMapper.selectDiary(criteria, userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!");
                });
    }

//  다이어리 전체글 수 조회
    public int getTotalDiary(){
        return myDaybookMapper.countDiary();
    }

//    상담 게시글 조회
    public List<CounselorDto> myCounselor(Criteria criteria, Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호 글번호 누락");
        }
        return Optional.ofNullable(myDaybookMapper.selectCounselor(criteria, userNumber))
                .orElseThrow(() -> { throw new IllegalArgumentException("존재하지 않는 회원 번호!");
            });
    }
    //  다이어리 전체글 수 조회
    public int getTotalCounselor(){
        return myDaybookMapper.countCounselor();
    }

}
