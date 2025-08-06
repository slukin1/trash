package com.hbg.lib.network.pro.core.util;

import android.text.TextUtils;

public enum Period {
    expandtl("expand_tl", "30min"),
    timeline("tl", "1min"),
    min1("1min", "1min"),
    min5("5min", "5min"),
    min15("15min", "15min"),
    min30("30min", "30min"),
    min60("60min", "60min"),
    hour2("2hour", "2hour"),
    hour4("4hour", "4hour"),
    day("1day", "1day"),
    week("1week", "1week"),
    month("1mon", "1mon");
    
    public static final long DAY_MILLS = 86400000;
    public static final long HOUR4_MILLS = 14400000;
    public static final long MIN15_MILLS = 900000;
    public static final long MIN1_MILLS = 60000;
    public static final long MIN30_MILLS = 1800000;
    public static final long MIN5_MILLS = 300000;
    public static final long MIN60_MILLS = 3600000;
    public static final long MONTH_MILLS = 2592000000L;
    public static final long WEEK_MILLS = 604800000;
    public final String key;
    public final String value;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70619a = null;

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
                com.hbg.lib.network.pro.core.util.Period[] r0 = com.hbg.lib.network.pro.core.util.Period.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f70619a = r0
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.timeline     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min5     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min15     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min30     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.expandtl     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min60     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.hour4     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.day     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.week     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f70619a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.month     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.pro.core.util.Period.a.<clinit>():void");
        }
    }

    private Period(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public static long acceptableLocalDiffServer(Period period) {
        long j11;
        int i11 = 1;
        switch (a.f70619a[period.ordinal()]) {
            case 1:
            case 2:
                j11 = 60000;
                i11 = 5;
                break;
            case 3:
                j11 = 300000;
                i11 = 2;
                break;
            case 4:
                j11 = MIN15_MILLS;
                break;
            case 5:
            case 6:
                j11 = MIN30_MILLS;
                break;
            case 7:
                j11 = MIN60_MILLS;
                break;
            case 8:
                j11 = HOUR4_MILLS;
                break;
            case 9:
                j11 = DAY_MILLS;
                break;
            case 10:
                j11 = WEEK_MILLS;
                break;
            case 11:
                j11 = 2592000000L;
                break;
            default:
                j11 = 0;
                i11 = 0;
                break;
        }
        return ((long) i11) * j11;
    }

    public static long fromSecondTime(Period period, int i11) {
        return fromSecondTime(period, System.currentTimeMillis() / 1000, i11);
    }

    public static long getInterval(Period period) {
        switch (a.f70619a[period.ordinal()]) {
            case 1:
            case 2:
                return 60000;
            case 3:
                return 300000;
            case 4:
                return MIN15_MILLS;
            case 5:
            case 6:
                return MIN30_MILLS;
            case 7:
                return MIN60_MILLS;
            case 8:
                return HOUR4_MILLS;
            case 9:
                return DAY_MILLS;
            case 10:
                return WEEK_MILLS;
            case 11:
                return 2592000000L;
            default:
                return 0;
        }
    }

    public static Period parsePeriod(String str) {
        Period period = timeline;
        if (period.key.equalsIgnoreCase(str)) {
            return period;
        }
        Period period2 = min1;
        if (period2.key.equalsIgnoreCase(str)) {
            return period2;
        }
        Period period3 = min5;
        if (period3.key.equalsIgnoreCase(str)) {
            return period3;
        }
        Period period4 = min15;
        if (period4.key.equalsIgnoreCase(str)) {
            return period4;
        }
        Period period5 = min30;
        if (period5.key.equalsIgnoreCase(str)) {
            return period5;
        }
        Period period6 = min60;
        if (period6.key.equalsIgnoreCase(str)) {
            return period6;
        }
        Period period7 = hour4;
        if (period7.key.equalsIgnoreCase(str)) {
            return period7;
        }
        Period period8 = day;
        if (period8.key.equalsIgnoreCase(str)) {
            return period8;
        }
        Period period9 = week;
        if (period9.key.equalsIgnoreCase(str)) {
            return period9;
        }
        Period period10 = month;
        if (period10.key.equalsIgnoreCase(str)) {
            return period10;
        }
        Period period11 = expandtl;
        if (period11.key.equalsIgnoreCase(str)) {
            return period11;
        }
        return null;
    }

    public static boolean samePeriodValue(Period period, Period period2) {
        if (period == null || period2 == null) {
            return false;
        }
        return TextUtils.equals(period.value, period2.value);
    }

    public int getPeriodIntType() {
        switch (a.f70619a[ordinal()]) {
            case 1:
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 3;
            case 7:
                return 4;
            case 8:
                return 5;
            case 9:
                return 6;
            case 10:
                return 7;
            case 11:
                return 8;
            default:
                return -1;
        }
    }

    public static long fromSecondTime(Period period, long j11, int i11) {
        int i12;
        switch (a.f70619a[period.ordinal()]) {
            case 1:
            case 2:
                i12 = (i11 + 1) * 60;
                break;
            case 3:
                i12 = (i11 + 1) * 300;
                break;
            case 4:
                i12 = (i11 + 1) * 900;
                break;
            case 5:
            case 6:
                i12 = (i11 + 1) * 1800;
                break;
            case 7:
                i12 = (i11 + 1) * 3600;
                break;
            case 8:
                i12 = (i11 + 1) * 14400;
                break;
            case 9:
                i12 = (i11 + 1) * 86400;
                break;
            case 10:
                return Math.max(j11 - ((long) ((i11 + 1) * 604800)), 1325347200);
            case 11:
                return Math.max(j11 - ((long) ((i11 + 1) * 2592000)), 1325347200);
            default:
                return 0;
        }
        return j11 - ((long) i12);
    }
}
