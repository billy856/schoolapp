package com.shpc.schoolapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class Xinwenlist {
    @Id
    private String newid;
    private String newtitle;
    private String newdate;


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
}
