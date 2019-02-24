package com.shpc.schoolapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String userid;
    private String username;
    @JsonIgnore
    private String userpassword;
    private String usertel;
    private String userlevel;
    private String usersex;
    private String userlastlogin;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserlastlogin() {
        return userlastlogin;
    }

    public void setUserlastlogin(String userlastlogin) {
        this.userlastlogin = userlastlogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", usertel='" + usertel + '\'' +
                ", userlevel='" + userlevel + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }
}
