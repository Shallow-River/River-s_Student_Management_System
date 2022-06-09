package com.example.back.entity;

import com.example.back.vo.SchoolInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class PieSchool {
    List<String> names;
    List<SchoolInfoVo> values;
}
