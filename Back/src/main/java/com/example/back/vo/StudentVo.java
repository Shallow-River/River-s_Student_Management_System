package com.example.back.vo;

import lombok.Data;

@Data
public class StudentVo {

    private Long id;

    private String stuName;

    private String stuSex;

    private String stuBirth;

    private String className;

    //院系
    private String department;

    //籍贯
    private String nativePlace;


}
