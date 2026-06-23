package com.example.student_gl_houduan.model;

public class UserStuSelect {
    public String sid;
    public String sname;
    public Integer sage;
    public String ssex;
    public String ssion;

    public UserStuSelect() {
    }
    public UserStuSelect(String sid, String sname, Integer sage, String ssex, String ssion) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.ssion = ssion;
    }
}
