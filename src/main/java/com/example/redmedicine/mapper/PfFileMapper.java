package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.PfFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PfFileMapper {
    //삽입
    public void insertFile(PfFileDto pfFileDto);
    //삭제
    public void delete(Long pfFileNumber);
    //파일리스트조회
    public List<PfFileDto> selectList(Long pfFileNumber);
    //전날 파일 목록
    public List<PfFileDto> selectOldList();
}
