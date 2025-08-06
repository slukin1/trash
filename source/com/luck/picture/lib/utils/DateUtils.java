package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.luck.picture.lib.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM");
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SDF_YEAR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SF = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String cdTime(long j11, long j12) {
        long j13 = j12 - j11;
        if (j13 > 1000) {
            return (j13 / 1000) + "秒";
        }
        return j13 + "毫秒";
    }

    public static int dateDiffer(long j11) {
        try {
            return (int) Math.abs(getCurrentTimeMillis() - j11);
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j11) {
        String str = j11 < 0 ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : "";
        long abs = Math.abs(j11) / 1000;
        long j12 = abs % 60;
        long j13 = (abs / 60) % 60;
        long j14 = abs / 3600;
        if (j14 > 0) {
            return String.format(Locale.getDefault(), "%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)});
        }
        return String.format(Locale.getDefault(), "%s%02d:%02d", new Object[]{str, Long.valueOf(j13), Long.valueOf(j12)});
    }

    public static String getCreateFileName(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return str + SF.format(Long.valueOf(currentTimeMillis));
    }

    public static long getCurrentTimeMillis() {
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        if (valueOf.length() > 10) {
            valueOf = valueOf.substring(0, 10);
        }
        return ValueOf.toLong(valueOf);
    }

    public static String getDataFormat(Context context, long j11) {
        if (String.valueOf(j11).length() <= 10) {
            j11 *= 1000;
        }
        if (isThisWeek(j11)) {
            return context.getString(R.string.ps_current_week);
        }
        if (isThisMonth(j11)) {
            return context.getString(R.string.ps_current_month);
        }
        return SDF.format(Long.valueOf(j11));
    }

    public static String getYearDataFormat(long j11) {
        if (String.valueOf(j11).length() <= 10) {
            j11 *= 1000;
        }
        return SDF_YEAR.format(Long.valueOf(j11));
    }

    public static boolean isThisMonth(long j11) {
        Date date = new Date(j11);
        SimpleDateFormat simpleDateFormat = SDF;
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }

    private static boolean isThisWeek(long j11) {
        Calendar instance = Calendar.getInstance();
        int i11 = instance.get(3);
        instance.setTime(new Date(j11));
        return instance.get(3) == i11;
    }

    public static long millisecondToSecond(long j11) {
        return (j11 / 1000) * 1000;
    }

    public static String getCreateFileName() {
        return SF.format(Long.valueOf(System.currentTimeMillis()));
    }
}
