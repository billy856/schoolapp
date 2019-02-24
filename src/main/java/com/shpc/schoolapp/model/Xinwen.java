package com.shpc.schoolapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class Xinwen {
    @Id
    private String newid;
    private String newtitle;
    private String newdate;
    private String newauthorid;
    private String newdetail;
    private String newimage;

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
    }

    public String getNewtitle() {
        return newtitle;
    }

    public void setNewtitle(String newtitle) {
        this.newtitle = newtitle;
    }

    public String getNewdate() {
        return newdate;
    }

    public void setNewdate(String newdate) {
        this.newdate = newdate;
    }

    public String getNewauthorid() {
        return newauthorid;
    }

    public void setNewauthorid(String newauthorid) {
        this.newauthorid = newauthorid;
    }

    public String getNewdetail() {
        return newdetail;
    }

    public void setNewdetail(String newdetail) {
        this.newdetail = newdetail;
    }

    public String getNewimage() {
        return newimage;
    }

    public void setNewimage(String newimage) {
        this.newimage = newimage;
    }
}
