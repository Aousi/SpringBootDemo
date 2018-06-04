package org.aousi.springboot.demo.Entities;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
public class toolssss {

    public Integer between2day(String start,String end){

        String[] startArr=start.split("-");
        String[] endArr=end.split("-");

        LocalDate begin = LocalDate.of(Integer.parseInt(startArr[0]),Integer.parseInt(startArr[1]),Integer.parseInt(startArr[2]));
        LocalDate end1 = LocalDate.of(Integer.parseInt(endArr[0]),Integer.parseInt(endArr[1]),Integer.parseInt(endArr[2]));
        int len = (int) (end1.toEpochDay()-begin.toEpochDay());

        return len;
    }

    public Calendar ClearCalendarWithTime(Date StartDate){
        Calendar c = Calendar.getInstance();
        c.setTime(StartDate);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);

        return c;
    }

    public String Date2Str(String pattern,Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String str = sdf.format(date);
        return str;
    }

    public Date Str2Date(String pattern,String str){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;

        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date setLimitTime(Date time,Integer hour){
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY,hour);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);

        return c.getTime();
    }

    public Date setLimitTime(Date time,Integer hour,Integer min){
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY,hour);
        c.set(Calendar.MINUTE,min);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);

        return c.getTime();
    }

}
