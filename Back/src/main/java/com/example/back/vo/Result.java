package com.example.back.vo;

import com.example.back.common.StringConstant;
import com.example.back.common.handle.MyException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public static Result success(){
        return new Result(true, 200, "操作成功！", null);
    }

    public static Result success(Object data){
        return new Result(true, 200, "操作成功！", data);
    }

    public static Result success(Object data, String msg){
        return new Result(true, 200, msg, data);
    }

//
//    public static Result search_success(Object data){
//        return new Result(true, 200, StringConstant.SUCCESS_OF_SEARCH, data);
//    }
//
//    public static Result search_fail(Object data){
//        return new Result(true, 200, StringConstant.FAILURE_OF_SEARCH, data);
//    }

    public static Result fail(int code, String msg){
        return new Result(false, code, msg, null);
    }

    public static Result fail(Object data, String msg){return new Result(false, 999, msg, data);}

    public static Result fail(){return new Result(false, 999, "操作失败！", null);}

    public static Result fail(MyException e){return new Result(false, 999, e.getMessage(), e.getData());}

    public static Result judge(int row, Object data, String msg){
        return row > 0 ? Result.success(data, msg) : Result.fail(data, msg);
    }

    public static Result judge(int row){
        return row > 0 ? Result.success() : Result.fail();
    }
}
