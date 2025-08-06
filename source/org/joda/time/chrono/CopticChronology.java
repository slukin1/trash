package org.joda.time.chrono;

import com.hbg.lib.network.pro.core.util.Period;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

public final class CopticChronology extends BasicFixedMonthChronology {
    public static final int AM = 1;
    private static final DateTimeField ERA_FIELD = new d("AM");
    private static final CopticChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final int MAX_YEAR = 292272708;
    private static final int MIN_YEAR = -292269337;
    private static final ConcurrentHashMap<DateTimeZone, CopticChronology[]> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -5972804258688333942L;

    public CopticChronology(Chronology chronology, Object obj, int i11) {
        super(chronology, obj, i11);
    }

    public static CopticChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static CopticChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        int minimumDaysInFirstWeek = getMinimumDaysInFirstWeek();
        if (minimumDaysInFirstWeek == 0) {
            minimumDaysInFirstWeek = 4;
        }
        return getInstance(base == null ? DateTimeZone.UTC : base.getZone(), minimumDaysInFirstWeek);
    }

    public void assemble(AssembledChronology.a aVar) {
        if (getBase() == null) {
            super.assemble(aVar);
            aVar.E = new SkipDateTimeField(this, aVar.E);
            aVar.B = new SkipDateTimeField(this, aVar.B);
            aVar.I = ERA_FIELD;
            c cVar = new c(this, 13);
            aVar.D = cVar;
            aVar.f23041i = cVar.getDurationField();
        }
    }

    public long calculateFirstDayOfYearMillis(int i11) {
        int i12;
        int i13 = i11 - 1687;
        if (i13 <= 0) {
            i12 = (i13 + 3) >> 2;
        } else {
            int i14 = i13 >> 2;
            i12 = !isLeapYear(i11) ? i14 + 1 : i14;
        }
        return (((((long) i13) * 365) + ((long) i12)) * Period.DAY_MILLS) + 21859200000L;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 26607895200000L;
    }

    public int getMaxYear() {
        return MAX_YEAR;
    }

    public int getMinYear() {
        return MIN_YEAR;
    }

    public boolean isLeapDay(long j11) {
        return dayOfMonth().get(j11) == 6 && monthOfYear().isLeap(j11);
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

    public static CopticChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r1 = new org.joda.time.chrono.CopticChronology[7];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.chrono.CopticChronology getInstance(org.joda.time.DateTimeZone r13, int r14) {
        /*
            if (r13 != 0) goto L_0x0006
            org.joda.time.DateTimeZone r13 = org.joda.time.DateTimeZone.getDefault()
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap<org.joda.time.DateTimeZone, org.joda.time.chrono.CopticChronology[]> r0 = cCache
            java.lang.Object r1 = r0.get(r13)
            org.joda.time.chrono.CopticChronology[] r1 = (org.joda.time.chrono.CopticChronology[]) r1
            if (r1 != 0) goto L_0x001c
            r1 = 7
            org.joda.time.chrono.CopticChronology[] r1 = new org.joda.time.chrono.CopticChronology[r1]
            java.lang.Object r0 = r0.putIfAbsent(r13, r1)
            org.joda.time.chrono.CopticChronology[] r0 = (org.joda.time.chrono.CopticChronology[]) r0
            if (r0 == 0) goto L_0x001c
            r1 = r0
        L_0x001c:
            int r0 = r14 + -1
            r2 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x005f }
            if (r2 != 0) goto L_0x005e
            monitor-enter(r1)
            r2 = r1[r0]     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x0059
            org.joda.time.DateTimeZone r2 = org.joda.time.DateTimeZone.UTC     // Catch:{ all -> 0x005b }
            r3 = 0
            if (r13 != r2) goto L_0x0049
            org.joda.time.chrono.CopticChronology r13 = new org.joda.time.chrono.CopticChronology     // Catch:{ all -> 0x005b }
            r13.<init>(r3, r3, r14)     // Catch:{ all -> 0x005b }
            org.joda.time.DateTime r2 = new org.joda.time.DateTime     // Catch:{ all -> 0x005b }
            r5 = 1
            r6 = 1
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r2
            r12 = r13
            r4.<init>((int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (int) r10, (int) r11, (org.joda.time.Chronology) r12)     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.CopticChronology r4 = new org.joda.time.chrono.CopticChronology     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.LimitChronology r13 = org.joda.time.chrono.LimitChronology.getInstance(r13, r2, r3)     // Catch:{ all -> 0x005b }
            r4.<init>(r13, r3, r14)     // Catch:{ all -> 0x005b }
            goto L_0x0056
        L_0x0049:
            org.joda.time.chrono.CopticChronology r2 = getInstance(r2, r14)     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.CopticChronology r4 = new org.joda.time.chrono.CopticChronology     // Catch:{ all -> 0x005b }
            org.joda.time.chrono.ZonedChronology r13 = org.joda.time.chrono.ZonedChronology.getInstance(r2, r13)     // Catch:{ all -> 0x005b }
            r4.<init>(r13, r3, r14)     // Catch:{ all -> 0x005b }
        L_0x0056:
            r1[r0] = r4     // Catch:{ all -> 0x005b }
            r2 = r4
        L_0x0059:
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            goto L_0x005e
        L_0x005b:
            r13 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            throw r13
        L_0x005e:
            return r2
        L_0x005f:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid min days in first week: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.CopticChronology.getInstance(org.joda.time.DateTimeZone, int):org.joda.time.chrono.CopticChronology");
    }
}
