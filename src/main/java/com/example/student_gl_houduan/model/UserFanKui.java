package com.example.student_gl_houduan.model;

public class UserFanKui {
    public int status;//200 yes / 409 用户不存在
    public  Object data;

    public UserFanKui() {
    }

    public UserFanKui(int status, Object data) {
        this.status = status;
        this.data=data;
    }
}
