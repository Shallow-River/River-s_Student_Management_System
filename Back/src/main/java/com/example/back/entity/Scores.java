package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Scores implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;

    private Double sumScore;
}
