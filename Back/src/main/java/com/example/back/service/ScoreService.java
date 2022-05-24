package com.example.back.service;

import com.example.back.bo.ScoreAddBo;
import com.example.back.vo.Result;

public interface ScoreService {
    Result insert(ScoreAddBo bo);

    Result selectById(Long id);

    Result selectByName(String name);
}
