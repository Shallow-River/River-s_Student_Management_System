package com.example.back.bo;

import lombok.Data;

@Data
public class ScoreEditBo {
    private Long studentId;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;
}
