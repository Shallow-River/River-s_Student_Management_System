package com.example.back.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PunishmentVo {
    private Long id;

    private Long studentId;

    private String studentName;

    private Date recTime;

    private String description;

    //1生效，0不生效
    private Integer enable;
}
