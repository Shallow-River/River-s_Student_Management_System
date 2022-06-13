package com.example.back.bo;

import lombok.Data;

import java.util.Date;

@Data
public class RewardAddBo {
    private Long studentId;

    private Long levels;

    private Date recTime;

    private String description;
}
