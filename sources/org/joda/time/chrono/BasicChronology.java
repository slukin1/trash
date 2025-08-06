package org.joda.time.chrono;

import com.adjust.sdk.Constants;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.d;
import org.joda.time.field.e;
import org.joda.time.field.f;
import org.joda.time.field.g;
import org.joda.time.field.i;
import org.joda.time.field.j;

abstract class BasicChronology extends AssembledChronology {
    private static final int CACHE_MASK = 1023;
    private static final int CACHE_SIZE = 1024;
    private static final DateTimeField cClockhourOfDayField;
    private static final DateTimeField cClockhourOfHalfdayField;
    /* access modifiers changed from: private */
    public static final DurationField cDaysField;
    private static final DateTimeField cHalfdayOfDayField = new a();
    /* access modifiers changed from: private */
    public static final DurationField cHalfdaysField;
    private static final DateTimeField cHourOfDayField;
    private static final DateTimeField cHourOfHalfdayField;
    private static final DurationField cHoursField;
    private static final DurationField cMillisField;
    private static final DateTimeField cMillisOfDayField;
    private static final DateTimeField cMillisOfSecondField;
    private static final DateTimeField cMinuteOfDayField;
    private static final DateTimeField cMinuteOfHourField;
    private static final DurationField cMinutesField;
    private static final DateTimeField cSecondOfDayField;
    private static final DateTimeField cSecondOfMinuteField;
    private static final DurationField cSecondsField;
    private static final DurationField cWeeksField = new PreciseDurationField(DurationFieldType.weeks(), Period.WEEK_MILLS);
    private static final long serialVersionUID = 8283225332206808863L;
    private final int iMinDaysInFirstWeek;
    private final transient b[] iYearInfoCache = new b[1024];

    public static class a extends g {
        public a() {
            super(DateTimeFieldType.halfdayOfDay(), BasicChronology.cHalfdaysField, BasicChronology.cDaysField);
        }

        public String getAsText(int i11, Locale locale) {
            return k.h(locale).p(i11);
        }

        public int getMaximumTextLength(Locale locale) {
            return k.h(locale).l();
        }

        public long set(long j11, String str, Locale locale) {
            return set(j11, k.h(locale).o(str));
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f23059a;

        /* renamed from: b  reason: collision with root package name */
        public final long f23060b;

        public b(int i11, long j11) {
            this.f23059a = i11;
            this.f23060b = j11;
        }
    }

    static {
        DurationField durationField = MillisDurationField.INSTANCE;
        cMillisField = durationField;
        PreciseDurationField preciseDurationField = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        cSecondsField = preciseDurationField;
        PreciseDurationField preciseDurationField2 = new PreciseDurationField(DurationFieldType.minutes(), 60000);
        cMinutesField = preciseDurationField2;
        PreciseDurationField preciseDurationField3 = new PreciseDurationField(DurationFieldType.hours(), Period.MIN60_MILLS);
        cHoursField = preciseDurationField3;
        PreciseDurationField preciseDurationField4 = new PreciseDurationField(DurationFieldType.halfdays(), 43200000);
        cHalfdaysField = preciseDurationField4;
        PreciseDurationField preciseDurationField5 = new PreciseDurationField(DurationFieldType.days(), Period.DAY_MILLS);
        cDaysField = preciseDurationField5;
        cMillisOfSecondField = new g(DateTimeFieldType.millisOfSecond(), durationField, preciseDurationField);
        cMillisOfDayField = new g(DateTimeFieldType.millisOfDay(), durationField, preciseDurationField5);
        cSecondOfMinuteField = new g(DateTimeFieldType.secondOfMinute(), preciseDurationField, preciseDurationField2);
        cSecondOfDayField = new g(DateTimeFieldType.secondOfDay(), preciseDurationField, preciseDurationField5);
        cMinuteOfHourField = new g(DateTimeFieldType.minuteOfHour(), preciseDurationField2, preciseDurationField3);
        cMinuteOfDayField = new g(DateTimeFieldType.minuteOfDay(), preciseDurationField2, preciseDurationField5);
        g gVar = new g(DateTimeFieldType.hourOfDay(), preciseDurationField3, preciseDurationField5);
        cHourOfDayField = gVar;
        g gVar2 = new g(DateTimeFieldType.hourOfHalfday(), preciseDurationField3, preciseDurationField4);
        cHourOfHalfdayField = gVar2;
        cClockhourOfDayField = new j(gVar, DateTimeFieldType.clockhourOfDay());
        cClockhourOfHalfdayField = new j(gVar2, DateTimeFieldType.clockhourOfHalfday());
    }

    public BasicChronology(Chronology chronology, Object obj, int i11) {
        super(chronology, obj);
        if (i11 < 1 || i11 > 7) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i11);
        }
        this.iMinDaysInFirstWeek = i11;
    }

    private b getYearInfo(int i11) {
        int i12 = i11 & 1023;
        b bVar = this.iYearInfoCache[i12];
        if (bVar != null && bVar.f23059a == i11) {
            return bVar;
        }
        b bVar2 = new b(i11, calculateFirstDayOfYearMillis(i11));
        this.iYearInfoCache[i12] = bVar2;
        return bVar2;
    }

    public void assemble(AssembledChronology.a aVar) {
        aVar.f23033a = cMillisField;
        aVar.f23034b = cSecondsField;
        aVar.f23035c = cMinutesField;
        aVar.f23036d = cHoursField;
        aVar.f23037e = cHalfdaysField;
        aVar.f23038f = cDaysField;
        aVar.f23039g = cWeeksField;
        aVar.f23045m = cMillisOfSecondField;
        aVar.f23046n = cMillisOfDayField;
        aVar.f23047o = cSecondOfMinuteField;
        aVar.f23048p = cSecondOfDayField;
        aVar.f23049q = cMinuteOfHourField;
        aVar.f23050r = cMinuteOfDayField;
        aVar.f23051s = cHourOfDayField;
        aVar.f23053u = cHourOfHalfdayField;
        aVar.f23052t = cClockhourOfDayField;
        aVar.f23054v = cClockhourOfHalfdayField;
        aVar.f23055w = cHalfdayOfDayField;
        g gVar = new g(this);
        aVar.E = gVar;
        m mVar = new m(gVar, this);
        aVar.F = mVar;
        d dVar = new d(new f(mVar, 99), DateTimeFieldType.centuryOfEra(), 100);
        aVar.H = dVar;
        aVar.f23043k = dVar.getDurationField();
        aVar.G = new f(new i((d) aVar.H), DateTimeFieldType.yearOfCentury(), 1);
        aVar.I = new j(this);
        aVar.f23056x = new i(this, aVar.f23038f);
        aVar.f23057y = new a(this, aVar.f23038f);
        aVar.f23058z = new b(this, aVar.f23038f);
        aVar.D = new l(this);
        aVar.B = new f(this);
        aVar.A = new e(this, aVar.f23039g);
        aVar.C = new f(new i(aVar.B, aVar.f23043k, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
        aVar.f23042j = aVar.E.getDurationField();
        aVar.f23041i = aVar.D.getDurationField();
        aVar.f23040h = aVar.B.getDurationField();
    }

    public abstract long calculateFirstDayOfYearMillis(int i11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        if (getMinimumDaysInFirstWeek() != basicChronology.getMinimumDaysInFirstWeek() || !getZone().equals(basicChronology.getZone())) {
            return false;
        }
        return true;
    }

    public abstract long getApproxMillisAtEpochDividedByTwo();

    public abstract long getAverageMillisPerMonth();

    public abstract long getAverageMillisPerYear();

    public abstract long getAverageMillisPerYearDividedByTwo();

    public long getDateMidnightMillis(int i11, int i12, int i13) {
        e.n(DateTimeFieldType.year(), i11, getMinYear(), getMaxYear());
        e.n(DateTimeFieldType.monthOfYear(), i12, 1, getMaxMonth(i11));
        e.n(DateTimeFieldType.dayOfMonth(), i13, 1, getDaysInYearMonth(i11, i12));
        return getYearMonthDayMillis(i11, i12, i13);
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i11, i12, i13, i14);
        }
        e.n(DateTimeFieldType.millisOfDay(), i14, 0, 86399999);
        return getDateMidnightMillis(i11, i12, i13) + ((long) i14);
    }

    public int getDayOfMonth(long j11) {
        int year = getYear(j11);
        return getDayOfMonth(j11, year, getMonthOfYear(j11, year));
    }

    public int getDayOfWeek(long j11) {
        long j12;
        if (j11 >= 0) {
            j12 = j11 / Period.DAY_MILLS;
        } else {
            j12 = (j11 - 86399999) / Period.DAY_MILLS;
            if (j12 < -3) {
                return ((int) ((j12 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j12 + 3) % 7)) + 1;
    }

    public int getDayOfYear(long j11) {
        return getDayOfYear(j11, getYear(j11));
    }

    public int getDaysInMonthMax() {
        return 31;
    }

    public abstract int getDaysInMonthMax(int i11);

    public int getDaysInMonthMax(long j11) {
        int year = getYear(j11);
        return getDaysInYearMonth(year, getMonthOfYear(j11, year));
    }

    public int getDaysInMonthMaxForSet(long j11, int i11) {
        return getDaysInMonthMax(j11);
    }

    public int getDaysInYear(int i11) {
        return isLeapYear(i11) ? 366 : 365;
    }

    public int getDaysInYearMax() {
        return 366;
    }

    public abstract int getDaysInYearMonth(int i11, int i12);

    public long getFirstWeekOfYearMillis(int i11) {
        long yearMillis = getYearMillis(i11);
        int dayOfWeek = getDayOfWeek(yearMillis);
        return dayOfWeek > 8 - this.iMinDaysInFirstWeek ? yearMillis + (((long) (8 - dayOfWeek)) * Period.DAY_MILLS) : yearMillis - (((long) (dayOfWeek - 1)) * Period.DAY_MILLS);
    }

    public int getMaxMonth() {
        return 12;
    }

    public int getMaxMonth(int i11) {
        return getMaxMonth();
    }

    public abstract int getMaxYear();

    public int getMillisOfDay(long j11) {
        if (j11 >= 0) {
            return (int) (j11 % Period.DAY_MILLS);
        }
        return ((int) ((j11 + 1) % Period.DAY_MILLS)) + 86399999;
    }

    public abstract int getMinYear();

    public int getMinimumDaysInFirstWeek() {
        return this.iMinDaysInFirstWeek;
    }

    public int getMonthOfYear(long j11) {
        return getMonthOfYear(j11, getYear(j11));
    }

    public abstract int getMonthOfYear(long j11, int i11);

    public abstract long getTotalMillisByYearMonth(int i11, int i12);

    public int getWeekOfWeekyear(long j11) {
        return getWeekOfWeekyear(j11, getYear(j11));
    }

    public int getWeeksInYear(int i11) {
        return (int) ((getFirstWeekOfYearMillis(i11 + 1) - getFirstWeekOfYearMillis(i11)) / Period.WEEK_MILLS);
    }

    public int getWeekyear(long j11) {
        int year = getYear(j11);
        int weekOfWeekyear = getWeekOfWeekyear(j11, year);
        if (weekOfWeekyear == 1) {
            return getYear(j11 + Period.WEEK_MILLS);
        }
        return weekOfWeekyear > 51 ? getYear(j11 - 1209600000) : year;
    }

    public int getYear(long j11) {
        long averageMillisPerYearDividedByTwo = getAverageMillisPerYearDividedByTwo();
        long approxMillisAtEpochDividedByTwo = (j11 >> 1) + getApproxMillisAtEpochDividedByTwo();
        if (approxMillisAtEpochDividedByTwo < 0) {
            approxMillisAtEpochDividedByTwo = (approxMillisAtEpochDividedByTwo - averageMillisPerYearDividedByTwo) + 1;
        }
        int i11 = (int) (approxMillisAtEpochDividedByTwo / averageMillisPerYearDividedByTwo);
        long yearMillis = getYearMillis(i11);
        long j12 = j11 - yearMillis;
        if (j12 < 0) {
            return i11 - 1;
        }
        long j13 = 31536000000L;
        if (j12 < 31536000000L) {
            return i11;
        }
        if (isLeapYear(i11)) {
            j13 = 31622400000L;
        }
        return yearMillis + j13 <= j11 ? i11 + 1 : i11;
    }

    public abstract long getYearDifference(long j11, long j12);

    public long getYearMillis(int i11) {
        return getYearInfo(i11).f23060b;
    }

    public long getYearMonthDayMillis(int i11, int i12, int i13) {
        return getYearMillis(i11) + getTotalMillisByYearMonth(i11, i12) + (((long) (i13 - 1)) * Period.DAY_MILLS);
    }

    public long getYearMonthMillis(int i11, int i12) {
        return getYearMillis(i11) + getTotalMillisByYearMonth(i11, i12);
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + getZone().hashCode() + getMinimumDaysInFirstWeek();
    }

    public boolean isLeapDay(long j11) {
        return false;
    }

    public abstract boolean isLeapYear(int i11);

    public abstract long setYear(long j11, int i11);

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb2.append(name);
        sb2.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb2.append(zone.getID());
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            sb2.append(",mdfw=");
            sb2.append(getMinimumDaysInFirstWeek());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public int getDayOfYear(long j11, int i11) {
        return ((int) ((j11 - getYearMillis(i11)) / Period.DAY_MILLS)) + 1;
    }

    public int getWeekOfWeekyear(long j11, int i11) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i11);
        if (j11 < firstWeekOfYearMillis) {
            return getWeeksInYear(i11 - 1);
        }
        if (j11 >= getFirstWeekOfYearMillis(i11 + 1)) {
            return 1;
        }
        return ((int) ((j11 - firstWeekOfYearMillis) / Period.WEEK_MILLS)) + 1;
    }

    public int getDayOfMonth(long j11, int i11) {
        return getDayOfMonth(j11, i11, getMonthOfYear(j11, i11));
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
        }
        e.n(DateTimeFieldType.hourOfDay(), i14, 0, 23);
        e.n(DateTimeFieldType.minuteOfHour(), i15, 0, 59);
        e.n(DateTimeFieldType.secondOfMinute(), i16, 0, 59);
        e.n(DateTimeFieldType.millisOfSecond(), i17, 0, 999);
        return getDateMidnightMillis(i11, i12, i13) + ((long) (i14 * Constants.ONE_HOUR)) + ((long) (i15 * 60000)) + ((long) (i16 * 1000)) + ((long) i17);
    }

    public int getDayOfMonth(long j11, int i11, int i12) {
        return ((int) ((j11 - (getYearMillis(i11) + getTotalMillisByYearMonth(i11, i12))) / Period.DAY_MILLS)) + 1;
    }
}
