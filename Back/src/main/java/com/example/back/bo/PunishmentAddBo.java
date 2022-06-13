package com.example.back.bo;

import lombok.Data;

import java.util.Date;

@Data
public class PunishmentAddBo {
    private Long studentId;

    private Long levels;

    private Date recTime;

    private String enable;

    private String description;
}
