package com.example.back.common;

public class StringConstant {
    public static final String PATTERN = "^[\\u4E00-\\u9FA5A-Za-z0-9\\,\\(\\)\\[\\]_\\\"\\'\\u2018\\u2019\\u201C\\u201D\\u3010\\u3011\\uFF08\\uFF09\\u3001\\uFF0C]+$";

    public static final String MESSAGE = "只能包括逗号、顿号、括号、引号、减号、下划线、汉字、数字、字母！";

    public static final String FAILURE_OF_SEARCH_ID = "查询失败！请检查学号输入是否有误或不存在该生成绩！";

    public static final String FAILURE_OF_SEARCH_NAME = "查询失败！请检查姓名输入是否有误或不存在该生成绩！";

    public static final String FAILURE_OF_CREATE_REPORT = "生成失败！请检查班级名称输入是否有误！";

    public static final String SUCCESS_OF_SEARCH = "查询成功！";
}
