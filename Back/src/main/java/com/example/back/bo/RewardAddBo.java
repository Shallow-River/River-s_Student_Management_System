package com.example.back.bo;

import lombok.Data;

@Data
public class RewardAddBo {

    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long levels;

    private String description;
}
