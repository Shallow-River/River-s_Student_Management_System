package com.example.back.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RewardVo {
    private Long studentId;

    private String studentName;

    private String rewardDescription;

    private Date recTime;

    private String description;
}
