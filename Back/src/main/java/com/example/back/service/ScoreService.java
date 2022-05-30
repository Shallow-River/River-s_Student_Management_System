package com.example.back.service;

import com.example.back.bo.ScoreAddBo;
import com.example.back.vo.Result;
import com.example.back.vo.ScoresVo;

import java.util.List;

public interface ScoreService {
    int insert(ScoreAddBo bo);

    List<ScoresVo> selectById(Long id);

    List<ScoresVo> selectByName(String name);
}
