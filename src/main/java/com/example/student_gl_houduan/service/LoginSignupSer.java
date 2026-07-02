package com.example.student_gl_houduan.service;


import com.example.student_gl_houduan.dao.SjkMysqlDao;
import com.example.student_gl_houduan.model.UserFanKui;
import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Component
public class LoginSignupSer {

    @Autowired
    SjkMysqlDao sjkMysqlDao;

    //登录
    public UserFanKui loginSer(UserStu userstu){
        //200/yes 409/用户不存在
        userstu = sjkMysqlDao.login(userstu);
        if (userstu!=null){
            log.info("{} 登录成功",userstu.sid);
            return new UserFanKui(200,userstu);
        }
        else {
            log.info("{} 登录失败，用户不存在",userstu.sid);
            return new UserFanKui(409, null);
        }

    }

    //注册
    public UserFanKui signupSer(UserStu userstu){
        int yz=sjkMysqlDao.signupyz(userstu);
        if( yz==0 ) {
            log.info("{} 注册失败，用户已存在",userstu.sid);
            return new UserFanKui(409, null);//用户已存在
        }
        int st= sjkMysqlDao.signup(userstu);
        if(st==1) {
            log.info("{} 注册成功",userstu.sid);
            return new UserFanKui(200, null);//注册成功
        }
        else {
            log.info("{} 注册失败，服务器原因",userstu.sid);
            return new UserFanKui(500, null);//注册失败
        }
    }

    //学生信息添加
    public UserFanKui studentIntoSer(UserStuInto userstuinto){
        int del=sjkMysqlDao.studentIntoDel(userstuinto);
        if (del>0){
            int hf = sjkMysqlDao.studentDelHuiFu(userstuinto);
            if (hf>0) {
                log.info("{} 添加成功",userstuinto.sid);
                return new UserFanKui(200, null);
            }
            else {
                log.info("{} 添加失败，服务器原因",userstuinto.sid);
                return new UserFanKui(500, null);
            }
        }
        int cz=sjkMysqlDao.studentIntoYz(userstuinto);
        if (cz>0) {
            log.info("{} 添加失败，信息已存在",userstuinto.sid);
            return new UserFanKui(409, null);
        }
        int into=sjkMysqlDao.studentInto(userstuinto);
        if (into>0) {
            log.info("{} 添加成功",userstuinto.sid);
            return new UserFanKui(200, null);
        }
        else {
            log.info("{} 添加失败，服务器原因",userstuinto.sid);
            return new UserFanKui(500, null);
        }
    }

    //查询
    public UserFanKui studentSelectSer(UserStuInto userstuinto){
        List<UserStuInto> userstuselects=sjkMysqlDao.stuSelect(userstuinto);
        if (userstuselects!=null){
            log.info("{} 查询成功",userstuinto.sid);
            return new UserFanKui(200,userstuselects);
        }
        else{
            log.info("{} 查询失败，信息不存在",userstuinto.sid);
            return new UserFanKui(409,null);
        }
    }
    //软删除查询
    public UserFanKui stuSelectDelSer(){
        List<UserStuInto> userstuselects=sjkMysqlDao.stuSelectDel();
        if (userstuselects!=null) {
            log.info("查询成功");
            return new UserFanKui(200, userstuselects);
        }
        else {
            log.info("查询失败，无删除信息");
            return new UserFanKui(409, null);
        }
    }
    //分页查询
    public UserFanKui stuSelFenSer(int ts,int shul){
        List<UserStuInto> userstuselects=sjkMysqlDao.stuSelFen((ts-1)*shul,shul);
        if (userstuselects!=null) {
            log.info("分页查询成功");
            return new UserFanKui(200, userstuselects);
        }
        else {
            log.info("分页查询失败，无信息");
            return new UserFanKui(409, null);
        }
    }

    //修改
    public UserFanKui studentUpdateSer(UserStuInto userstuinto){
        int update=sjkMysqlDao.studentUpdate(userstuinto);
        if (update>0) {
            log.info("{} 修改成功",userstuinto.sid);
            return new UserFanKui(200, null);
        }
        else {
            log.info("{} 修改失败，服务器原因",userstuinto.sid);
            return new UserFanKui(500, null);
        }
    }

    //删除
    public UserFanKui studentDeleteSer(UserStuInto userstuinto){
        int delete=sjkMysqlDao.studentDelete(userstuinto);
        if (delete>0) {
            log.info("{} 删除成功",userstuinto.sid);
            return new UserFanKui(200, null);
        }
        else {
            log.info("{} 删除失败，服务器原因",userstuinto.sid);
            return new UserFanKui(500, null);
        }
    }
    //恢复
    public UserFanKui studentDelHuiFuSer(UserStuInto userstuinto){
        int huiFu=sjkMysqlDao.studentDelHuiFu(userstuinto);
        if (huiFu>0) {
            log.info("{} 恢复成功",userstuinto.sid);
            return new UserFanKui(200, null);
        }
        else {
            log.info("{} 恢复失败，服务器原因",userstuinto.sid);
            return new UserFanKui(500, null);
        }
    }


    //查询学生信息记录数量
    public UserFanKui stuCountSer(){
        int count=sjkMysqlDao.stuCount();
        return new UserFanKui(200,count);

    }
}