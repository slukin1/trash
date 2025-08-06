package com.engagelab.privates.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtil {
    public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";
    private static final Object lock = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        public String f64983a;

        public a(String str) {
            this.f64983a = str;
        }

        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f64983a, Locale.ENGLISH);
        }
    }

    public static SimpleDateFormat getSdf(String str) {
        ThreadLocal threadLocal = sdfMap.get(str);
        if (threadLocal == null) {
            synchronized (lock) {
                threadLocal = sdfMap.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    sdfMap.put(str, threadLocal);
                }
            }
        }
        return (SimpleDateFormat) threadLocal.get();
    }

    public static String getTodayDateTime() {
        return getSdf("yyyyMMddHHmmss").format(new Date());
    }

    public static String getTodayDateTimeForFilename() {
        return getSdf(PATTERN_DATETIME_FILENAME).format(new Date());
    }

    public static String getTodayDateTimeForReport() {
        return getSdf("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static boolean isDaysAgo(Date date, int i11) {
        if (date == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(date.getTime());
        instance.roll(6, -i11);
        return instance.after(instance2);
    }

    public static Date parseDateInFilename(String str) {
        try {
            return getSdf(PATTERN_DATETIME_FILENAME).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
