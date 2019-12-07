package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Date date = new Date();
        long time = System.currentTimeMillis();
        long time1 = date.getTime();
        System.out.println(time+"   "+time1);
        System.out.println(date);

        String s = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);
        System.out.println(simpleDateFormat.format(date));
    }
}
