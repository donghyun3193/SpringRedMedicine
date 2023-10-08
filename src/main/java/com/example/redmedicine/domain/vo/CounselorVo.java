package com.example.redmedicine.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class CounselorVo {
    private Long counselorNumber;
    private Long userNumber;
    private String counselorTitle;
    private Date counselorDate;
    private String counselorContent;
    //↓write에 필요 단 수정은 불가능하도록
    private String userName;
    //↓Vo에 첨부파일때문에 아래의 쿼리 추가해줬다
    private String cFileName;
    private String cFileRoute;
    private String cFileUuid;

}
