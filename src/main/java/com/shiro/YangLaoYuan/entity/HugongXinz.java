package com.shiro.YangLaoYuan.entity;

import java.util.Date;

public class HugongXinz extends Hugong{

    private int id; //
    private int hugongid; //护工主键
    private int yingfa; //应发费用
    private int yifa; //已发费用
    private String isshoudao;//是否收到
    private String info;//备注信息
    private Date ffrq;//发放日期

    @Override
    public String toString() {
        return "HugongXinz{" +
                "id=" + id +
                ", hugongid=" + hugongid +
                ", yingfa=" + yingfa +
                ", yifa=" + yifa +
                ", isshoudao='" + isshoudao + '\'' +
                ", info='" + info + '\'' +
                ", ffrq=" + ffrq +
                ", qjcont=" + qjcont +
                '}';
    }

    public int getQjcont() {
        return qjcont;
    }

    public void setQjcont(int qjcont) {
        this.qjcont = qjcont;
    }

    private int qjcont;//请假次数

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

    public int getYingfa() {
        return yingfa;
    }

    public void setYingfa(int yingfa) {
        this.yingfa = yingfa;
    }

    public int getYifa() {
        return yifa;
    }

    public void setYifa(int yifa) {
        this.yifa = yifa;
    }

    public String getIsshoudao() {
        return isshoudao;
    }

    public void setIsshoudao(String isshoudao) {
        this.isshoudao = isshoudao;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getFfrq() {
        return ffrq;
    }

    public void setFfrq(Date ffrq) {
        this.ffrq = ffrq;
    }
}
