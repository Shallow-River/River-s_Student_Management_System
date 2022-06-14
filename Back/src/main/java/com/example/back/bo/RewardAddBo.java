package com.example.back.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RewardAddBo {
    private Long studentId;

    private Long levels;

    private Date recTime;

    private String description;
}
