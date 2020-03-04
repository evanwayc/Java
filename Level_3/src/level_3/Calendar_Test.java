package level_3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar_Test {

    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);
        System.out.println(c1.getTime());
        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.getCalendarType());
        //System.out.println(c.setTimeZone(Asia/Taipei));
        Calendar c2 = Calendar.getInstance();
        c2.set(1989, 0, 14);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(format.format(c2.getTime()));
        
        Date d1 = c2.getTime();
        System.out.println(d1);
        long day = (Calendar.getInstance().getTime().getTime()-d1.getTime())/(24*60*60*1000);
        System.out.println(day/365);

    }
}
