package com.example.back.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RewardVo {
    private Long studentId;

    private String studentName;

    private String rewardDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recTime;

    private String description;
}
