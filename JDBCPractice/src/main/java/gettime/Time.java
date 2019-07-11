package gettime;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public Long time = System.currentTimeMillis();
//    public Long time;
//
//    public Time() {
//        Date date = new Date();
//        this.time = date.getTime();
//    }

    public Long time1;
    public Time(Date date){
        this.time1=date.getTime();
    }

    public static void main(String[] args){
        Date date = new Date();
        Time t=new Time(new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(t.time);
        System.out.println(date.getTime());
        System.out.println(df.format(t.time1));
    }

}
