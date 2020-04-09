package com.shiro.YangLaoYuan.entity;

import java.util.Date;

public class Oldmanfy extends Oldman{
    private int id; //
    private int oldmanid; //老人主键
    private int yingshou; //应收费用

    private int yishou; //已收费用
    private String isshoudao;//是否收到
    private String info;//备注信息
    private Date jfrq;//缴费日期


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

    public int getYingshou() {
        return yingshou;
    }

    public void setYingshou(int yingshou) {
        this.yingshou = yingshou;
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

    public Date getJfrq() {
        return jfrq;
    }

    public void setJfrq(Date jfrq) {
        this.jfrq = jfrq;
    }


    public int getYishou() {
        return yishou;
    }

    public void setYishou(int yishou) {
        this.yishou = yishou;
    }

    @Override
    public String toString() {
        return "Oldmanfy{" +
                "id=" + id +
                ", oldmanid=" + oldmanid +
                ", yingshou=" + yingshou +
                ", yishou=" + yishou +
                ", isshoudao='" + isshoudao + '\'' +
                ", info='" + info + '\'' +
                ", jfrq=" + jfrq +
                '}';
    }
}
