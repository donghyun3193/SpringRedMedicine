package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.CounselorDto;
import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.domain.vo.CounselorVo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class CounselorMapperTest {

    @Autowired
    CounselorMapper counselorMapper;

    @Autowired
    UserMapper userMapper;

    CounselorDto counselorDto;
    CounselorVo counselorVo;
    UserDto userDto;

    @BeforeEach
    void setUp() {
        counselorDto = new CounselorDto();

//        counselorVo.setUserName("홍길동");
        counselorDto.setCounselorTitle("0924상담에 관하여!");
        counselorDto.setCounselorContent("주말 상담 너무 힘들어요");

        userDto = new UserDto();
        //글 작성하기 전 UserId만 필요했지만
        //마이바티스의 null에 의한 오류로 userDto에 관련된 모든 정보들이 필요했다
        //따라서 @BeforeEach에서 작업할 때 미리 생성해서 추후 테스트에 문제없도록 조치!
        userDto.setUserId("test01");
        userDto.setUserPassword("123");
        userDto.setUserName("홍길동");
        userDto.setUserEmail("hong@naver.com");
        userDto.setUserPhone("01033334444");
        userDto.setUserBirth("1990-10-25");
        userDto.setUserGender("F");
        userDto.setUserJoindate("2023-09-24");
        userDto.setUserLevel(1L);

        userMapper.insert(userDto);
        counselorDto.setUserNumber(userDto.getUserNumber());

        counselorMapper.insert(counselorDto);
    }

    @Test
    void delete() {
        counselorMapper.delete(counselorDto.getCounselorNumber());
        CounselorVo counselorVo = counselorMapper.select(counselorDto.getCounselorNumber());
        //제거된다면 vo에서 출력되지 않을 것

        assertThat(counselorVo).isNull();//성공!
        /*
        CounselorVo 객체가 null인지 확인하고, 만약 null이 아니라면 테스트를 실패로 표시합니다.
        이것은 특정 조건을 검증하고 코드의 정확성을 확인하는 데 사용되는 자동화된 테스트의 한 부분입니다.
        */
    }


    @Test
    void update() {
        counselorDto.setCounselorTitle("update test");
        counselorMapper.update(counselorDto);
        /*
        ↑ boardDto 객체를 사용하여 데이터베이스 내의 보드 정보를 업데이트하려는 것
        업데이트 작업은 boardDto 객체의 내용을 데이터베이스의 해당 레코드에 반영합니다.
        */
        counselorVo = counselorMapper.select(counselorDto.getCounselorNumber());//ctrl + alt + v : 홈키로 갈필요 없이 담도록
        //결국 boardVo에 메퍼를 select한(boardDto.getBoardNumber()기반으로)정보를 저장할 것
        assertThat(counselorVo.getCounselorTitle()).isEqualTo("update test");
        //즉 위에서 수정한 Title과 저장 된 Title이 같은지 비교하겠다

    }

    @Test
    void select() {
            CounselorVo counselorVo = counselorMapper.select(counselorDto.getCounselorNumber());
            assertThat(counselorVo.getUserName()).isEqualTo(userDto.getUserName());
    }
}