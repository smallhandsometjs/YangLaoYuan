package com.shiro.YangLaoYuan.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.shiro.YangLaoYuan.utils.Utilsage;
@TableName("sys_hugong")
public class Hugong {
    private int id;
    private String name;
    private String sex;
    private String age;
    private String sfz;//身份证 //AA BB CC DDDD EE FF HH I J
    private String  phone;//电话
    private Float level;
    private int oldmancount;//照顾老人个数


    public Float getLevel() {
        return level;
    }

    public void setLevel(Float level) {
        this.level = level;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public String getSfz() {
        return sfz;
    }

    public int getAge() {
        return Utilsage.IdNOToAge(sfz);
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOldmancount() {
        return oldmancount;
    }

    public void setOldmancount(int oldmancount) {
        this.oldmancount = oldmancount;
    }

    @Override
    public String toString() {
        return "Hogong{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + getAge() + '\'' +
                ", sfz='" + sfz + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", oldmancount=" + oldmancount +
                '}';
    }
}
