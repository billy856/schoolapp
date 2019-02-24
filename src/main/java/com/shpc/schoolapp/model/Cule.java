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
    private String culetittle;
    private String culeimages;

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

    public String getCuleuserid() {
        return culeuserid;
    }

    public void setCuleuserid(String culeuserid) {
        this.culeuserid = culeuserid;
    }

    public String getCuletittle() {
        return culetittle;
    }

    public void setCuletittle(String culetittle) {
        this.culetittle = culetittle;
    }

    public String getCuleimages() {
        return culeimages;
    }

    public void setCuleimages(String culeimages) {
        this.culeimages = culeimages;
    }
}
