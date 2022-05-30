package com.example.back.common.handle;

public class MyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private Object data;

    public MyException(){}

    public MyException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public MyException(Object data, String msg){
        this.data = data;
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

    public Object getData(){
        return data;
    }
}
