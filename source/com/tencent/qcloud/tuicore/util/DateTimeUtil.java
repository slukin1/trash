package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    private static final long day = 86400000;
    private static final long hour = 3600000;
    private static final long minute = 60000;
    private static final long month = 2678400000L;
    private static final long week = 604800000;
    private static final long year = 32140800000L;

    public static String formatSeconds(long j11) {
        long j12 = j11;
        Context appContext = TUIConfig.getAppContext();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j12);
        int i11 = R.string.date_second_short;
        sb2.append(appContext.getString(i11));
        String sb3 = sb2.toString();
        if (j12 <= 60) {
            return sb3;
        }
        long j13 = j12 % 60;
        long j14 = j12 / 60;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(j14);
        int i12 = R.string.date_minute_short;
        sb4.append(appContext.getString(i12));
        sb4.append(j13);
        sb4.append(appContext.getString(i11));
        String sb5 = sb4.toString();
        if (j14 <= 60) {
            return sb5;
        }
        long j15 = j14 % 60;
        long j16 = j14 / 60;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(j16);
        int i13 = R.string.date_hour_short;
        sb6.append(appContext.getString(i13));
        sb6.append(j15);
        sb6.append(appContext.getString(i12));
        sb6.append(j13);
        sb6.append(appContext.getString(i11));
        String sb7 = sb6.toString();
        long j17 = j16 % 24;
        if (j17 == 0) {
            return (j16 / 24) + appContext.getString(R.string.date_day_short);
        } else if (j16 <= 24) {
            return sb7;
        } else {
            return (j16 / 24) + appContext.getString(R.string.date_day_short) + j17 + appContext.getString(i13) + j15 + appContext.getString(i12) + j13 + appContext.getString(i11);
        }
    }

    public static String formatSecondsTo00(int i11) {
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        int i12 = i11 % 60;
        int i13 = i11 / 60;
        if (i13 > 0) {
            int i14 = i13 % 60;
            int i15 = i13 / 60;
            if (i15 > 0) {
                StringBuilder sb6 = new StringBuilder();
                if (i15 >= 10) {
                    sb3.append(i15);
                    sb3.append("");
                } else {
                    sb3 = new StringBuilder();
                    sb3.append("0");
                    sb3.append(i15);
                }
                sb6.append(sb3.toString());
                sb6.append(":");
                if (i14 >= 10) {
                    sb4.append(i14);
                    sb4.append("");
                } else {
                    sb4 = new StringBuilder();
                    sb4.append("0");
                    sb4.append(i14);
                }
                sb6.append(sb4.toString());
                sb6.append(":");
                if (i12 >= 10) {
                    sb5.append(i12);
                    sb5.append("");
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("0");
                    sb5.append(i12);
                }
                sb6.append(sb5.toString());
                return sb6.toString();
            }
            StringBuilder sb7 = new StringBuilder();
            if (i14 >= 10) {
                sb2.append(i14);
                sb2.append("");
            } else {
                sb2 = new StringBuilder();
                sb2.append("0");
                sb2.append(i14);
            }
            sb7.append(sb2.toString());
            sb7.append(":");
            if (i12 >= 10) {
                str2 = i12 + "";
            } else {
                str2 = "0" + i12;
            }
            sb7.append(str2);
            return sb7.toString();
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("00:");
        if (i12 >= 10) {
            str = i12 + "";
        } else {
            str = "0" + i12;
        }
        sb8.append(str);
        return sb8.toString();
    }

    public static String getHMTimeString(Date date) {
        Locale locale;
        if (date == null) {
            return "";
        }
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            locale = Locale.getDefault();
        } else {
            locale = TUIThemeManager.getInstance().getLocale(appContext);
        }
        return String.format(locale, "%tR", new Object[]{date});
    }

    public static long getStringToDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
        return date.getTime();
    }

    public static String getTimeFormatText(Date date) {
        Locale locale;
        if (date == null) {
            return "";
        }
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            locale = Locale.getDefault();
        } else {
            locale = TUIThemeManager.getInstance().getLocale(appContext);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(7, 1);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        long timeInMillis2 = instance2.getTimeInMillis();
        Calendar instance3 = Calendar.getInstance();
        instance3.set(6, 1);
        instance3.set(11, 0);
        instance3.set(12, 0);
        instance3.set(13, 0);
        instance3.set(14, 0);
        long timeInMillis3 = instance3.getTimeInMillis();
        long time = date.getTime();
        if (time < timeInMillis3) {
            return String.format(locale, "%tD", new Object[]{date});
        } else if (time < timeInMillis2) {
            return String.format(locale, "%1$tm/%1$td", new Object[]{date});
        } else if (time < timeInMillis) {
            return String.format(locale, "%tA", new Object[]{date});
        } else {
            return String.format(locale, "%tR", new Object[]{date});
        }
    }

    public static String getTimeStringFromDate(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }
}
