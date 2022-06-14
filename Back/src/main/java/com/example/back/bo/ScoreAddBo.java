package com.example.back.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.example.back.common.StringConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ScoreAddBo {
    @NotBlank(message = "学号不能为空！")
    private Long studentId;

    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$", message = "只能输入数字、字母与汉字！")
    private String className;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;
}
