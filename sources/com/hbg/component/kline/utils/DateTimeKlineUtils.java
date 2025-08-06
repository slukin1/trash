package com.hbg.component.kline.utils;

import android.util.Log;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.network.pro.core.util.Period;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeKlineUtils {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f67397a;

    /* renamed from: b  reason: collision with root package name */
    public static SimpleDateFormat f67398b;

    /* renamed from: c  reason: collision with root package name */
    public static SimpleDateFormat f67399c;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67400a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.component.kline.render.CandleStickRender$KLineType[] r0 = com.hbg.component.kline.render.CandleStickRender.KLineType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f67400a = r0
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.TIME_LINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.EXPAND_TIME_LINE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_1     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.DAY_1     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.WEEK_1     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MON_1     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_5     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_15     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_30     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.MIN_60     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f67400a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.hbg.component.kline.render.CandleStickRender$KLineType r1 = com.hbg.component.kline.render.CandleStickRender.KLineType.HOUR_4     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.component.kline.utils.DateTimeKlineUtils.a.<clinit>():void");
        }
    }

    public static long a(CandleStickRender.KLineType kLineType, long j11, long j12) {
        long j13;
        switch (a.f67400a[kLineType.ordinal()]) {
            case 1:
            case 3:
                j13 = 60000;
                break;
            case 4:
                j13 = Period.DAY_MILLS;
                break;
            case 5:
                j13 = Period.WEEK_MILLS;
                break;
            case 6:
                j13 = ((long) Calendar.getInstance().getActualMaximum(5)) * 86400 * 1000;
                break;
            case 7:
                j13 = 300000;
                break;
            case 8:
                j13 = Period.MIN15_MILLS;
                break;
            case 9:
                j13 = Period.MIN30_MILLS;
                break;
            case 10:
                j13 = Period.MIN60_MILLS;
                break;
            case 11:
                j13 = Period.HOUR4_MILLS;
                break;
            default:
                return 0;
        }
        return j13 - (j12 - j11);
    }

    public static SimpleDateFormat b(CandleStickRender.KLineType kLineType) {
        switch (a.f67400a[kLineType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (f67397a == null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    f67397a = simpleDateFormat;
                    simpleDateFormat.setTimeZone(TimeZone.getDefault());
                }
                return f67397a;
            case 4:
            case 5:
            case 6:
                if (f67399c == null) {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                    f67399c = simpleDateFormat2;
                    simpleDateFormat2.setTimeZone(TimeZone.getDefault());
                }
                return f67399c;
            default:
                if (f67398b == null) {
                    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM-dd HH:mm");
                    f67398b = simpleDateFormat3;
                    simpleDateFormat3.setTimeZone(TimeZone.getDefault());
                }
                return f67398b;
        }
    }

    public static String c(CandleStickRender.KLineType kLineType, long j11) {
        if (j11 <= 0) {
            Log.e("DateTimeKlineUtils", "getKlineTimeStr countDownTime <= 0");
            return "00:00";
        }
        long j12 = j11 / 1000;
        int i11 = a.f67400a[kLineType.ordinal()];
        if (i11 != 4) {
            if (i11 == 5 || i11 == 6) {
                return (j12 / 86400) + "D:" + ((j12 % 86400) / 3600) + "H";
            } else if (i11 != 11) {
                return String.format("%02d:%02d", new Object[]{Long.valueOf(j12 / 60), Long.valueOf(j12 % 60)});
            }
        }
        return String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(j12 / 3600), Long.valueOf((j12 % 3600) / 60), Long.valueOf(j12 % 60)});
    }

    public static long d() {
        Calendar instance = Calendar.getInstance();
        int i11 = instance.get(1);
        int i12 = instance.get(2);
        int i13 = instance.get(5);
        instance.clear();
        instance.set(i11, i12, i13, 0, 0, 0);
        return instance.getTimeInMillis();
    }
}
