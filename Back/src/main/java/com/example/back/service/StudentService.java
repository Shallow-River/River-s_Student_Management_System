package com.example.back.service;

import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.vo.Result;
import com.example.back.vo.StudentVo;

import java.util.List;


public interface StudentService {

    int insert(StudentAddBo bo);

    int delete(Long id);

    int update(StudentEditbo bo);

    StudentVo selectById(Long id);

    List<StudentVo> selectByName(String name);
}
