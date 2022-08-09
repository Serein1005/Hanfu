package com.myapp.hanfu;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private String user;
    private String pwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
