package com.example.back.bo;

import lombok.Data;

import java.util.Date;

@Data
public class ChangeAddBo {
    private Long studentId;

    private Long changeId;

    private Date recTime;

    private String description;
}
