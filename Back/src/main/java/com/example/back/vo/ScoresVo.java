package com.example.back.vo;

import lombok.Data;

@Data
public class ScoresVo {
    private Long id;

    private String stuName;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;

    private Double sumScore;
}
