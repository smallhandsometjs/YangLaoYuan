package com.shiro.YangLaoYuan.entity;


import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
@TableName("sys_oldmanaccident")
public class OldmanAccident extends Oldman {

   private int id;//事故id
   private int oldmanid;//老人id

   private Date startdate;//事故时间
   private String info;//事故记录
   private String desc;//备用

    @Override
    public String toString() {
        return "OldmanAccident{" +
                "id=" + id +
                ", name='" + this.getName() + '\'' +
                ", oldmanid=" + oldmanid +
                ", startdate=" + startdate +
                ", info='" + info + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getOldmanid() {
        return oldmanid;
    }

    public void setOldmanid(int oldmanid) {
        this.oldmanid = oldmanid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
