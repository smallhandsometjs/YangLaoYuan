package com.shiro.YangLaoYuan.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.shiro.YangLaoYuan.utils.Utilsage;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@TableName("sys_oldman")
public class Oldman implements Serializable {

    private int id;
    private String name;
    private String sex;
    //private int age;
    private String st;
    private String hj;//户籍
    private String sfz;//身份证 //AA BB CC DDDD EE FF HH I J
    private String csny;//出生年月
    private String jjlxr;//紧急联系人
    private String  phone;//电话
    private String  adress;//地址

    public Bed getBed() {
        return bed;
    }

    public Hugong getHg() {
        return hg;
    }

    private Bed  bed;//床位
    private Hugong hg;

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public void setHg(Hugong hg) {
        this.hg = hg;
    }

    private Date rz;//入住时间
    private Date cy;//出院时间
    private String desc;//备注
    private String iscy;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getIscy() throws ParseException {
        if(cy!=null) {
            return cy.getTime() - new Date().getTime() > 0 ? "否" : "是";
        }
        return "否";
    }
    public void setIscy(String iscy)  {
       this.iscy=iscy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSfz() {
        return sfz;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return Utilsage.IdNOToAge(sfz);
    }


    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getHj() {
        return hj;
    }

    public void setHj(String hj) {
        this.hj = hj;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getCsny() {
        return  this.sfz.substring(6,12);
    }


    public String getJjlxr() {
        return jjlxr;
    }

    public void setJjlxr(String jjlxr) {
        this.jjlxr = jjlxr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }



    public Date getRz(){
        return rz;
    }

    public void setRz(Date rz) {
        this.rz = rz;
    }

    public Date getCy()  {
        return cy;
    }

    public void setCy(Date cy) {
        this.cy = cy;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Oldman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + getAge() +
                ", st='" + st + '\'' +
                ", hj='" + hj + '\'' +
                ", csny='" + csny + '\'' +
                ", jjlxr='" + jjlxr + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", bed_info" +  this.bed.getInfo()+ '\'' +
                ", bed_id" +  this.bed.getId()+ '\'' +
                ", hg_name" +  this.hg.getName()+ '\'' +
                ", hg_id" +  this.hg.getId()+ '\'' +
                ", iscy='" + iscy+ '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
