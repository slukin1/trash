package com.hbg.module.huobi.im.utils;

import android.content.Context;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.module.huobi.im.R$string;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f20532a = new SimpleDateFormat("MM/dd HH:mm");

    /* renamed from: b  reason: collision with root package name */
    public static SimpleDateFormat f20533b = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /* renamed from: c  reason: collision with root package name */
    public static SimpleDateFormat f20534c = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: d  reason: collision with root package name */
    public static SimpleDateFormat f20535d = new SimpleDateFormat("HH:mm");

    /* renamed from: e  reason: collision with root package name */
    public static long f20536e = 60000;

    /* renamed from: f  reason: collision with root package name */
    public static long f20537f = Period.MIN60_MILLS;

    public static String a(Context context, long j11) {
        return b(context, j11, true);
    }

    public static String b(Context context, long j11, boolean z11) {
        long j12 = 1000;
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j11;
        int i11 = (currentTimeMillis > 60 ? 1 : (currentTimeMillis == 60 ? 0 : -1));
        if (i11 < 0 && currentTimeMillis >= 0) {
            return context.getString(R$string.n_content_date_justnow);
        }
        if (i11 >= 0 && currentTimeMillis < 3600) {
            String string = context.getString(R$string.n_content_date_minutesago);
            return String.format(string, new Object[]{(currentTimeMillis / 60) + ""});
        } else if (currentTimeMillis < 3600 || currentTimeMillis >= 86400) {
            if (!z11) {
                j12 = 1;
            }
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j11 * j12));
        } else {
            String string2 = context.getString(R$string.n_content_date_hoursago);
            return String.format(string2, new Object[]{(currentTimeMillis / 3600) + ""});
        }
    }

    public static String c(long j11) {
        if (j11 <= 0) {
            return "00:00";
        }
        long j12 = j11 / 1000;
        long j13 = j12 / 60;
        long j14 = j12 % 60;
        StringBuilder sb2 = new StringBuilder();
        if (j13 < 10) {
            sb2.append("0");
        }
        sb2.append(j13);
        sb2.append(":");
        if (j14 < 10) {
            sb2.append("0");
        }
        sb2.append(j14);
        return sb2.toString();
    }

    public static String d(Context context, long j11) {
        if (j11 <= 0) {
            return "0" + context.getResources().getString(R$string.n_content_live_second);
        }
        long j12 = j11 / 1000;
        long j13 = j12 / 60;
        long j14 = j12 % 60;
        StringBuilder sb2 = new StringBuilder();
        if (j13 > 0) {
            sb2.append(j13);
            if (j14 > 0) {
                sb2.append(context.getResources().getString(R$string.n_notification_push_nodisturb_minute));
            } else {
                sb2.append(context.getResources().getString(R$string.n_minute));
            }
        }
        if (j14 > 0) {
            sb2.append(j14);
            sb2.append(context.getResources().getString(R$string.n_content_live_second));
        }
        return sb2.toString();
    }

    public static String e(Context context, long j11) {
        long time = new Date().getTime() - j11;
        if (time < f20536e * 10) {
            return context.getResources().getString(R$string.n_content_date_justnow);
        }
        if (time < f20537f) {
            String string = context.getString(R$string.n_content_date_minutesago);
            return String.format(string, new Object[]{(time / f20536e) + ""});
        }
        Date date = new Date(j11);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (((long) instance.get(1)) != ((long) instance2.get(1))) {
            return f20534c.format(date);
        }
        long j12 = (long) instance.get(6);
        long j13 = (long) instance2.get(6);
        if (j12 == j13) {
            String string2 = context.getString(R$string.n_content_date_hoursago);
            return String.format(string2, new Object[]{(time / f20537f) + ""});
        } else if (j12 == 1 + j13) {
            return context.getString(R$string.n_content_date_yesterday);
        } else {
            if (j12 == 2 + j13) {
                return context.getString(R$string.n_feed_date_before_yesterday);
            }
            long j14 = j12 - j13;
            if (j14 < 7) {
                int i11 = R$string.n_feed_date_day_before;
                return context.getString(i11, new Object[]{Math.abs(j14) + ""});
            } else if (j14 < 30) {
                int i12 = R$string.n_feed_date_week_before;
                return context.getString(i12, new Object[]{Math.abs(j14 / 7) + ""});
            } else {
                int i13 = R$string.n_feed_date_month_before;
                return context.getString(i13, new Object[]{Math.abs(j14 / 30) + ""});
            }
        }
    }

    public static String f(Context context, long j11) {
        long time = new Date().getTime() - j11;
        if (time < f20536e) {
            return context.getResources().getString(R$string.n_content_date_justnow);
        }
        if (time < f20537f) {
            String string = context.getString(R$string.n_content_date_minutesago);
            return String.format(string, new Object[]{(time / f20536e) + ""});
        }
        Date date = new Date(j11);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (((long) instance.get(1)) != ((long) instance2.get(1))) {
            return f20533b.format(date);
        }
        long j12 = (long) instance.get(6);
        long j13 = (long) instance2.get(6);
        if (j12 == j13) {
            String string2 = context.getString(R$string.n_content_date_hoursago);
            return String.format(string2, new Object[]{(time / f20537f) + ""});
        } else if (j12 != j13 + 1) {
            return f20532a.format(date);
        } else {
            return String.format(context.getString(R$string.n_content_date_yesterday) + " %s", new Object[]{f20535d.format(date)});
        }
    }

    public static String g(Context context, long j11, long j12) {
        Date date = new Date(j11);
        Date date2 = new Date(j12);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        long j13 = (long) instance.get(6);
        long j14 = (long) instance2.get(6);
        if (j13 == j14) {
            return context.getString(R$string.n_im_time_today) + " " + f20535d.format(date) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f20535d.format(date2);
        } else if (j14 - j13 == 1) {
            return context.getString(R$string.n_im_time_tomorrow) + " " + f20535d.format(date) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f20535d.format(date2);
        } else {
            return DateTimeUtils.u(j11, "MM-dd HH:mm") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f20535d.format(date2);
        }
    }
}
