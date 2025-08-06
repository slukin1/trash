package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.a;
import org.joda.time.field.e;
import org.joda.time.format.i;

@Deprecated
public final class YearMonthDay extends BasePartial {
    public static final int DAY_OF_MONTH = 2;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;
    private static final long serialVersionUID = 797544782896179L;

    public YearMonthDay() {
    }

    public static YearMonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonthDay(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonthDay fromDateFields(Date date) {
        if (date != null) {
            return new YearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public Property dayOfMonth() {
        return new Property(this, 2);
    }

    public int getDayOfMonth() {
        return getValue(2);
    }

    public DateTimeField getField(int i11, Chronology chronology) {
        if (i11 == 0) {
            return chronology.year();
        }
        if (i11 == 1) {
            return chronology.monthOfYear();
        }
        if (i11 == 2) {
            return chronology.dayOfMonth();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public DateTimeFieldType getFieldType(int i11) {
        return FIELD_TYPES[i11];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) FIELD_TYPES.clone();
    }

    public int getMonthOfYear() {
        return getValue(1);
    }

    public int getYear() {
        return getValue(0);
    }

    public YearMonthDay minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public YearMonthDay minusDays(int i11) {
        return withFieldAdded(DurationFieldType.days(), e.j(i11));
    }

    public YearMonthDay minusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), e.j(i11));
    }

    public YearMonthDay minusYears(int i11) {
        return withFieldAdded(DurationFieldType.years(), e.j(i11));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonthDay plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public YearMonthDay plusDays(int i11) {
        return withFieldAdded(DurationFieldType.days(), i11);
    }

    public YearMonthDay plusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), i11);
    }

    public YearMonthDay plusYears(int i11) {
        return withFieldAdded(DurationFieldType.years(), i11);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public int size() {
        return 3;
    }

    public DateMidnight toDateMidnight() {
        return toDateMidnight((DateTimeZone) null);
    }

    public DateTime toDateTime(TimeOfDay timeOfDay) {
        return toDateTime(timeOfDay, (DateTimeZone) null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime((DateTimeZone) null);
    }

    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight((DateTimeZone) null);
    }

    public Interval toInterval() {
        return toInterval((DateTimeZone) null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    public String toString() {
        return i.u().l(this);
    }

    public YearMonthDay withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonthDay yearMonthDay = new YearMonthDay(this, withUTC);
        withUTC.validate(yearMonthDay, getValues());
        return yearMonthDay;
    }

    public YearMonthDay withDayOfMonth(int i11) {
        return new YearMonthDay(this, getChronology().dayOfMonth().set(this, 2, getValues(), i11));
    }

    public YearMonthDay withField(DateTimeFieldType dateTimeFieldType, int i11) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i11 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i11));
    }

    public YearMonthDay withFieldAdded(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i11));
    }

    public YearMonthDay withMonthOfYear(int i11) {
        return new YearMonthDay(this, getChronology().monthOfYear().set(this, 1, getValues(), i11));
    }

    public YearMonthDay withPeriodAdded(i iVar, int i11) {
        if (iVar == null || i11 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i12 = 0; i12 < iVar.size(); i12++) {
            int indexOf = indexOf(iVar.getFieldType(i12));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, e.g(iVar.getValue(i12), i11));
            }
        }
        return new YearMonthDay(this, values);
    }

    public YearMonthDay withYear(int i11) {
        return new YearMonthDay(this, getChronology().year().set(this, 0, getValues(), i11));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonthDay(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTime(TimeOfDay timeOfDay, DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        long j11 = withZone.set(this, a.b());
        if (timeOfDay != null) {
            j11 = withZone.set(timeOfDay, j11);
        }
        return new DateTime(j11, withZone);
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, a.b()), withZone);
    }

    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(dateTimeZone));
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        return toDateMidnight(a.m(dateTimeZone)).toInterval();
    }

    @Deprecated
    public static class Property extends a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final int iFieldIndex;
        private final YearMonthDay iYearMonthDay;

        public Property(YearMonthDay yearMonthDay, int i11) {
            this.iYearMonthDay = yearMonthDay;
            this.iFieldIndex = i11;
        }

        public YearMonthDay addToCopy(int i11) {
            return new YearMonthDay(this.iYearMonthDay, getField().add(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i11));
        }

        public YearMonthDay addWrapFieldToCopy(int i11) {
            return new YearMonthDay(this.iYearMonthDay, getField().addWrapField(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i11));
        }

        public int get() {
            return this.iYearMonthDay.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iYearMonthDay.getField(this.iFieldIndex);
        }

        public h getReadablePartial() {
            return this.iYearMonthDay;
        }

        public YearMonthDay getYearMonthDay() {
            return this.iYearMonthDay;
        }

        public YearMonthDay setCopy(int i11) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i11));
        }

        public YearMonthDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public YearMonthDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public YearMonthDay setCopy(String str, Locale locale) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), str, locale));
        }

        public YearMonthDay setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public YearMonthDay(Chronology chronology) {
        super(chronology);
    }

    public YearMonthDay(long j11) {
        super(j11);
    }

    public YearMonthDay(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public YearMonthDay(Object obj) {
        super(obj, (Chronology) null, i.g());
    }

    public YearMonthDay(Object obj, Chronology chronology) {
        super(obj, a.c(chronology), i.g());
    }

    public YearMonthDay(int i11, int i12, int i13) {
        this(i11, i12, i13, (Chronology) null);
    }

    public YearMonthDay(int i11, int i12, int i13, Chronology chronology) {
        super(new int[]{i11, i12, i13}, chronology);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, int[] iArr) {
        super((BasePartial) yearMonthDay, iArr);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, Chronology chronology) {
        super((BasePartial) yearMonthDay, chronology);
    }
}
