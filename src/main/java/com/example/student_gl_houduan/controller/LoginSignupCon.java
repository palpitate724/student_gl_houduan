package com.example.student_gl_houduan.controller;



import com.example.student_gl_houduan.model.UserFanKui;
import com.example.student_gl_houduan.model.UserStu;
import com.example.student_gl_houduan.model.UserStuInto;
import com.example.student_gl_houduan.service.LoginSignupSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginSignupCon {

    @Autowired
    public  LoginSignupSer loginSignupSer;

    @RequestMapping("/login")//登录
    public UserFanKui loginCon(@RequestBody(required = false) UserStu userstu){
        return loginSignupSer.loginSer(userstu);
    }
    @RequestMapping("/signup")// 注册
    public UserFanKui signupCon(@RequestBody(required = false) UserStu userstu){
        return loginSignupSer.signupSer(userstu);
    }


    @RequestMapping("/studentinto")//学生信息添加
    public UserFanKui studentIntoCon(@RequestBody UserStuInto userstuinto){
        return loginSignupSer.studentIntoSer(userstuinto);
    }


    @RequestMapping("/studenselect")//查询
    public UserFanKui studenselectCon(@RequestBody(required = false) UserStuInto userstuinto){
        return loginSignupSer.studentSelectSer(userstuinto);
    }
    @RequestMapping("/stuselectdel")//查询_软删除
    public UserFanKui stuSelectDelCon(){
        return loginSignupSer.stuSelectDelSer();
    }
    @GetMapping("/stuselfen")//分页查询
    public UserFanKui stuselFenCon(@RequestParam int ts,int shul){
        return loginSignupSer.stuSelFenSer(ts,shul);
    }


    @RequestMapping("/studentupdate")//修改
    public UserFanKui studentUpdateCon(@RequestBody(required = false) UserStuInto userstuinto){
        return loginSignupSer.studentUpdateSer(userstuinto);
    }


    @RequestMapping("/studentdelete")//删除
    public UserFanKui studentDeleteCon(@RequestBody(required = false) UserStuInto userstuinto){
        return loginSignupSer.studentDeleteSer(userstuinto);
    }
    @RequestMapping("/seldelhuifu")//恢复
    public UserFanKui seldelhuifuCon(@RequestBody(required = false) UserStuInto userstuinto){
        return loginSignupSer.studentDelHuiFuSer(userstuinto);
    }


    @RequestMapping("/stucount")//查询学生数量
    public UserFanKui stuCountCon(){
        return loginSignupSer.stuCountSer();
    }
}
