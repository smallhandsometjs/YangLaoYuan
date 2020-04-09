package com.shiro.YangLaoYuan.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilsage {

//获取年龄 根据身份证
    public static int IdNOToAge(String IdNO){
        if(IdNO!=null) {
            int leh = IdNO.length();
            String dates = "";
            if (leh == 18) {
                int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
                dates = IdNO.substring(6, 10);
                SimpleDateFormat df = new SimpleDateFormat("yyyy");
                String year = df.format(new Date());
                int u = Integer.parseInt(year) - Integer.parseInt(dates);
                return u;
            } else {
                dates = IdNO.substring(6, 8);
                return Integer.parseInt(dates);
            }
        }
        return 0;
    }


    public static String  getdqzq(Date date) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.setTime(date);
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        if(month<10){
            return year+"0"+month;
        }
         return year+""+month;
    }




}
