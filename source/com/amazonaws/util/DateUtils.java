package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class DateUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f15546a = TimeZone.getTimeZone("GMT");

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, ThreadLocal<SimpleDateFormat>> f15547b = new HashMap();

    public static Date b(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    public static String c(String str, Date date) {
        return e(str).get().format(date);
    }

    public static String d(Date date) {
        return c("EEE, dd MMM yyyy HH:mm:ss z", date);
    }

    public static ThreadLocal<SimpleDateFormat> e(final String str) {
        Map<String, ThreadLocal<SimpleDateFormat>> map = f15547b;
        ThreadLocal<SimpleDateFormat> threadLocal = map.get(str);
        if (threadLocal == null) {
            synchronized (map) {
                threadLocal = map.get(str);
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal<SimpleDateFormat>() {
                        /* renamed from: a */
                        public SimpleDateFormat initialValue() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
                            simpleDateFormat.setTimeZone(DateUtils.f15546a);
                            simpleDateFormat.setLenient(false);
                            return simpleDateFormat;
                        }
                    };
                    map.put(str, threadLocal);
                }
            }
        }
        return threadLocal;
    }

    public static Date f(String str, String str2) {
        try {
            return e(str).get().parse(str2);
        } catch (ParseException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static Date g(String str) {
        return f("yyyyMMdd'T'HHmmss'Z'", str);
    }

    public static Date h(String str) {
        try {
            return f("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", str);
        } catch (IllegalArgumentException unused) {
            return f("yyyy-MM-dd'T'HH:mm:ss'Z'", str);
        }
    }

    public static Date i(String str) {
        return f("EEE, dd MMM yyyy HH:mm:ss z", str);
    }
}
