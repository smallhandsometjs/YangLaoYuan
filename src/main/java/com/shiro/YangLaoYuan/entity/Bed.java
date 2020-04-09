package com.shiro.YangLaoYuan.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
@TableName("sys_bed")
public class Bed  {
    private int id; //
    private int bed;
    private String isnull;//是否空闲
    private String info;//备注信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getIsnull() {
        return isnull;
    }

    public void setIsnull(String isnull) {
        this.isnull = isnull;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", bed=" + bed +
                ", isnull='" + isnull + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
