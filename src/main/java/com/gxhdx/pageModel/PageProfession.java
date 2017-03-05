package com.gxhdx.pageModel;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/1/001.
 */
public class PageProfession {
    private Long id;
    private Date modifyDate;
    private  String professionName;

    private Long academy_id;
    private  String academyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Long getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(Long academy_id) {
        this.academy_id = academy_id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    @Override
    public String toString() {
        return "PageProfession{" +
                "id=" + id +
                ", modifyDate=" + modifyDate +
                ", professionName='" + professionName + '\'' +
                ", academy_id=" + academy_id +
                ", academyName='" + academyName + '\'' +
                '}';
    }
}
