package com.example.student_gl_houduan.dao;

import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import com.example.student_gl_houduan.model.UserStuSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SjkMysqlDao {
    //登录查询
    UserStu login(@Param("userstu") UserStu userstu);
    //注册_数据写入
    int signup(@Param("userstu") UserStu userstu);
    //学生信息添加
    int studentInto(@Param("userstuinto") UserStuInto userstuinto);
    //查询学生信息
    List<UserStuSelect> stuSelect(@Param("userstuselect") UserStuSelect userstuselect);

}
