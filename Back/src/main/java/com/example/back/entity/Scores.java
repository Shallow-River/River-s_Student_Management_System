package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Scores {

    private Long id;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;
}
