package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.format.a;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class YearMonth extends BasePartial {
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;
    private static final long serialVersionUID = 797544782896179L;

    public YearMonth() {
    }

    public static YearMonth fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonth(calendar.get(1), calendar.get(2) + 1);
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonth fromDateFields(Date date) {
        if (date != null) {
            return new YearMonth(date.getYear() + 1900, date.getMonth() + 1);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static YearMonth now() {
        return new YearMonth();
    }

    @FromString
    public static YearMonth parse(String str) {
        return parse(str, i.m());
    }

    private Object readResolve() {
        return !DateTimeZone.UTC.equals(getChronology().getZone()) ? new YearMonth(this, getChronology().withUTC()) : this;
    }

    public DateTimeField getField(int i11, Chronology chronology) {
        if (i11 == 0) {
            return chronology.year();
        }
        if (i11 == 1) {
            return chronology.monthOfYear();
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

    public YearMonth minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public YearMonth minusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), e.j(i11));
    }

    public YearMonth minusYears(int i11) {
        return withFieldAdded(DurationFieldType.years(), e.j(i11));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonth plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public YearMonth plusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), i11);
    }

    public YearMonth plusYears(int i11) {
        return withFieldAdded(DurationFieldType.years(), i11);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public int size() {
        return 2;
    }

    public Interval toInterval() {
        return toInterval((DateTimeZone) null);
    }

    public LocalDate toLocalDate(int i11) {
        return new LocalDate(getYear(), getMonthOfYear(), i11, getChronology());
    }

    @ToString
    public String toString() {
        return i.t().l(this);
    }

    public YearMonth withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonth yearMonth = new YearMonth(this, withUTC);
        withUTC.validate(yearMonth, getValues());
        return yearMonth;
    }

    public YearMonth withField(DateTimeFieldType dateTimeFieldType, int i11) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i11 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonth(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i11));
    }

    public YearMonth withFieldAdded(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new YearMonth(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i11));
    }

    public YearMonth withMonthOfYear(int i11) {
        return new YearMonth(this, getChronology().monthOfYear().set(this, 1, getValues(), i11));
    }

    public YearMonth withPeriodAdded(i iVar, int i11) {
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
        return new YearMonth(this, values);
    }

    public YearMonth withYear(int i11) {
        return new YearMonth(this, getChronology().year().set(this, 0, getValues(), i11));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonth(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static YearMonth now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new YearMonth(dateTimeZone);
    }

    public static YearMonth parse(String str, b bVar) {
        LocalDate g11 = bVar.g(str);
        return new YearMonth(g11.getYear(), g11.getMonthOfYear());
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        return new Interval((f) toLocalDate(1).toDateTimeAtStartOfDay(m11), (f) plusMonths(1).toLocalDate(1).toDateTimeAtStartOfDay(m11));
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return a.b(str).l(this);
    }

    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final YearMonth iBase;
        private final int iFieldIndex;

        public Property(YearMonth yearMonth, int i11) {
            this.iBase = yearMonth;
            this.iFieldIndex = i11;
        }

        public YearMonth addToCopy(int i11) {
            return new YearMonth(this.iBase, getField().add(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public YearMonth addWrapFieldToCopy(int i11) {
            return new YearMonth(this.iBase, getField().addWrapField(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public int get() {
            return this.iBase.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iBase.getField(this.iFieldIndex);
        }

        public h getReadablePartial() {
            return this.iBase;
        }

        public YearMonth getYearMonth() {
            return this.iBase;
        }

        public YearMonth setCopy(int i11) {
            return new YearMonth(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public YearMonth setCopy(String str, Locale locale) {
            return new YearMonth(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), str, locale));
        }

        public YearMonth setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public YearMonth(Chronology chronology) {
        super(chronology);
    }

    public YearMonth(long j11) {
        super(j11);
    }

    public static YearMonth now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new YearMonth(chronology);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return a.b(str).v(locale).l(this);
    }

    public YearMonth(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public YearMonth(Object obj) {
        super(obj, (Chronology) null, i.m());
    }

    public YearMonth(Object obj, Chronology chronology) {
        super(obj, a.c(chronology), i.m());
    }

    public YearMonth(int i11, int i12) {
        this(i11, i12, (Chronology) null);
    }

    public YearMonth(int i11, int i12, Chronology chronology) {
        super(new int[]{i11, i12}, chronology);
    }

    public YearMonth(YearMonth yearMonth, int[] iArr) {
        super((BasePartial) yearMonth, iArr);
    }

    public YearMonth(YearMonth yearMonth, Chronology chronology) {
        super((BasePartial) yearMonth, chronology);
    }
}
