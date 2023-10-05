package com.example.redmedicine.mapper;

import com.example.redmedicine.domain.dto.PayDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    //결제 정보 등록
    public void insert(PayDto payDto);


}
