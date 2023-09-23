package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.NoticeDto;
import com.example.redmedicine.domain.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    //    추가
    public void insert(NoticeDto noticeDto);

    //    조회
    public NoticeVo select(Long noticeNumber);
}
