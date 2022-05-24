package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.ScoreAddBo;
import com.example.back.entity.Scores;
import com.example.back.entity.Student;
import com.example.back.mapper.ScoresMapper;
import com.example.back.mapper.StudentMapper;
import com.example.back.service.ScoreService;
import com.example.back.vo.Result;
import com.example.back.vo.ScoresVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoresMapper scoresMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insert(ScoreAddBo bo) {
        Scores score = BeanUtil.toBean(bo, Scores.class);
        return Result.success(scoresMapper.insert(score));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result selectById(Long id) {
        ScoresVo vo = BeanUtil.toBean(scoresMapper.selectById(id), ScoresVo.class);
        vo.setStu_name(studentMapper.selectById(id).getStu_name());
        return Result.success(vo);
    }

    @Override
    public Result selectByName(String name) {
        return null;
    }
}
