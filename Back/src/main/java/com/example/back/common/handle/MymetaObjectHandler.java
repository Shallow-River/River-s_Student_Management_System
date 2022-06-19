package com.example.back.common.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MymetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject){
        this.setFieldValByName("recTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
