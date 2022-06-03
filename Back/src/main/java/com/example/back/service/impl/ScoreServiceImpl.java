package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.ScoreAddBo;
import com.example.back.common.StringConstant;
import com.example.back.common.handle.MyException;
import com.example.back.entity.ClassReport;
import com.example.back.entity.Scores;
import com.example.back.entity.Student;
import com.example.back.mapper.ScoresMapper;
import com.example.back.mapper.StudentMapper;
import com.example.back.service.ScoreService;
import com.example.back.vo.Result;
import com.example.back.vo.ScoresVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoresMapper scoresMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ScoreAddBo bo) {
        Scores score = BeanUtil.toBean(bo, Scores.class);
        double sumScore = (bo.getEngScore() + bo.getPeScore() + bo.getJavaScore() + bo.getMathScore());
        score.setSumScore(sumScore);
        return scoresMapper.insert(score);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ScoresVo> selectById(Long id) {
        List<Scores> scores = scoresMapper.selectListById(id);
        if(scores.isEmpty()){
            throw new MyException(scores, StringConstant.FAILURE_OF_SEARCH_ID);
        }
        List<ScoresVo> list = scores.stream().map(e -> {
            Student student = studentMapper.selectById(e.getId());
            ScoresVo vo = BeanUtil.toBean(e, ScoresVo.class);
            vo.setStuName(student.getStuName());
            return vo;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ScoresVo> selectByName(String name) {
        List<Scores> scores = scoresMapper.selectListByName(name);

        if(scores.isEmpty()){
            throw new MyException(scores, StringConstant.FAILURE_OF_SEARCH_NAME);
        }

        List<ScoresVo> list = scores.stream().map(e -> {
            Student student = studentMapper.selectById(e.getId());
            ScoresVo vo = BeanUtil.toBean(e, ScoresVo.class);
            vo.setStuName(student.getStuName());
            return vo;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ScoresVo> createClassReport(String className) {
        List<Scores> scores = scoresMapper.selectListByClassName(className);

        if(scores.isEmpty()){
            throw new MyException(scores, StringConstant.FAILURE_OF_CREATE_REPORT);
        }

        List<ScoresVo> list = scores.stream().map(e -> {
            Student student = studentMapper.selectById(e.getId());
            ScoresVo vo = BeanUtil.toBean(e, ScoresVo.class);
            vo.setStuName(student.getStuName());
            return vo;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ClassReport> countAvgScores(String className) {
        ClassReport report = new ClassReport();
        List<ScoresVo> scores = createClassReport(className);

        for(ScoresVo vo : scores){
            report.add(vo.getMathScore(), vo.getJavaScore(), vo.getEngScore(), vo.getPeScore(), vo.getSumScore());
        }
        report.getAvg((double) scores.size());
        List<ClassReport> list = new ArrayList<>();
        list.add(report);
        return list;
    }
}
