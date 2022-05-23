package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "用户名不可为空")
    @Size(min = 0, max = 20, message = "用户名长度不能超过20个字符")
    private String stu_name;

    private String stu_sex;

    private String stu_birth;
}
