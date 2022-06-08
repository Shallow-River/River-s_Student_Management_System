package com.example.back.controller;

import com.example.back.bo.StudentAddBo;
import com.example.back.bo.StudentEditbo;
import com.example.back.mapper.StudentMapper;
import com.example.back.service.StudentService;
import com.example.back.vo.Result;
import com.example.back.vo.StudentVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/main/stu")
//@CrossOrigin(originPatterns = "*")
public class StudentController {

    @Resource
    private StudentService studentService;

//    @CrossOrigin(allowCredentials = "true")
    @PostMapping("/addStu")
    public Result add(@RequestBody StudentAddBo bo){
        return Result.judge(studentService.insert(bo));
    }

    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return Result.judge(studentService.delete(id));
    }

//    @CrossOrigin(allowCredentials = "true")
    @PutMapping("/edit")
    public Result edit(@Validated @RequestBody StudentEditbo bo){
        return Result.judge(studentService.update(bo));
    }

    @GetMapping("/search_id/{id}")
    public Result selectById(@PathVariable Long id){
        return Result.success(studentService.selectById(id));
    }

    @GetMapping("/search_name/{name}")
    public Result selectByName(@PathVariable String name){
        return Result.success(studentService.selectByName(name));
    }

    @GetMapping("/init")
    public Result initStudents() throws Exception{
        return Result.success(studentService.init());
    }
}
