package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static java.sql.Timestamp util2sql (java.util.Date d){
        return new java.sql.Timestamp(d.getTime());
    }

    public static Date now(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.getTime();
    }

    public static void main(String[] args) {
        new DateUtil();
        System.out.println(now());
    }
}
