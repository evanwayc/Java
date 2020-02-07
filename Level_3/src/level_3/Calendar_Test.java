
package level_3;

import java.util.Calendar;
import java.util.Locale;

public class Calendar_Test {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.getCalendarType());
        //System.out.println(c.setTimeZone(Asia/Taipei));
    }
}
