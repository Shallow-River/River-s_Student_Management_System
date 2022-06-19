package com.example.back.controller;

import com.example.back.bo.ChangeAddBo;
import com.example.back.bo.PunishmentAddBo;
import com.example.back.bo.PunishmentEditBo;
import com.example.back.bo.RewardAddBo;
import com.example.back.service.OfficeService;
import com.example.back.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/main/office")
public class OfficeController {
    @Resource
    private OfficeService officeService;

    @PostMapping("/addChange")
    public Result addChange(@RequestBody ChangeAddBo bo){
        return Result.judge(officeService.addChange(bo));
    }

    @PostMapping("/addReward")
    public Result addReward(@RequestBody RewardAddBo bo){
        return Result.judge(officeService.addReward(bo));
    }

    @PostMapping("/addPunishment")
    public Result addPunishment(@RequestBody PunishmentAddBo bo){
        return Result.judge(officeService.addPunishment(bo));
    }

    @GetMapping("/getChangeById/{id}")
    public Result getChangeById(@PathVariable Long id){
        return Result.success(officeService.getChangeById(id));
    }

    @GetMapping("/getRewardById/{id}")
    public Result getRewardById(@PathVariable Long id){
        return Result.success(officeService.getRewardById(id));
    }

    @GetMapping("/getPunishmentById/{id}")
    public Result getPunishmentById(@PathVariable Long id){
        return Result.success(officeService.getPunishmentById(id));
    }

    @PutMapping("/editPunishmentById")
    public Result editPunishmentById(@RequestBody PunishmentEditBo bo){
        return Result.success(officeService.editPunishmentById(bo));
    }
}
