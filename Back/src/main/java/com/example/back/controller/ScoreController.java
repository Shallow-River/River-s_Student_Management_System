package com.example.back.controller;

import com.example.back.bo.ScoreAddBo;
import com.example.back.service.ScoreService;
import com.example.back.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/main/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @PostMapping("/addScore")
    public Result insert(@RequestBody ScoreAddBo bo) throws Exception{
        return Result.judge(scoreService.insert(bo));
    }

    @GetMapping("/searchById/{id}")
    public Result selectById(@PathVariable Long id) throws Exception{
        return Result.success(scoreService.selectById(id));
    }

    @GetMapping("/searchByName/{name}")
    public Result selectByName(@PathVariable String name) throws Exception{
        return Result.success(scoreService.selectByName(name));
    }

    @GetMapping("/createClassReport/{className}")
    public Result createClassReport(@PathVariable String className) throws Exception{
        return Result.success(scoreService.createClassReport(className));
    }

    @GetMapping("/countAvgScores/{className}")
    public Result countAvgScores(@PathVariable String className) throws Exception{
        return Result.success(scoreService.countAvgScores(className));
    }
}
