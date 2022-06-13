package com.example.back.service;

import com.example.back.bo.ChangeAddBo;
import com.example.back.bo.PunishmentAddBo;
import com.example.back.bo.PunishmentEditBo;
import com.example.back.bo.RewardAddBo;
import com.example.back.vo.ChangeVo;
import com.example.back.vo.PunishmentVo;
import com.example.back.vo.RewardVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfficeService {
    int addChange(ChangeAddBo bo);

    int addReward(RewardAddBo bo);

    int addPunishment(PunishmentAddBo bo);

    List<ChangeVo> getChangeById(Long id);

    List<RewardVo> getRewardById(Long id);

    List<PunishmentVo> getPunishmentById(Long id);

    int editPunishmentById(PunishmentEditBo bo);
}
