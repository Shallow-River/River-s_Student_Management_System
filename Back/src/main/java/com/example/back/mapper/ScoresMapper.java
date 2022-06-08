package com.example.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.back.entity.Scores;
import com.example.back.vo.ScoresVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoresMapper extends BaseMapper<Scores> {
    List<Scores> selectListById(Long id);

    List<Scores> selectListByName(String name);

    List<Scores> selectListByClassName(String name);

    List<Scores> selectAll();
}
