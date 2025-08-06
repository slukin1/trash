package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeUtils {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    private static Map<String, ThreadLocal<SimpleDateFormat>> formatMaps = new HashMap();

    public static double duration(long j11, long j12) {
        long j13 = j12 - j11;
        if (j13 >= 0 && j13 <= Period.DAY_MILLS) {
            float f11 = ((float) j13) / 1000.0f;
            try {
                return Double.parseDouble(String.format(Locale.CHINA, "%.3f", new Object[]{Float.valueOf(f11)}));
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
        return 0.0d;
    }

    public static String formatDate(Date date) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS);
    }

    public static String formatTime(long j11) {
        return formatTime(j11, Locale.CHINA);
    }

    private static synchronized SimpleDateFormat getDateFormat(final String str, final Locale locale) {
        SimpleDateFormat simpleDateFormat;
        synchronized (TimeUtils.class) {
            Map<String, ThreadLocal<SimpleDateFormat>> map = formatMaps;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_");
            sb2.append(locale == null ? Locale.CHINA.getCountry() : locale.getCountry());
            ThreadLocal threadLocal = map.get(sb2.toString());
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<SimpleDateFormat>() {
                    public SimpleDateFormat initialValue() {
                        try {
                            if (locale == null) {
                                return new SimpleDateFormat(str, Locale.CHINA);
                            }
                            return new SimpleDateFormat(str, locale);
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                            return null;
                        }
                    }
                };
                if (threadLocal.get() != null) {
                    Map<String, ThreadLocal<SimpleDateFormat>> map2 = formatMaps;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("_");
                    sb3.append(locale == null ? Locale.CHINA.getCountry() : locale.getCountry());
                    map2.put(sb3.toString(), threadLocal);
                }
            }
            simpleDateFormat = (SimpleDateFormat) threadLocal.get();
        }
        return simpleDateFormat;
    }

    public static Integer getZoneOffset() {
        try {
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            return Integer.valueOf((-(instance.get(15) + instance.get(16))) / 60000);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public static boolean isDateValid(Date date) {
        try {
            return date.after(getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, Locale.CHINA).parse("2015-05-15 10:24:00.000"));
        } catch (ParseException e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public static String formatDate(Date date, String str) {
        return formatDate(date, str, Locale.CHINA);
    }

    public static String formatTime(long j11, String str) {
        return formatTime(j11, str, Locale.CHINA);
    }

    public static String formatDate(Date date, Locale locale) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS, locale);
    }

    public static String formatTime(long j11, Locale locale) {
        return formatTime(j11, (String) null, locale);
    }

    public static String formatDate(Date date, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(date);
        } catch (IllegalArgumentException e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public static String formatTime(long j11, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(Long.valueOf(j11));
        } catch (IllegalArgumentException e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public static boolean isDateValid(long j11) {
        try {
            Date parse = getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, Locale.CHINA).parse("2015-05-15 10:24:00.000");
            if (parse != null && parse.getTime() < j11) {
                return true;
            }
            return false;
        } catch (ParseException e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public static JSONObject formatDate(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject.put(next, formatDate((Date) obj, Locale.CHINA));
                }
            }
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
        return jSONObject;
    }
}
