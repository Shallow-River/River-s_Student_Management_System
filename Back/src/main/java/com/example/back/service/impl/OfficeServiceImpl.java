package com.example.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.back.bo.ChangeAddBo;
import com.example.back.bo.PunishmentAddBo;
import com.example.back.bo.PunishmentEditBo;
import com.example.back.bo.RewardAddBo;
import com.example.back.entity.*;
import com.example.back.mapper.*;
import com.example.back.service.OfficeService;
import com.example.back.vo.ChangeVo;
import com.example.back.vo.PunishmentVo;
import com.example.back.vo.RewardVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ChangeMapper changeMapper;

    @Resource
    private PunishmentMapper punishmentMapper;

    @Resource
    private RewardMapper rewardMapper;


    @Resource
    private RewardLevelsMapper rewardLevelsMapper;

    @Resource
    private ChangeCodeMapper changeCodeMapper;

    @Resource
    private PunishmentLevelsMapper punishmentLevelsMapper;

    @Override
    public int addChange(ChangeAddBo bo) {

        Change change = BeanUtil.toBean(bo, Change.class);
        int result = changeMapper.insert(change);

        return result;
    }

    @Override
    public int addReward(RewardAddBo bo) {

        Reward reward = BeanUtil.toBean(bo, Reward.class);
        int result = rewardMapper.insert(reward);

        return result;
    }

    @Override
    public int addPunishment(PunishmentAddBo bo) {

        Punishment punishment = BeanUtil.toBean(bo, Punishment.class);
        int result = punishmentMapper.insert(punishment);

        return result;
    }

    @Override
    public List<ChangeVo> getChangeById(Long id) {
        List<Change> list = changeMapper.selectList(new QueryWrapper<Change>().eq("student_id", id));

        List<ChangeVo> changeVoList = list.stream().map(
                change -> {
                    ChangeVo vo = BeanUtil.toBean(change, ChangeVo.class);
                    vo.setStudentName(studentMapper.selectById(change.getStudentId()).getStuName());
                    vo.setChangeDescription(changeCodeMapper.selectOne(new QueryWrapper<ChangeCode>().eq("code", change.getChangeId())).getDescription());
                    return vo;
                }
        ).collect(Collectors.toList());

        return changeVoList;
    }

    @Override
    public List<RewardVo> getRewardById(Long id) {
        List<Reward> list = rewardMapper.selectList(new QueryWrapper<Reward>().eq("student_id", id));

        List<RewardVo> rewardVoList = list.stream().map(
                reward -> {
                    RewardVo vo = BeanUtil.toBean(reward, RewardVo.class);
                    vo.setStudentName(studentMapper.selectById(reward.getStudentId()).getStuName());
                    vo.setRewardDescription(rewardLevelsMapper.selectOne(new QueryWrapper<RewardLevels>().eq("code", reward.getLevels())).getDescription());
                    return vo;
                }
        ).collect(Collectors.toList());

        return rewardVoList;
    }

    @Override
    public List<PunishmentVo> getPunishmentById(Long id) {
        List<Punishment> list = punishmentMapper.selectList(new QueryWrapper<Punishment>().eq("student_id", id));

        List<PunishmentVo> punishmentVoList = list.stream().map(
                punishment -> {
                    PunishmentVo vo = BeanUtil.toBean(punishment, PunishmentVo.class);
                    vo.setStudentName(studentMapper.selectById(punishment.getStudentId()).getStuName());
                    vo.setPunishmentDescription(punishmentLevelsMapper.selectOne(new QueryWrapper<PunishLevels>().eq("code", punishment.getLevels())).getDescription());
                    return vo;
                }
        ).collect(Collectors.toList());

        return punishmentVoList;
    }

    @Override
    public int editPunishmentById(PunishmentEditBo bo) {
        Punishment punishment = punishmentMapper.selectById(bo.getId());
        punishment.setEnable(bo.getEnable());
        int result =  punishmentMapper.update(punishment, new QueryWrapper<Punishment>().eq("id", bo.getId()));
        return result;
    }


}
