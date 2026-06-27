package com.example.student_gl_houduan.service;


import com.example.student_gl_houduan.dao.SjkMysqlDao;
import com.example.student_gl_houduan.model.UserFanKui;
import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
            System.out.println("login yes!"+userstu.sid+userstu.sname+userstu.spassword+userstu.sjiaose);
            return new UserFanKui(200,userstu);
        }
        else return new UserFanKui(409,null);

    }

    //注册
    public UserFanKui signupSer(UserStu userstu){
        int yz=sjkMysqlDao.signupyz(userstu);
        if( yz==0 ) return new UserFanKui(409,null);//用户已存在
        int st= sjkMysqlDao.signup(userstu);
        if(st==1)return new UserFanKui(200,null);//注册成功
        else return new UserFanKui(500,null);//注册失败
    }

    //学生信息添加
    public UserFanKui studentIntoSer(UserStuInto userstuinto){
        int del=sjkMysqlDao.studentIntoDel(userstuinto);
        if (del>0){
            int hf = sjkMysqlDao.studentDelHuiFu(userstuinto);
            if (hf>0) return new UserFanKui(200,null);
            else return new UserFanKui(500,null);
        }
        int cz=sjkMysqlDao.studentIntoYz(userstuinto);
        if (cz>0) return new UserFanKui(409,null);
        int into=sjkMysqlDao.studentInto(userstuinto);
        if (into>0)return new UserFanKui(200,null);
        else return new UserFanKui(500,null);
    }

    //查询
    public UserFanKui studentSelectSer(UserStuInto userstuinto){
        List<UserStuInto> userstuselects=sjkMysqlDao.stuSelect(userstuinto);
        if (userstuselects!=null){return new UserFanKui(200,userstuselects);}
        else{return new UserFanKui(409,null);}
    }
    //软删除查询
    public UserFanKui stuSelectDelSer(){
        List<UserStuInto> userstuselects=sjkMysqlDao.stuSelectDel();
        if (userstuselects!=null) return new UserFanKui(200,userstuselects);
        else return new UserFanKui(409,null);
    }

    //修改
    public UserFanKui studentUpdateSer(UserStuInto userstuinto){
        int update=sjkMysqlDao.studentUpdate(userstuinto);
        if (update>0)return new UserFanKui(200,null);
        else return new UserFanKui(500,null);
    }

    //删除
    public UserFanKui studentDeleteSer(UserStuInto userstuinto){
        int delete=sjkMysqlDao.studentDelete(userstuinto);
        if (delete>0)return new UserFanKui(200,null);
        else return new UserFanKui(500,null);
    }
    //恢复
    public UserFanKui studentDelHuiFuSer(UserStuInto userstuinto){
        int huiFu=sjkMysqlDao.studentDelHuiFu(userstuinto);
        if (huiFu>0)return new UserFanKui(200,null);
        else return new UserFanKui(500,null);
    }
}