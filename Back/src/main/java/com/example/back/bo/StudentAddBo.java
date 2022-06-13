package com.example.back.bo;

import com.example.back.common.StringConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class StudentAddBo {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不可为空")
    @Size(min = 0, max = 20, message = "用户名长度不能超过20个字符")
    @Pattern(regexp = StringConstant.PATTERN, message = StringConstant.MESSAGE)
    private String stuName;

    private String stuSex;

    private String stuBirth;

    @NotBlank(message = "所属班级不可为空")
    private String className;

    //院系编号
    private Long departmentId;

    //籍贯
    private String nativePlace;
}
