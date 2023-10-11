package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import com.example.redmedicine.domain.vo.Criteria;
import com.example.redmedicine.mapper.CounselorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CounselorService {
    private final CounselorMapper counselorMapper;//메퍼를 가지고 오겠다!
    private final CFileService cFileService;

    //    추가
    public void register(CounselorDto counselorDto){
        counselorMapper.insert(counselorDto);
    }

    //    삭제
    public void remove(Long counselorNumber){
        if(counselorNumber == null){
            throw new IllegalArgumentException("게시판 번호 누락!");
        }
//        fileService.remove(boardNumber);//첨부파일존재해도 지워지도록 단 c드라이브의 실제 파일은 안 지워짐
        cFileService.remove(counselorNumber);
        counselorMapper.delete(counselorNumber);
    }

    //    수정
    public void modify(CounselorDto counselorDto, List<MultipartFile> files){
        cFileService.remove(counselorDto.getCounselorNumber());//수정 전 일단 지우고
        if (!files.isEmpty() && !files.get(0).isEmpty()) {//비어있지 않다면, files 넘어온 정보가 정말 없다면
//cFileService.remove(counselorDto.getCounselorNumber());위의 것을 여기에 넣으면 지워지지 않을 수 있다 단 지우고 싶을 때는 다른 방법!
            try {
                cFileService.registerAndSaveFile(files, counselorDto.getCounselorNumber());//새로 인설트
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        counselorMapper.update(counselorDto);
    }
    //    조회
    public CounselorVo find(Long counselorNumber){
        if(counselorNumber == null){
            throw new IllegalArgumentException("상담 게시판 번호 누락!");
        }
        return Optional.ofNullable(counselorMapper.select(counselorNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 게시판 번호");});
    }

//    //  이름 조회
//    public CounselorVo findName(Long userNumber){
//        if(userNumber == null){
//            throw new IllegalArgumentException("상담 게시판 내 user세션 누락!");
//        }
//
//        return Optional.ofNullable(counselorMapper.selectName(userNumber))
//                .orElseThrow(()->{throw new IllegalArgumentException("회원 번호 없음");});
//    }

    //전체 게시물 수 조회
    public int getTotal(){
        return counselorMapper.selectTotal();
    }

    //    전체조회
    public List<CounselorVo> findAll(Criteria criteria){
        return counselorMapper.selectAll(criteria);
    }

    //게시물 작성 최종(파일처리가 추가된 형태 실행 쿼리를 2개로 만들기 위한 작업)
    public void registerAndFileProc(CounselorDto counselorDto, List<MultipartFile> files) {
        register(counselorDto);

        if (files.get(0).isEmpty()) {
            return;
        /*
        files.get(0).isEmpty()를 사용하면 files 리스트가 비어있는 경우가 아니라도
        첫 번째 파일이 비어있으면 파일 처리를 건너뛸 수 있습니다.
        이렇게 수정한 코드는 첫 번째 파일만 고려하는 것이므로 다른 파일들은 무시되고,
        첫 번째 파일이 비어있을 때만 파일 처리를 하지 않는다는 동작을 수행합니다.

        따라서 files.isEmpty()와 files.get(0).isEmpty()는 서로 다른 동작을 수행하므로,
        원하는 동작에 따라 선택하여 사용해야 합니다.
        */
        }
        try {
            cFileService.registerAndSaveFile(files, counselorDto.getCounselorNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
