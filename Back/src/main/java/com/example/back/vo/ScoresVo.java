package com.example.back.vo;

import lombok.Data;

@Data
public class ScoresVo {
    private Long id;

    private String stu_name;

    private Double math_score;

    private Double java_score;

    private Double eng_score;

    private Double pe_score;
}
