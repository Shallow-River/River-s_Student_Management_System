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
@RequestMapping("/main")
@CrossOrigin(originPatterns = "*")
public class StudentController {

    @Resource
    private StudentService studentService;

    @CrossOrigin(allowCredentials = "true")
    @PostMapping("/addStu")
    public Result add(@RequestBody StudentAddBo bo){
        return studentService.insert(bo);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestParam(value = "id") Long id){
        return studentService.delete(id);
    }

    @CrossOrigin(allowCredentials = "true")
    @PutMapping("/edit")
    public Result edit(@Validated @RequestBody StudentEditbo bo){
        return studentService.update(bo);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Long id){
        return studentService.selectById(id);
    }

    @GetMapping("/selectByName/{name}")
    public Result selectByName(@RequestParam(value = "name") String name){
        return studentService.selectByName(name);
    }
}
