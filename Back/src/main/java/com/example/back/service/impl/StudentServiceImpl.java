package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.entity.Scores;
import com.example.back.entity.Student;
import com.example.back.mapper.*;
import com.example.back.service.StudentService;
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

    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Resource
    private XuejiMapper changeMapper;

    @Resource
    private RewardMapper rewardMapper;

    @Resource
    private PunishmentMapper punishmentMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ChangeCodeMapper changeCodeMapper;

    @Resource
    private RewardLevelsMapper rewardLevelsMapper;

    @Resource
    private PunishmentLevelsMapper punishmentLevelsMapper;

    @Resource
    private ClassMapper classMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(StudentAddBo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        schoolInfoMapper.addStudent((long)(studentMapper.selectCount(null) + 1));
        return studentMapper.insert(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        scoresMapper.delete(new QueryWrapper<Scores>().eq("student_id", id));
        return studentMapper.delete(new QueryWrapper<Student>().eq("student_id", id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(StudentEditbo bo) {
        Student student = BeanUtil.toBean(bo, Student.class);
        return studentMapper.update(student, new QueryWrapper<Student>().eq("student_id", bo.getStudentId()));
    }

    @Override
    public StudentVo selectById(Long id) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", id));
        StudentVo vo = new StudentVo();
        BeanUtils.copyProperties(student, vo);
        vo.setClassName(classMapper.selectById(student.getClassId()).getClassName());
        vo.setDepartment(departmentMapper.selectById(student.getDepartmentId()).getName());
        return vo;
    }

    @Override
    public List<StudentVo> selectByName(String name) {
        List<StudentVo> list = studentMapper.selectList(new QueryWrapper<Student>().like("stu_name", name)).stream().map(
                student -> {
                    StudentVo vo = new StudentVo();
                    BeanUtils.copyProperties(student, vo);
                    vo.setClassName(classMapper.selectById(student.getClassId()).getClassName());
                    vo.setDepartment(departmentMapper.selectById(student.getDepartmentId()).getName());
                    return vo;
                }
        ).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<StudentVo> init() {
        List<Student> students = studentMapper.selectAll();
        List<StudentVo> list = students.stream().map(
                student -> {
                    StudentVo vo = BeanUtil.toBean(student, StudentVo.class);
                    return vo;
                }
        ).collect(Collectors.toList());
        return list;
    }
}
