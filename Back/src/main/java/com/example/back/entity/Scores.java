package com.example.back.entity;

import lombok.Data;

@Data
public class Scores {

    private Long id;

    private Long name;

    private Double math_score;

    private Double java_score;

    private Double eng_score;

    private Double pe_score;
}
