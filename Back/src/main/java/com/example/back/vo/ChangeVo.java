package com.example.back.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ChangeVo {
    private Long studentId;

    private String studentName;

    private String changeDescription;

    private Date recTime;

    private String description;
}