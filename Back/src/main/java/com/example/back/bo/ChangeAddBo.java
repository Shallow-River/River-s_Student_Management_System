package com.example.back.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ChangeAddBo {
    private Long studentId;

    private Long changeId;

    private Date recTime;

    private String description;
}
