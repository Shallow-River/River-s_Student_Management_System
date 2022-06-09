package com.example.back.service.impl;

import com.example.back.entity.PieSchool;
import com.example.back.entity.SchoolInfo;
import com.example.back.mapper.SchoolInfoMapper;
import com.example.back.service.SchoolService;
import com.example.back.vo.SchoolInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public PieSchool infoList() {
        PieSchool pieSchool = new PieSchool();
        List<String> names = new ArrayList<>();
        List<SchoolInfoVo> values = new ArrayList<>();

        List<SchoolInfo> schoolInfos = schoolInfoMapper.selectList(null);

        for(SchoolInfo schoolInfo : schoolInfos){
            names.add(schoolInfo.getNames());
            SchoolInfoVo schoolInfoVo = new SchoolInfoVo();
            schoolInfoVo.setName(schoolInfo.getNames());
            schoolInfoVo.setValue(schoolInfo.getNum());
            values.add(schoolInfoVo);
        }
        pieSchool.setNames(names);
        pieSchool.setValues(values);
        return pieSchool;
    }
}
