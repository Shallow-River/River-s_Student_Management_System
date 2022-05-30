package com.example.back.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ScoreAddBo {
    @NotBlank(message = "学号不能为空！")
    private Long id;

    private Double mathScore;

    private Double javaScore;

    private Double engScore;

    private Double peScore;
}
