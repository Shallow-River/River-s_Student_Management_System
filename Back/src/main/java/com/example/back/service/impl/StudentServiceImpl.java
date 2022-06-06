package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.entity.Student;
import com.example.back.mapper.ScoresMapper;
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

    @Resource
    private ScoresMapper scoresMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(StudentAddBo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        return studentMapper.insert(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        scoresMapper.deleteById(id);
        return studentMapper.delete(new QueryWrapper<Student>().eq("id", id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(StudentEditbo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        return studentMapper.update(student, new QueryWrapper<Student>().eq("id", bo.getId()));
    }

    @Override
    public StudentVo selectById(Long id) {
        Student student = studentMapper.selectById(id);
        StudentVo vo = new StudentVo();
        BeanUtils.copyProperties(student, vo);
        return vo;
    }

    @Override
    public List<StudentVo> selectByName(String name) {
        List<StudentVo> list = studentMapper.selectList(new QueryWrapper<Student>().eq("stu_name", name)).stream().map(
                student -> {
                    StudentVo vo = new StudentVo();
                    BeanUtils.copyProperties(student, vo);
                    return vo;
                }
        ).collect(Collectors.toList());
        return list;
    }
}
