package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.entity.Student;
import com.example.back.mapper.StudentMapper;
import com.example.back.service.StudentService;
import com.example.back.vo.Result;
import com.example.back.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insert(StudentAddBo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        return Result.success(studentMapper.insert(student));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(Long id) {
        return Result.success(studentMapper.delete(new QueryWrapper<Student>().eq("id", id)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(StudentEditbo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        return Result.success(studentMapper.update(student, new QueryWrapper<Student>().eq("id", bo.getId())));
    }

    @Override
    public Result selectById(Long id) {
        Student student = studentMapper.selectById(id);
        StudentVo vo = new StudentVo();
        BeanUtils.copyProperties(vo, student);
        return Result.success(vo);
    }

    @Override
    public Result selectByName(String name) {
        List<StudentVo> list = studentMapper.selectList(new QueryWrapper<Student>().like("stu_name", name)).stream().map(
                student -> {
                    StudentVo vo = new StudentVo();
                    BeanUtils.copyProperties(vo, student);
                    return vo;
                }
        ).collect(Collectors.toList());
        return Result.success(list);
    }
}
