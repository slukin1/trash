package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.a;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class MonthDay extends BasePartial {
    public static final int DAY_OF_MONTH = 1;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    public static final int MONTH_OF_YEAR = 0;
    private static final b PARSER = new DateTimeFormatterBuilder().E(i.m().b()).E(a.b("--MM-dd").b()).e0();
    private static final long serialVersionUID = 2954560699050434609L;

    public MonthDay() {
    }

    public static MonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new MonthDay(calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static MonthDay fromDateFields(Date date) {
        if (date != null) {
            return new MonthDay(date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static MonthDay now() {
        return new MonthDay();
    }

    @FromString
    public static MonthDay parse(String str) {
        return parse(str, PARSER);
    }

    private Object readResolve() {
        return !DateTimeZone.UTC.equals(getChronology().getZone()) ? new MonthDay(this, getChronology().withUTC()) : this;
    }

    public Property dayOfMonth() {
        return new Property(this, 1);
    }

    public int getDayOfMonth() {
        return getValue(1);
    }

    public DateTimeField getField(int i11, Chronology chronology) {
        if (i11 == 0) {
            return chronology.monthOfYear();
        }
        if (i11 == 1) {
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
        return getValue(0);
    }

    public MonthDay minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public MonthDay minusDays(int i11) {
        return withFieldAdded(DurationFieldType.days(), e.j(i11));
    }

    public MonthDay minusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), e.j(i11));
    }

    public Property monthOfYear() {
        return new Property(this, 0);
    }

    public MonthDay plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public MonthDay plusDays(int i11) {
        return withFieldAdded(DurationFieldType.days(), i11);
    }

    public MonthDay plusMonths(int i11) {
        return withFieldAdded(DurationFieldType.months(), i11);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public int size() {
        return 2;
    }

    public LocalDate toLocalDate(int i11) {
        return new LocalDate(i11, getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    @ToString
    public String toString() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DateTimeFieldType.monthOfYear());
        arrayList.add(DateTimeFieldType.dayOfMonth());
        return i.j(arrayList, true, true).l(this);
    }

    public MonthDay withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        MonthDay monthDay = new MonthDay(this, withUTC);
        withUTC.validate(monthDay, getValues());
        return monthDay;
    }

    public MonthDay withDayOfMonth(int i11) {
        return new MonthDay(this, getChronology().dayOfMonth().set(this, 1, getValues(), i11));
    }

    public MonthDay withField(DateTimeFieldType dateTimeFieldType, int i11) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i11 == getValue(indexOfSupported)) {
            return this;
        }
        return new MonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i11));
    }

    public MonthDay withFieldAdded(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new MonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i11));
    }

    public MonthDay withMonthOfYear(int i11) {
        return new MonthDay(this, getChronology().monthOfYear().set(this, 0, getValues(), i11));
    }

    public MonthDay withPeriodAdded(i iVar, int i11) {
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
        return new MonthDay(this, values);
    }

    public MonthDay(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static MonthDay now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new MonthDay(dateTimeZone);
    }

    public static MonthDay parse(String str, b bVar) {
        LocalDate g11 = bVar.g(str);
        return new MonthDay(g11.getMonthOfYear(), g11.getDayOfMonth());
    }

    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final MonthDay iBase;
        private final int iFieldIndex;

        public Property(MonthDay monthDay, int i11) {
            this.iBase = monthDay;
            this.iFieldIndex = i11;
        }

        public MonthDay addToCopy(int i11) {
            return new MonthDay(this.iBase, getField().add(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public MonthDay addWrapFieldToCopy(int i11) {
            return new MonthDay(this.iBase, getField().addWrapField(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public int get() {
            return this.iBase.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iBase.getField(this.iFieldIndex);
        }

        public MonthDay getMonthDay() {
            return this.iBase;
        }

        public h getReadablePartial() {
            return this.iBase;
        }

        public MonthDay setCopy(int i11) {
            return new MonthDay(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), i11));
        }

        public MonthDay setCopy(String str, Locale locale) {
            return new MonthDay(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), str, locale));
        }

        public MonthDay setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public MonthDay(Chronology chronology) {
        super(chronology);
    }

    public MonthDay(long j11) {
        super(j11);
    }

    public static MonthDay now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new MonthDay(chronology);
    }

    public MonthDay(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return a.b(str).l(this);
    }

    public MonthDay(Object obj) {
        super(obj, (Chronology) null, i.m());
    }

    public MonthDay(Object obj, Chronology chronology) {
        super(obj, a.c(chronology), i.m());
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return a.b(str).v(locale).l(this);
    }

    public MonthDay(int i11, int i12) {
        this(i11, i12, (Chronology) null);
    }

    public MonthDay(int i11, int i12, Chronology chronology) {
        super(new int[]{i11, i12}, chronology);
    }

    public MonthDay(MonthDay monthDay, int[] iArr) {
        super((BasePartial) monthDay, iArr);
    }

    public MonthDay(MonthDay monthDay, Chronology chronology) {
        super((BasePartial) monthDay, chronology);
    }
}
