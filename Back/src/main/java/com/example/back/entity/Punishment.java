package com.example.back.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Punishment {
    private Long id;

    private Long studentId;

    private Long levels;

    private Date recTime;

    //1生效，0不生效
    private Integer enable;

    private String description;
}
