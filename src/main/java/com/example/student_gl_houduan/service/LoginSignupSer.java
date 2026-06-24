package com.example.student_gl_houduan.service;


import com.example.student_gl_houduan.dao.SjkMysqlDao;
import com.example.student_gl_houduan.model.UserFanKui;
import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import com.example.student_gl_houduan.model.UserStuSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class LoginSignupSer {

    @Autowired
    SjkMysqlDao sjkMysqlDao;
    UserStu userstu;
    UserStuSelect userstuselect;
    UserFanKui userfankui;

    //登录
    public UserFanKui loginSer(UserStu userstu){

        userstu = sjkMysqlDao.login(userstu);
        if (userstu!=null){
            System.out.println("login yes!");
            return new UserFanKui(200,userstu);
        }
        else{
            return new UserFanKui(409,null);
        }
    }

    //注册
    public UserFanKui signupSer(UserStu userstu){
        boolean yz=sjkMysqlDao.login(userstu)!=null;
        if(yz) {return new UserFanKui(409,null);//用户已存在
        }
        int st= sjkMysqlDao.signup(userstu);
        if(st==1){return new UserFanKui(200,null);//注册成功
        }
        else return new UserFanKui(500,null);//注册失败
    }

    //学生信息添加
    public UserFanKui studentIntoSer(UserStuInto userstuinto){

        int into=sjkMysqlDao.studentInto(userstuinto);
        if (into>0)return new UserFanKui(200,null);
        else return new UserFanKui(500,null);
    }

    //查询
    public UserFanKui studentSelectSer(UserStuSelect userstuselect){
        List<UserStuSelect> userstuselects=sjkMysqlDao.stuSelect(userstuselect);
        if (userstuselects!=null){
            return new UserFanKui(200,userstuselects);
        }
        else{
            return new UserFanKui(409,null);
        }
    }
}