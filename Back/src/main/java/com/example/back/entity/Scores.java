package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Scores {

    private Long id;

    private Double math_score;

    private Double java_score;

    private Double eng_score;

    private Double pe_score;
}
