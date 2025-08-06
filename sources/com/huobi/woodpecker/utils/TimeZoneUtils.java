package com.huobi.woodpecker.utils;

import com.adjust.sdk.Constants;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneUtils {
    public static String a() {
        String str;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            int offset = timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis());
            int parseInt = Integer.parseInt(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Math.abs(offset / Constants.ONE_HOUR))}));
            StringBuilder sb2 = new StringBuilder();
            if (offset >= 0) {
                str = "";
            } else {
                str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            sb2.append(str);
            sb2.append(parseInt);
            return sb2.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
