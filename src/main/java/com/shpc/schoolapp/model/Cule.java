package com.shpc.schoolapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cule")
public class Cule {
    @Id
    private String culeid;
    private String culedate;
    private String culeclass;
    private String culestatus;
    private String culedetail;

    private String culeuserid;
    private String culetitile;

    public String getCuletitile() {
        return culetitile;
    }

    public void setCuletitile(String culetitile) {
        this.culetitile = culetitile;
    }

    public String getCuleuserid() {
        return culeuserid;
    }

    public void setCuleuserid(String culeuserid) {
        this.culeuserid = culeuserid;
    }

    public String getCuleid() {
        return culeid;
    }

    public void setCuleid(String culeid) {
        this.culeid = culeid;
    }

    public String getCuledate() {
        return culedate;
    }

    public void setCuledate(String culedate) {
        this.culedate = culedate;
    }

    public String getCuleclass() {
        return culeclass;
    }

    public void setCuleclass(String culeclass) {
        this.culeclass = culeclass;
    }

    public String getCulestatus() {
        return culestatus;
    }

    public void setCulestatus(String culestatus) {
        this.culestatus = culestatus;
    }

    public String getCuledetail() {
        return culedetail;
    }

    public void setCuledetail(String culedetail) {
        this.culedetail = culedetail;
    }
}
