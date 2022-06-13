package com.example.back.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reward {
    private Long id;

    private Long studentId;

    private Long levels;

    private Date recTime;

    private String description;
}
