package com.example.back.common.handle;

import com.example.back.vo.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public Result BaseException(Exception e){
//        e.printStackTrace();
//        return Result.fail(999, e.getMessage());
//    }

    @ExceptionHandler(MyException.class)
    public Result SelfException(MyException e){
        e.printStackTrace();
        return Result.fail(e);
    }
}
