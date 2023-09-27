package com.example.redmedicine.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private int page;   // 현재 페이지
    private int amount; // 한 페이지 당 게시물 수
    private int amountMypage; //내글보기 한 페이지당 게시물 수

    public Criteria() {
        this.page = 1;
        this.amount = 10;
        this.amountMypage = 6;
    }
}
