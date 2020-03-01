package addusers;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author evan
 */
public class getAgeByBirth {

    public static int getAgeByBirth(Date birthday) {
        long age = 0;
        long day = 0;

        Calendar now = Calendar.getInstance();

        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);

        if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
            age = 0;
        } else {

            day = (now.getTime().getTime() - birth.getTime().getTime()) / (24 * 60 * 60 * 1000);

            age = day / 365;
            
        }
        return (int) age;
    }
}
