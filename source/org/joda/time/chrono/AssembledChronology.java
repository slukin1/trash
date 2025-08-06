package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;

public abstract class AssembledChronology extends BaseChronology {
    private static final long serialVersionUID = -6728465968995518215L;
    private final Chronology iBase;
    private transient int iBaseFlags;
    private transient DurationField iCenturies;
    private transient DateTimeField iCenturyOfEra;
    private transient DateTimeField iClockhourOfDay;
    private transient DateTimeField iClockhourOfHalfday;
    private transient DateTimeField iDayOfMonth;
    private transient DateTimeField iDayOfWeek;
    private transient DateTimeField iDayOfYear;
    private transient DurationField iDays;
    private transient DateTimeField iEra;
    private transient DurationField iEras;
    private transient DateTimeField iHalfdayOfDay;
    private transient DurationField iHalfdays;
    private transient DateTimeField iHourOfDay;
    private transient DateTimeField iHourOfHalfday;
    private transient DurationField iHours;
    private transient DurationField iMillis;
    private transient DateTimeField iMillisOfDay;
    private transient DateTimeField iMillisOfSecond;
    private transient DateTimeField iMinuteOfDay;
    private transient DateTimeField iMinuteOfHour;
    private transient DurationField iMinutes;
    private transient DateTimeField iMonthOfYear;
    private transient DurationField iMonths;
    private final Object iParam;
    private transient DateTimeField iSecondOfDay;
    private transient DateTimeField iSecondOfMinute;
    private transient DurationField iSeconds;
    private transient DateTimeField iWeekOfWeekyear;
    private transient DurationField iWeeks;
    private transient DateTimeField iWeekyear;
    private transient DateTimeField iWeekyearOfCentury;
    private transient DurationField iWeekyears;
    private transient DateTimeField iYear;
    private transient DateTimeField iYearOfCentury;
    private transient DateTimeField iYearOfEra;
    private transient DurationField iYears;

    public static final class a {
        public DateTimeField A;
        public DateTimeField B;
        public DateTimeField C;
        public DateTimeField D;
        public DateTimeField E;
        public DateTimeField F;
        public DateTimeField G;
        public DateTimeField H;
        public DateTimeField I;

        /* renamed from: a  reason: collision with root package name */
        public DurationField f23033a;

        /* renamed from: b  reason: collision with root package name */
        public DurationField f23034b;

        /* renamed from: c  reason: collision with root package name */
        public DurationField f23035c;

        /* renamed from: d  reason: collision with root package name */
        public DurationField f23036d;

        /* renamed from: e  reason: collision with root package name */
        public DurationField f23037e;

        /* renamed from: f  reason: collision with root package name */
        public DurationField f23038f;

        /* renamed from: g  reason: collision with root package name */
        public DurationField f23039g;

        /* renamed from: h  reason: collision with root package name */
        public DurationField f23040h;

        /* renamed from: i  reason: collision with root package name */
        public DurationField f23041i;

        /* renamed from: j  reason: collision with root package name */
        public DurationField f23042j;

        /* renamed from: k  reason: collision with root package name */
        public DurationField f23043k;

        /* renamed from: l  reason: collision with root package name */
        public DurationField f23044l;

        /* renamed from: m  reason: collision with root package name */
        public DateTimeField f23045m;

        /* renamed from: n  reason: collision with root package name */
        public DateTimeField f23046n;

        /* renamed from: o  reason: collision with root package name */
        public DateTimeField f23047o;

        /* renamed from: p  reason: collision with root package name */
        public DateTimeField f23048p;

        /* renamed from: q  reason: collision with root package name */
        public DateTimeField f23049q;

        /* renamed from: r  reason: collision with root package name */
        public DateTimeField f23050r;

        /* renamed from: s  reason: collision with root package name */
        public DateTimeField f23051s;

        /* renamed from: t  reason: collision with root package name */
        public DateTimeField f23052t;

        /* renamed from: u  reason: collision with root package name */
        public DateTimeField f23053u;

        /* renamed from: v  reason: collision with root package name */
        public DateTimeField f23054v;

        /* renamed from: w  reason: collision with root package name */
        public DateTimeField f23055w;

        /* renamed from: x  reason: collision with root package name */
        public DateTimeField f23056x;

        /* renamed from: y  reason: collision with root package name */
        public DateTimeField f23057y;

        /* renamed from: z  reason: collision with root package name */
        public DateTimeField f23058z;

        public static boolean b(DateTimeField dateTimeField) {
            if (dateTimeField == null) {
                return false;
            }
            return dateTimeField.isSupported();
        }

        public static boolean c(DurationField durationField) {
            if (durationField == null) {
                return false;
            }
            return durationField.isSupported();
        }

        public void a(Chronology chronology) {
            DurationField millis = chronology.millis();
            if (c(millis)) {
                this.f23033a = millis;
            }
            DurationField seconds = chronology.seconds();
            if (c(seconds)) {
                this.f23034b = seconds;
            }
            DurationField minutes = chronology.minutes();
            if (c(minutes)) {
                this.f23035c = minutes;
            }
            DurationField hours = chronology.hours();
            if (c(hours)) {
                this.f23036d = hours;
            }
            DurationField halfdays = chronology.halfdays();
            if (c(halfdays)) {
                this.f23037e = halfdays;
            }
            DurationField days = chronology.days();
            if (c(days)) {
                this.f23038f = days;
            }
            DurationField weeks = chronology.weeks();
            if (c(weeks)) {
                this.f23039g = weeks;
            }
            DurationField weekyears = chronology.weekyears();
            if (c(weekyears)) {
                this.f23040h = weekyears;
            }
            DurationField months = chronology.months();
            if (c(months)) {
                this.f23041i = months;
            }
            DurationField years = chronology.years();
            if (c(years)) {
                this.f23042j = years;
            }
            DurationField centuries = chronology.centuries();
            if (c(centuries)) {
                this.f23043k = centuries;
            }
            DurationField eras = chronology.eras();
            if (c(eras)) {
                this.f23044l = eras;
            }
            DateTimeField millisOfSecond = chronology.millisOfSecond();
            if (b(millisOfSecond)) {
                this.f23045m = millisOfSecond;
            }
            DateTimeField millisOfDay = chronology.millisOfDay();
            if (b(millisOfDay)) {
                this.f23046n = millisOfDay;
            }
            DateTimeField secondOfMinute = chronology.secondOfMinute();
            if (b(secondOfMinute)) {
                this.f23047o = secondOfMinute;
            }
            DateTimeField secondOfDay = chronology.secondOfDay();
            if (b(secondOfDay)) {
                this.f23048p = secondOfDay;
            }
            DateTimeField minuteOfHour = chronology.minuteOfHour();
            if (b(minuteOfHour)) {
                this.f23049q = minuteOfHour;
            }
            DateTimeField minuteOfDay = chronology.minuteOfDay();
            if (b(minuteOfDay)) {
                this.f23050r = minuteOfDay;
            }
            DateTimeField hourOfDay = chronology.hourOfDay();
            if (b(hourOfDay)) {
                this.f23051s = hourOfDay;
            }
            DateTimeField clockhourOfDay = chronology.clockhourOfDay();
            if (b(clockhourOfDay)) {
                this.f23052t = clockhourOfDay;
            }
            DateTimeField hourOfHalfday = chronology.hourOfHalfday();
            if (b(hourOfHalfday)) {
                this.f23053u = hourOfHalfday;
            }
            DateTimeField clockhourOfHalfday = chronology.clockhourOfHalfday();
            if (b(clockhourOfHalfday)) {
                this.f23054v = clockhourOfHalfday;
            }
            DateTimeField halfdayOfDay = chronology.halfdayOfDay();
            if (b(halfdayOfDay)) {
                this.f23055w = halfdayOfDay;
            }
            DateTimeField dayOfWeek = chronology.dayOfWeek();
            if (b(dayOfWeek)) {
                this.f23056x = dayOfWeek;
            }
            DateTimeField dayOfMonth = chronology.dayOfMonth();
            if (b(dayOfMonth)) {
                this.f23057y = dayOfMonth;
            }
            DateTimeField dayOfYear = chronology.dayOfYear();
            if (b(dayOfYear)) {
                this.f23058z = dayOfYear;
            }
            DateTimeField weekOfWeekyear = chronology.weekOfWeekyear();
            if (b(weekOfWeekyear)) {
                this.A = weekOfWeekyear;
            }
            DateTimeField weekyear = chronology.weekyear();
            if (b(weekyear)) {
                this.B = weekyear;
            }
            DateTimeField weekyearOfCentury = chronology.weekyearOfCentury();
            if (b(weekyearOfCentury)) {
                this.C = weekyearOfCentury;
            }
            DateTimeField monthOfYear = chronology.monthOfYear();
            if (b(monthOfYear)) {
                this.D = monthOfYear;
            }
            DateTimeField year = chronology.year();
            if (b(year)) {
                this.E = year;
            }
            DateTimeField yearOfEra = chronology.yearOfEra();
            if (b(yearOfEra)) {
                this.F = yearOfEra;
            }
            DateTimeField yearOfCentury = chronology.yearOfCentury();
            if (b(yearOfCentury)) {
                this.G = yearOfCentury;
            }
            DateTimeField centuryOfEra = chronology.centuryOfEra();
            if (b(centuryOfEra)) {
                this.H = centuryOfEra;
            }
            DateTimeField era = chronology.era();
            if (b(era)) {
                this.I = era;
            }
        }
    }

    public AssembledChronology(Chronology chronology, Object obj) {
        this.iBase = chronology;
        this.iParam = obj;
        setFields();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setFields();
    }

    private void setFields() {
        a aVar = new a();
        Chronology chronology = this.iBase;
        if (chronology != null) {
            aVar.a(chronology);
        }
        assemble(aVar);
        DurationField durationField = aVar.f23033a;
        if (durationField == null) {
            durationField = super.millis();
        }
        this.iMillis = durationField;
        DurationField durationField2 = aVar.f23034b;
        if (durationField2 == null) {
            durationField2 = super.seconds();
        }
        this.iSeconds = durationField2;
        DurationField durationField3 = aVar.f23035c;
        if (durationField3 == null) {
            durationField3 = super.minutes();
        }
        this.iMinutes = durationField3;
        DurationField durationField4 = aVar.f23036d;
        if (durationField4 == null) {
            durationField4 = super.hours();
        }
        this.iHours = durationField4;
        DurationField durationField5 = aVar.f23037e;
        if (durationField5 == null) {
            durationField5 = super.halfdays();
        }
        this.iHalfdays = durationField5;
        DurationField durationField6 = aVar.f23038f;
        if (durationField6 == null) {
            durationField6 = super.days();
        }
        this.iDays = durationField6;
        DurationField durationField7 = aVar.f23039g;
        if (durationField7 == null) {
            durationField7 = super.weeks();
        }
        this.iWeeks = durationField7;
        DurationField durationField8 = aVar.f23040h;
        if (durationField8 == null) {
            durationField8 = super.weekyears();
        }
        this.iWeekyears = durationField8;
        DurationField durationField9 = aVar.f23041i;
        if (durationField9 == null) {
            durationField9 = super.months();
        }
        this.iMonths = durationField9;
        DurationField durationField10 = aVar.f23042j;
        if (durationField10 == null) {
            durationField10 = super.years();
        }
        this.iYears = durationField10;
        DurationField durationField11 = aVar.f23043k;
        if (durationField11 == null) {
            durationField11 = super.centuries();
        }
        this.iCenturies = durationField11;
        DurationField durationField12 = aVar.f23044l;
        if (durationField12 == null) {
            durationField12 = super.eras();
        }
        this.iEras = durationField12;
        DateTimeField dateTimeField = aVar.f23045m;
        if (dateTimeField == null) {
            dateTimeField = super.millisOfSecond();
        }
        this.iMillisOfSecond = dateTimeField;
        DateTimeField dateTimeField2 = aVar.f23046n;
        if (dateTimeField2 == null) {
            dateTimeField2 = super.millisOfDay();
        }
        this.iMillisOfDay = dateTimeField2;
        DateTimeField dateTimeField3 = aVar.f23047o;
        if (dateTimeField3 == null) {
            dateTimeField3 = super.secondOfMinute();
        }
        this.iSecondOfMinute = dateTimeField3;
        DateTimeField dateTimeField4 = aVar.f23048p;
        if (dateTimeField4 == null) {
            dateTimeField4 = super.secondOfDay();
        }
        this.iSecondOfDay = dateTimeField4;
        DateTimeField dateTimeField5 = aVar.f23049q;
        if (dateTimeField5 == null) {
            dateTimeField5 = super.minuteOfHour();
        }
        this.iMinuteOfHour = dateTimeField5;
        DateTimeField dateTimeField6 = aVar.f23050r;
        if (dateTimeField6 == null) {
            dateTimeField6 = super.minuteOfDay();
        }
        this.iMinuteOfDay = dateTimeField6;
        DateTimeField dateTimeField7 = aVar.f23051s;
        if (dateTimeField7 == null) {
            dateTimeField7 = super.hourOfDay();
        }
        this.iHourOfDay = dateTimeField7;
        DateTimeField dateTimeField8 = aVar.f23052t;
        if (dateTimeField8 == null) {
            dateTimeField8 = super.clockhourOfDay();
        }
        this.iClockhourOfDay = dateTimeField8;
        DateTimeField dateTimeField9 = aVar.f23053u;
        if (dateTimeField9 == null) {
            dateTimeField9 = super.hourOfHalfday();
        }
        this.iHourOfHalfday = dateTimeField9;
        DateTimeField dateTimeField10 = aVar.f23054v;
        if (dateTimeField10 == null) {
            dateTimeField10 = super.clockhourOfHalfday();
        }
        this.iClockhourOfHalfday = dateTimeField10;
        DateTimeField dateTimeField11 = aVar.f23055w;
        if (dateTimeField11 == null) {
            dateTimeField11 = super.halfdayOfDay();
        }
        this.iHalfdayOfDay = dateTimeField11;
        DateTimeField dateTimeField12 = aVar.f23056x;
        if (dateTimeField12 == null) {
            dateTimeField12 = super.dayOfWeek();
        }
        this.iDayOfWeek = dateTimeField12;
        DateTimeField dateTimeField13 = aVar.f23057y;
        if (dateTimeField13 == null) {
            dateTimeField13 = super.dayOfMonth();
        }
        this.iDayOfMonth = dateTimeField13;
        DateTimeField dateTimeField14 = aVar.f23058z;
        if (dateTimeField14 == null) {
            dateTimeField14 = super.dayOfYear();
        }
        this.iDayOfYear = dateTimeField14;
        DateTimeField dateTimeField15 = aVar.A;
        if (dateTimeField15 == null) {
            dateTimeField15 = super.weekOfWeekyear();
        }
        this.iWeekOfWeekyear = dateTimeField15;
        DateTimeField dateTimeField16 = aVar.B;
        if (dateTimeField16 == null) {
            dateTimeField16 = super.weekyear();
        }
        this.iWeekyear = dateTimeField16;
        DateTimeField dateTimeField17 = aVar.C;
        if (dateTimeField17 == null) {
            dateTimeField17 = super.weekyearOfCentury();
        }
        this.iWeekyearOfCentury = dateTimeField17;
        DateTimeField dateTimeField18 = aVar.D;
        if (dateTimeField18 == null) {
            dateTimeField18 = super.monthOfYear();
        }
        this.iMonthOfYear = dateTimeField18;
        DateTimeField dateTimeField19 = aVar.E;
        if (dateTimeField19 == null) {
            dateTimeField19 = super.year();
        }
        this.iYear = dateTimeField19;
        DateTimeField dateTimeField20 = aVar.F;
        if (dateTimeField20 == null) {
            dateTimeField20 = super.yearOfEra();
        }
        this.iYearOfEra = dateTimeField20;
        DateTimeField dateTimeField21 = aVar.G;
        if (dateTimeField21 == null) {
            dateTimeField21 = super.yearOfCentury();
        }
        this.iYearOfCentury = dateTimeField21;
        DateTimeField dateTimeField22 = aVar.H;
        if (dateTimeField22 == null) {
            dateTimeField22 = super.centuryOfEra();
        }
        this.iCenturyOfEra = dateTimeField22;
        DateTimeField dateTimeField23 = aVar.I;
        if (dateTimeField23 == null) {
            dateTimeField23 = super.era();
        }
        this.iEra = dateTimeField23;
        Chronology chronology2 = this.iBase;
        int i11 = 0;
        if (chronology2 != null) {
            int i12 = ((this.iHourOfDay == chronology2.hourOfDay() && this.iMinuteOfHour == this.iBase.minuteOfHour() && this.iSecondOfMinute == this.iBase.secondOfMinute() && this.iMillisOfSecond == this.iBase.millisOfSecond()) ? 1 : 0) | (this.iMillisOfDay == this.iBase.millisOfDay() ? 2 : 0);
            if (this.iYear == this.iBase.year() && this.iMonthOfYear == this.iBase.monthOfYear() && this.iDayOfMonth == this.iBase.dayOfMonth()) {
                i11 = 4;
            }
            i11 |= i12;
        }
        this.iBaseFlags = i11;
    }

    public abstract void assemble(a aVar);

    public final DurationField centuries() {
        return this.iCenturies;
    }

    public final DateTimeField centuryOfEra() {
        return this.iCenturyOfEra;
    }

    public final DateTimeField clockhourOfDay() {
        return this.iClockhourOfDay;
    }

    public final DateTimeField clockhourOfHalfday() {
        return this.iClockhourOfHalfday;
    }

    public final DateTimeField dayOfMonth() {
        return this.iDayOfMonth;
    }

    public final DateTimeField dayOfWeek() {
        return this.iDayOfWeek;
    }

    public final DateTimeField dayOfYear() {
        return this.iDayOfYear;
    }

    public final DurationField days() {
        return this.iDays;
    }

    public final DateTimeField era() {
        return this.iEra;
    }

    public final DurationField eras() {
        return this.iEras;
    }

    public final Chronology getBase() {
        return this.iBase;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        Chronology chronology = this.iBase;
        if (chronology == null || (this.iBaseFlags & 6) != 6) {
            return super.getDateTimeMillis(i11, i12, i13, i14);
        }
        return chronology.getDateTimeMillis(i11, i12, i13, i14);
    }

    public final Object getParam() {
        return this.iParam;
    }

    public DateTimeZone getZone() {
        Chronology chronology = this.iBase;
        if (chronology != null) {
            return chronology.getZone();
        }
        return null;
    }

    public final DateTimeField halfdayOfDay() {
        return this.iHalfdayOfDay;
    }

    public final DurationField halfdays() {
        return this.iHalfdays;
    }

    public final DateTimeField hourOfDay() {
        return this.iHourOfDay;
    }

    public final DateTimeField hourOfHalfday() {
        return this.iHourOfHalfday;
    }

    public final DurationField hours() {
        return this.iHours;
    }

    public final DurationField millis() {
        return this.iMillis;
    }

    public final DateTimeField millisOfDay() {
        return this.iMillisOfDay;
    }

    public final DateTimeField millisOfSecond() {
        return this.iMillisOfSecond;
    }

    public final DateTimeField minuteOfDay() {
        return this.iMinuteOfDay;
    }

    public final DateTimeField minuteOfHour() {
        return this.iMinuteOfHour;
    }

    public final DurationField minutes() {
        return this.iMinutes;
    }

    public final DateTimeField monthOfYear() {
        return this.iMonthOfYear;
    }

    public final DurationField months() {
        return this.iMonths;
    }

    public final DateTimeField secondOfDay() {
        return this.iSecondOfDay;
    }

    public final DateTimeField secondOfMinute() {
        return this.iSecondOfMinute;
    }

    public final DurationField seconds() {
        return this.iSeconds;
    }

    public final DateTimeField weekOfWeekyear() {
        return this.iWeekOfWeekyear;
    }

    public final DurationField weeks() {
        return this.iWeeks;
    }

    public final DateTimeField weekyear() {
        return this.iWeekyear;
    }

    public final DateTimeField weekyearOfCentury() {
        return this.iWeekyearOfCentury;
    }

    public final DurationField weekyears() {
        return this.iWeekyears;
    }

    public final DateTimeField year() {
        return this.iYear;
    }

    public final DateTimeField yearOfCentury() {
        return this.iYearOfCentury;
    }

    public final DateTimeField yearOfEra() {
        return this.iYearOfEra;
    }

    public final DurationField years() {
        return this.iYears;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        Chronology chronology = this.iBase;
        if (chronology == null || (this.iBaseFlags & 5) != 5) {
            return super.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
        }
        return chronology.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
    }

    public long getDateTimeMillis(long j11, int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        Chronology chronology = this.iBase;
        if (chronology == null || (this.iBaseFlags & 1) != 1) {
            return super.getDateTimeMillis(j11, i11, i12, i13, i14);
        }
        return chronology.getDateTimeMillis(j11, i11, i12, i13, i14);
    }
}
