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

    //    삭제
    public void delete(Long counselorNumber);

    //    수정
    public void update(CounselorDto counselorDto);

    //    조회 -> counselorVo에 counselorNumber의 정보를 가져와 모든 정보를 확인하겠다
    public CounselorVo select(Long counselorNumber);

    //    전체조회 -> counselBoard페이지에서 모든 게시글을 볼 수 있도록 List를 사용해서 뿌려주기 위함
    //    이 때 페이징 처리를 위해서 Criteria매개 변수를 추가하였다
    public List<CounselorVo> selectAll(Criteria criteria);

    //    전체 게시물 수 조회
    public int selectTotal();
}
