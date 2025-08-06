package zendesk.support.request;

import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

class UtilsDate {
    private UtilsDate() {
    }

    public static Date getBeginOfDay(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    private static Calendar getCalendar(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    private static Date getYesterday() {
        Calendar calendar = getCalendar(new Date());
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static boolean isSameDay(Date date, Date date2) {
        Calendar calendar = getCalendar(date);
        Calendar calendar2 = getCalendar(date2);
        boolean z11 = calendar.get(1) == calendar2.get(1);
        boolean z12 = calendar.get(2) == calendar2.get(2);
        boolean z13 = calendar.get(5) == calendar2.get(5);
        if (!z11 || !z12 || !z13) {
            return false;
        }
        return true;
    }

    public static boolean isToday(Date date) {
        return DateUtils.isToday(date.getTime());
    }

    public static boolean isYesterday(Date date) {
        return isSameDay(date, getYesterday());
    }
}
