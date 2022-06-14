package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long studentId;

    @NotBlank(message = "用户名不可为空")
    @Size(min = 0, max = 20, message = "用户名长度不能超过20个字符")
    private String stuName;

    private String stuSex;

    private String stuBirth;

    //班级编号
    private Long classId;

    //院系编号
    private Long departmentId;

    //籍贯
    private String nativePlace;

}
