package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import com.example.redmedicine.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselorMapper {
    //    추가
    public void insert(CounselorDto counselorDto);

    //     추가
    public void insertVo(CounselorVo counselorVo);

    //    삭제
    public void delete(Long counselorNumber);

    //    수정
    public void update(CounselorDto counselorDto);

    //    조회 userName의 정보가 필요했다
    public CounselorVo select(Long counselorNumber);
    
    // 이름을 조회
    public CounselorVo selectName(Long userNumber);

    //    전체조회
    public List<CounselorVo> selectAll(Criteria criteria);

    //    전체 게시물 수 조회
    public int selectTotal();
}
