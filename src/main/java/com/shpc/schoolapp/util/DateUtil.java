package com.shpc.schoolapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getUserDate(){
        Date date =new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return simpleDateFormat.format(date);
    }

    public static String getClueDateID(){
        Date date =new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(date);
    }

    public static String getCluseDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        return simpleDateFormat.format(date);
    }
}
