package com.example.back.service;

import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.vo.Result;


public interface StudentService {

    Result insert(StudentAddBo bo);

    Result delete(Long id);

    Result update(StudentEditbo bo);

    Result selectById(Long id);

    Result selectByName(String name);
}
