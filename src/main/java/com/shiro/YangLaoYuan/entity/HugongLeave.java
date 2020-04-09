package com.shiro.YangLaoYuan.entity;


import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("sys_hugongleave")
public class HugongLeave extends Hugong {

    private int id;//事故id
    private int hugongid;//护工id
    private Date startdate;//开始时间
    private Date enddate;//结束时间
    private String info;//事故记录
    private String desc;//备用

    private int days;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getHugongid() {
        return hugongid;
    }

    public void setHugongid(int hugongid) {
        this.hugongid = hugongid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HugongLeave{" +
                "id=" + id +
                ", hugongid=" + hugongid +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", info='" + info + '\'' +
                ", desc='" + desc + '\'' +
                ", days=" + days +
                '}';
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
