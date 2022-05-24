package com.example.back.controller;

import com.example.back.bo.ScoreAddBo;
import com.example.back.service.ScoreService;
import com.example.back.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/main")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @PostMapping("/addScore")
    public Result insert(@RequestBody ScoreAddBo bo){
        return scoreService.insert(bo);
    }

    @GetMapping("/search_id/{id}")
    public Result getById(@PathVariable Long id){
        return scoreService.selectById(id);
    }
}
