package org.joda.time.chrono;

import com.hbg.lib.network.pro.core.util.Period;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

public final class IslamicChronology extends BasicChronology {
    public static final int AH = 1;
    private static final int CYCLE = 30;
    private static final DateTimeField ERA_FIELD = new d("AH");
    private static final IslamicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    public static final LeapYearPatternType LEAP_YEAR_15_BASED = new LeapYearPatternType(0, 623158436);
    public static final LeapYearPatternType LEAP_YEAR_16_BASED = new LeapYearPatternType(1, 623191204);
    public static final LeapYearPatternType LEAP_YEAR_HABASH_AL_HASIB = new LeapYearPatternType(3, 153692453);
    public static final LeapYearPatternType LEAP_YEAR_INDIAN = new LeapYearPatternType(2, 690562340);
    private static final int LONG_MONTH_LENGTH = 30;
    private static final int MAX_YEAR = 292271022;
    private static final long MILLIS_PER_CYCLE = 918518400000L;
    private static final long MILLIS_PER_LONG_MONTH = 2592000000L;
    private static final long MILLIS_PER_LONG_YEAR = 30672000000L;
    private static final long MILLIS_PER_MONTH = 2551440384L;
    private static final long MILLIS_PER_MONTH_PAIR = 5097600000L;
    private static final long MILLIS_PER_SHORT_YEAR = 30585600000L;
    private static final long MILLIS_PER_YEAR = 30617280288L;
    private static final long MILLIS_YEAR_1 = -42521587200000L;
    private static final int MIN_YEAR = -292269337;
    private static final int MONTH_PAIR_LENGTH = 59;
    private static final int SHORT_MONTH_LENGTH = 29;
    private static final ConcurrentHashMap<DateTimeZone, IslamicChronology[]> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -3663823829888L;
    private final LeapYearPatternType iLeapYears;

    public static class LeapYearPatternType implements Serializable {
        private static final long serialVersionUID = 26581275372698L;
        public final byte index;
        public final int pattern;

        public LeapYearPatternType(int i11, int i12) {
            this.index = (byte) i11;
            this.pattern = i12;
        }

        private Object readResolve() {
            byte b11 = this.index;
            if (b11 == 0) {
                return IslamicChronology.LEAP_YEAR_15_BASED;
            }
            if (b11 == 1) {
                return IslamicChronology.LEAP_YEAR_16_BASED;
            }
            if (b11 == 2) {
                return IslamicChronology.LEAP_YEAR_INDIAN;
            }
            if (b11 != 3) {
                return this;
            }
            return IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LeapYearPatternType) || this.index != ((LeapYearPatternType) obj).index) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.index;
        }

        public boolean isLeapYear(int i11) {
            if (((1 << (i11 % 30)) & this.pattern) > 0) {
                return true;
            }
            return false;
        }
    }

    public IslamicChronology(Chronology chronology, Object obj, LeapYearPatternType leapYearPatternType) {
        super(chronology, obj, 4);
        this.iLeapYears = leapYearPatternType;
    }

    public static IslamicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public void assemble(AssembledChronology.a aVar) {
        if (getBase() == null) {
            super.assemble(aVar);
            aVar.I = ERA_FIELD;
            c cVar = new c(this, 12);
            aVar.D = cVar;
            aVar.f23041i = cVar.getDurationField();
        }
    }

    public long calculateFirstDayOfYearMillis(int i11) {
        if (i11 > MAX_YEAR) {
            throw new ArithmeticException("Year is too large: " + i11 + " > " + MAX_YEAR);
        } else if (i11 >= MIN_YEAR) {
            int i12 = i11 - 1;
            long j11 = (((long) (i12 / 30)) * MILLIS_PER_CYCLE) + MILLIS_YEAR_1;
            int i13 = (i12 % 30) + 1;
            for (int i14 = 1; i14 < i13; i14++) {
                j11 += isLeapYear(i14) ? MILLIS_PER_LONG_YEAR : MILLIS_PER_SHORT_YEAR;
            }
            return j11;
        } else {
            throw new ArithmeticException("Year is too small: " + i11 + " < " + MIN_YEAR);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IslamicChronology)) {
            return false;
        }
        if (getLeapYearPatternType().index != ((IslamicChronology) obj).getLeapYearPatternType().index || !super.equals(obj)) {
            return false;
        }
        return true;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 21260793600000L;
    }

    public long getAverageMillisPerMonth() {
        return MILLIS_PER_MONTH;
    }

    public long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15308640144L;
    }

    public int getDayOfMonth(long j11) {
        int dayOfYear = getDayOfYear(j11) - 1;
        if (dayOfYear == 354) {
            return 30;
        }
        return ((dayOfYear % 59) % 30) + 1;
    }

    public int getDaysInMonthMax() {
        return 30;
    }

    public int getDaysInMonthMax(int i11) {
        return (i11 == 12 || (i11 + -1) % 2 == 0) ? 30 : 29;
    }

    public int getDaysInYear(int i11) {
        return isLeapYear(i11) ? 355 : 354;
    }

    public int getDaysInYearMax() {
        return 355;
    }

    public int getDaysInYearMonth(int i11, int i12) {
        if ((i12 != 12 || !isLeapYear(i11)) && (i12 - 1) % 2 != 0) {
            return 29;
        }
        return 30;
    }

    public LeapYearPatternType getLeapYearPatternType() {
        return this.iLeapYears;
    }

    public int getMaxYear() {
        return MAX_YEAR;
    }

    public int getMinYear() {
        return 1;
    }

    public int getMonthOfYear(long j11, int i11) {
        int yearMillis = (int) ((j11 - getYearMillis(i11)) / Period.DAY_MILLS);
        if (yearMillis == 354) {
            return 12;
        }
        return ((yearMillis * 2) / 59) + 1;
    }

    public long getTotalMillisByYearMonth(int i11, int i12) {
        int i13 = i12 - 1;
        if (i13 % 2 == 1) {
            return (((long) (i13 / 2)) * MILLIS_PER_MONTH_PAIR) + 2592000000L;
        }
        return ((long) (i13 / 2)) * MILLIS_PER_MONTH_PAIR;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0023, code lost:
        if (isLeapYear(r0) != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0025, code lost:
        r6 = 30672000000L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0027, code lost:
        r6 = 30585600000L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if (r9 < r6) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        r9 = r9 - r6;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        if (isLeapYear(r0) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getYear(long r9) {
        /*
            r8 = this;
            r0 = -42521587200000(0xffffd953abe65000, double:NaN)
            long r9 = r9 - r0
            r0 = 918518400000(0xd5dbf68400, double:4.53808386513E-312)
            long r2 = r9 / r0
            long r9 = r9 % r0
            r0 = 30
            long r2 = r2 * r0
            r0 = 1
            long r2 = r2 + r0
            int r0 = (int) r2
            boolean r1 = r8.isLeapYear(r0)
            r2 = 30672000000(0x724319400, double:1.5153981489E-313)
            r4 = 30585600000(0x71f0b3800, double:1.51112942174E-313)
            if (r1 == 0) goto L_0x0027
        L_0x0025:
            r6 = r2
            goto L_0x0028
        L_0x0027:
            r6 = r4
        L_0x0028:
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0036
            long r9 = r9 - r6
            int r0 = r0 + 1
            boolean r1 = r8.isLeapYear(r0)
            if (r1 == 0) goto L_0x0027
            goto L_0x0025
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.IslamicChronology.getYear(long):int");
    }

    public long getYearDifference(long j11, long j12) {
        int year = getYear(j11);
        int year2 = getYear(j12);
        int i11 = year - year2;
        if (j11 - getYearMillis(year) < j12 - getYearMillis(year2)) {
            i11--;
        }
        return (long) i11;
    }

    public int hashCode() {
        return (super.hashCode() * 13) + getLeapYearPatternType().hashCode();
    }

    public boolean isLeapYear(int i11) {
        return this.iLeapYears.isLeapYear(i11);
    }

    public long setYear(long j11, int i11) {
        int dayOfYear = getDayOfYear(j11, getYear(j11));
        int millisOfDay = getMillisOfDay(j11);
        if (dayOfYear > 354 && !isLeapYear(i11)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i11, 1, dayOfYear) + ((long) millisOfDay);
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, LEAP_YEAR_16_BASED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r1 = new org.joda.time.chrono.IslamicChronology[4];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.chrono.IslamicChronology getInstance(org.joda.time.DateTimeZone r12, org.joda.time.chrono.IslamicChronology.LeapYearPatternType r13) {
        /*
            if (r12 != 0) goto L_0x0006
            org.joda.time.DateTimeZone r12 = org.joda.time.DateTimeZone.getDefault()
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<org.joda.time.DateTimeZone, org.joda.time.chrono.IslamicChronology[]> r0 = cCache
            java.lang.Object r1 = r0.get(r12)
            org.joda.time.chrono.IslamicChronology[] r1 = (org.joda.time.chrono.IslamicChronology[]) r1
            if (r1 != 0) goto L_0x001c
            r1 = 4
            org.joda.time.chrono.IslamicChronology[] r1 = new org.joda.time.chrono.IslamicChronology[r1]
            java.lang.Object r0 = r0.putIfAbsent(r12, r1)
            org.joda.time.chrono.IslamicChronology[] r0 = (org.joda.time.chrono.IslamicChronology[]) r0
            if (r0 == 0) goto L_0x001c
            r1 = r0
        L_0x001c:
            byte r0 = r13.index
            r0 = r1[r0]
            if (r0 != 0) goto L_0x0062
            monitor-enter(r1)
            byte r0 = r13.index     // Catch:{ all -> 0x005f }
            r0 = r1[r0]     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x005d
            org.joda.time.DateTimeZone r0 = org.joda.time.DateTimeZone.UTC     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r12 != r0) goto L_0x004b
            org.joda.time.chrono.IslamicChronology r12 = new org.joda.time.chrono.IslamicChronology     // Catch:{ all -> 0x005f }
            r12.<init>(r2, r2, r13)     // Catch:{ all -> 0x005f }
            org.joda.time.DateTime r0 = new org.joda.time.DateTime     // Catch:{ all -> 0x005f }
            r4 = 1
            r5 = 1
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r0
            r11 = r12
            r3.<init>((int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (int) r10, (org.joda.time.Chronology) r11)     // Catch:{ all -> 0x005f }
            org.joda.time.chrono.IslamicChronology r3 = new org.joda.time.chrono.IslamicChronology     // Catch:{ all -> 0x005f }
            org.joda.time.chrono.LimitChronology r12 = org.joda.time.chrono.LimitChronology.getInstance(r12, r0, r2)     // Catch:{ all -> 0x005f }
            r3.<init>(r12, r2, r13)     // Catch:{ all -> 0x005f }
            goto L_0x0058
        L_0x004b:
            org.joda.time.chrono.IslamicChronology r0 = getInstance(r0, r13)     // Catch:{ all -> 0x005f }
            org.joda.time.chrono.IslamicChronology r3 = new org.joda.time.chrono.IslamicChronology     // Catch:{ all -> 0x005f }
            org.joda.time.chrono.ZonedChronology r12 = org.joda.time.chrono.ZonedChronology.getInstance(r0, r12)     // Catch:{ all -> 0x005f }
            r3.<init>(r12, r2, r13)     // Catch:{ all -> 0x005f }
        L_0x0058:
            byte r12 = r13.index     // Catch:{ all -> 0x005f }
            r1[r12] = r3     // Catch:{ all -> 0x005f }
            r0 = r3
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            goto L_0x0062
        L_0x005f:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r12
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.IslamicChronology.getInstance(org.joda.time.DateTimeZone, org.joda.time.chrono.IslamicChronology$LeapYearPatternType):org.joda.time.chrono.IslamicChronology");
    }
}
