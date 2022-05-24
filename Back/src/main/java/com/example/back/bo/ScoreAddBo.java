package com.example.back.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ScoreAddBo {
    @NotBlank(message = "学号不能为空！")
    private Long id;

    private Double math_score;

    private Double java_score;

    private Double eng_score;

    private Double pe_score;
}
