package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CFileDto;
import com.example.redmedicine.domain.dto.PfFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CFileMapper {
    //삽입
    public void insertF(CFileDto cFileDto);
    //삭제
    public void delete(Long cFileNumber);
    //파일리스트조회
    public List<CFileDto> selectListF(Long cFileNumber);
    //전날 파일 목록
    public List<CFileDto> selectOldListF();
}
