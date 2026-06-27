package com.example.student_gl_houduan.dao;

import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SjkMysqlDao {
    //登录查询
    UserStu login(@Param("userstu") UserStu userstu);


    //注册_数据写入
    int signup(@Param("userstu") UserStu userstu);
    //注册_数据验证
    int signupyz(@Param("userstu") UserStu userstu);


    //学生信息添加
    int studentInto(@Param("userstuinto") UserStuInto userstuinto);
    //学生信息添加_软删除验证
    int studentIntoDel(@Param("userstuinto") UserStuInto userstuinto);
    //查询学生信息_存在验证
    int studentIntoYz(@Param("userstuinto") UserStuInto userstuinto);


    //查询学生信息
    List<UserStuInto> stuSelect(@Param("userstuinto") UserStuInto userstuinto);
    //学生信息修改
    int studentUpdate(@Param("userstuinto") UserStuInto userstuinto);
    //学生信息删除
    int studentDelete(@Param("userstuinto") UserStuInto userstuinto);
    //学生信息恢复
    int studentDelHuiFu(@Param("userstuinto") UserStuInto userstuinto);

}
