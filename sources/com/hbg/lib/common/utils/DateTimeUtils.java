package com.hbg.lib.common.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.R$string;
import com.hbg.lib.network.pro.core.util.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtils {
    public static String A(long j11) {
        return h(j11, "HH:mm");
    }

    public static Date B(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(2, 1);
        instance.set(5, 0);
        return instance.getTime();
    }

    public static String C(long j11) {
        if (G(j11)) {
            return h(j11, "yyyy/MM/dd HH:mm");
        }
        return h(j11, "MM/dd HH:mm");
    }

    public static String D(long j11) {
        if (G(j11)) {
            return h(j11, "yyyy/MM/dd HH:mm:ss");
        }
        return h(j11, "MM/dd HH:mm:ss");
    }

    public static boolean E(long j11) {
        Calendar instance = Calendar.getInstance();
        int i11 = instance.get(1);
        instance.setTime(new Date(j11));
        if (i11 == instance.get(1)) {
            return true;
        }
        return false;
    }

    public static boolean F(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        if (instance2.get(1) - instance.get(1) == 0 && instance2.get(6) - instance.get(6) == 0) {
            return true;
        }
        return false;
    }

    public static boolean G(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        if (instance2.get(1) - instance.get(1) >= 1) {
            return true;
        }
        return false;
    }

    public static String H(long j11) {
        StringBuilder sb2 = new StringBuilder();
        long j12 = j11 / 86400;
        long j13 = j11 % 86400;
        long j14 = j13 / 3600;
        long j15 = j13 % 3600;
        long j16 = j15 / 60;
        long j17 = j15 - (60 * j16);
        if (j12 < 10) {
            sb2.append(0);
        }
        sb2.append(j12);
        sb2.append(":");
        if (j14 < 10) {
            sb2.append("0");
        }
        sb2.append(j14);
        sb2.append(":");
        if (j16 < 10) {
            sb2.append("0");
        }
        sb2.append(j16);
        sb2.append(":");
        if (j17 < 10) {
            sb2.append("0");
        }
        sb2.append(j17);
        return sb2.toString();
    }

    public static void a(StringBuilder sb2, int i11, int i12) {
        String num = Integer.toString(i12);
        for (int i13 = 0; i13 < i11 - num.length(); i13++) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    public static Long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime());
        } catch (ParseException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String c(boolean z11, boolean z12, int i11) {
        char c11;
        int i12 = i11 / 60000;
        if (i12 < 0) {
            c11 = '-';
            i12 = -i12;
        } else {
            c11 = '+';
        }
        StringBuilder sb2 = new StringBuilder(9);
        if (z11) {
            sb2.append("GMT");
        }
        sb2.append(c11);
        a(sb2, 2, i12 / 60);
        if (z12) {
            sb2.append(':');
        }
        a(sb2, 2, i12 % 60);
        return sb2.toString();
    }

    public static String d(long j11) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        double d11 = (double) currentTimeMillis;
        if (Double.compare(d11, (double) 60000) == -1) {
            return BaseApplication.b().getString(R$string.discovery_just_now);
        }
        if (Double.compare(d11, (double) Period.MIN60_MILLS) == -1) {
            return BaseApplication.b().getString(R$string.discovery_few_minute_ago, new Object[]{String.valueOf((currentTimeMillis / 1000) / 60)});
        } else if (Double.compare(d11, (double) Period.DAY_MILLS) != -1) {
            return h(j11, "yyyy-MM-dd HH:mm");
        } else {
            return BaseApplication.b().getString(R$string.discovery_few_hour_ago, new Object[]{String.valueOf(((currentTimeMillis / 1000) / 60) / 60)});
        }
    }

    public static String e(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        long j13 = (j11 % Period.DAY_MILLS) / Period.MIN60_MILLS;
        long j14 = (j11 % Period.MIN60_MILLS) / 60000;
        Resources resources = BaseApplication.b().getBaseContext().getResources();
        StringBuilder sb2 = new StringBuilder();
        int i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        if (i11 > 0) {
            sb2.append(j12 + resources.getString(R$string.n_day));
        }
        if (j13 > 0 || i11 > 0) {
            sb2.append(j13 + resources.getString(R$string.n_hour));
        }
        if (j14 > 0 || i11 > 0 || i11 > 0) {
            sb2.append(j14 + resources.getString(R$string.n_minute));
        }
        return sb2.toString();
    }

    public static String f(long j11) {
        if (E(j11)) {
            return h(j11, "HH:mm MM/dd");
        }
        return h(j11, "HH:mm MM/dd/yyyy ");
    }

    public static String g(long j11) {
        return i(j11, "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public static String h(long j11, String str) {
        return i(j11, str, Locale.getDefault());
    }

    public static String i(long j11, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return new SimpleDateFormat(str, locale).format(new Date(j11));
    }

    public static String j(long j11) {
        if (G(j11)) {
            return h(j11, "HH:mm MM/dd/yyyy");
        }
        return h(j11, "HH:mm MM/dd");
    }

    public static String k(long j11) {
        return h(j11, "yyyy-MM-dd HH:mm");
    }

    public static String l(long j11) {
        return h(j11 * 1000, "yyyy-MM-dd HH:mm:ss");
    }

    public static String m(long j11) {
        return h(j11 * 1000, "yyyy-MM-dd");
    }

    public static String n(long j11) {
        return h(j11, "yyyy/MM/dd");
    }

    public static String o() {
        return c(true, true, TimeZone.getDefault().getRawOffset());
    }

    public static Date p(long j11, String str) {
        return q(j11, TimeZone.getTimeZone(str));
    }

    public static Date q(long j11, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.setTimeInMillis(j11);
        instance.setTimeZone(timeZone);
        return instance.getTime();
    }

    public static Date r(String str, String str2) {
        return s(str, str2, TimeZone.getDefault());
    }

    public static Date s(String str, String str2, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setTimeZone(timeZone);
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String t(long j11) {
        return h(j11, "yyyy MM-dd HH:mm");
    }

    public static String u(long j11, String str) {
        return h(j11, str);
    }

    public static long v() {
        try {
            return Calendar.getInstance().getTimeInMillis();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static long w() {
        return v() / 1000;
    }

    public static String x(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        instance.set(6, instance.get(6) + 1);
        return h(j11, "MM/dd HH:mm");
    }

    public static Date y(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(2, 0);
        instance.set(5, 1);
        return instance.getTime();
    }

    public static String[] z(long j11) {
        String str;
        String str2;
        String str3;
        String[] strArr = new String[3];
        long j12 = j11 / Period.MIN60_MILLS;
        if (j12 < 10) {
            str = "0" + String.valueOf(j12);
        } else {
            str = String.valueOf(j12);
        }
        long j13 = j11 % Period.MIN60_MILLS;
        long j14 = j13 / 60000;
        if (j14 < 10) {
            str2 = "0" + String.valueOf(j14);
        } else {
            str2 = String.valueOf(j14);
        }
        long j15 = (j13 % 60000) / 1000;
        if (j15 < 10) {
            str3 = "0" + String.valueOf(j15);
        } else {
            str3 = String.valueOf(j15);
        }
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str3;
        return strArr;
    }
}
