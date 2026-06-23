package com.example.student_gl_houduan.controller;



import com.example.student_gl_houduan.model.UserFanKui;
import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import com.example.student_gl_houduan.model.UserStuSelect;
import com.example.student_gl_houduan.service.LoginSignupSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginSignupCon {

    @Autowired
    public  LoginSignupSer loginSignupSer;

    @RequestMapping("/login")//登录
    public UserFanKui loginCon(@RequestBody(required = false) UserStu userstu){return loginSignupSer.loginSer(userstu);}

    @RequestMapping("/signup")// 注册
    public UserFanKui signupCon(@RequestBody(required = false) UserStu userstu){return loginSignupSer.signupSer(userstu);}

    @RequestMapping("/studentInto")//学生信息添加
    public UserFanKui studentIntoCon(@RequestBody UserStuInto userstuinto){
        System.out.println("sid  "+userstuinto.sid+"  sname  "+userstuinto.sname+"  sage  "+userstuinto.sage+"  ssex  "+userstuinto.ssex+" ssion "+userstuinto.ssion);

        return loginSignupSer.studentIntoSer(userstuinto);
    }

    @RequestMapping("/studenselect")//查询
    public UserFanKui studenselectCon(@RequestBody(required = false) UserStuSelect userstuselect){
        return loginSignupSer.studentSelectSer(userstuselect);
    }


}
