package com.example.back.controller;

import com.example.back.entity.PieSchool;
import com.example.back.service.SchoolService;
import com.example.back.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/schoolInfo")
public class SchoolController {
    @Resource
    private SchoolService schoolService;

    @GetMapping("/pieSchool")
    public PieSchool getInfo(){
        return schoolService.infoList();
    }
}
