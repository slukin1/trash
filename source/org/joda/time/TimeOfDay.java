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
public final class TimeOfDay extends BasePartial {
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond()};
    public static final int HOUR_OF_DAY = 0;
    public static final TimeOfDay MIDNIGHT = new TimeOfDay(0, 0, 0, 0);
    public static final int MILLIS_OF_SECOND = 3;
    public static final int MINUTE_OF_HOUR = 1;
    public static final int SECOND_OF_MINUTE = 2;
    private static final long serialVersionUID = 3633353405803318660L;

    public TimeOfDay() {
    }

    public static TimeOfDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new TimeOfDay(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static TimeOfDay fromDateFields(Date date) {
        if (date != null) {
            return new TimeOfDay(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static TimeOfDay fromMillisOfDay(long j11) {
        return fromMillisOfDay(j11, (Chronology) null);
    }

    public DateTimeField getField(int i11, Chronology chronology) {
        if (i11 == 0) {
            return chronology.hourOfDay();
        }
        if (i11 == 1) {
            return chronology.minuteOfHour();
        }
        if (i11 == 2) {
            return chronology.secondOfMinute();
        }
        if (i11 == 3) {
            return chronology.millisOfSecond();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public DateTimeFieldType getFieldType(int i11) {
        return FIELD_TYPES[i11];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) FIELD_TYPES.clone();
    }

    public int getHourOfDay() {
        return getValue(0);
    }

    public int getMillisOfSecond() {
        return getValue(3);
    }

    public int getMinuteOfHour() {
        return getValue(1);
    }

    public int getSecondOfMinute() {
        return getValue(2);
    }

    public Property hourOfDay() {
        return new Property(this, 0);
    }

    public Property millisOfSecond() {
        return new Property(this, 3);
    }

    public TimeOfDay minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public TimeOfDay minusHours(int i11) {
        return withFieldAdded(DurationFieldType.hours(), e.j(i11));
    }

    public TimeOfDay minusMillis(int i11) {
        return withFieldAdded(DurationFieldType.millis(), e.j(i11));
    }

    public TimeOfDay minusMinutes(int i11) {
        return withFieldAdded(DurationFieldType.minutes(), e.j(i11));
    }

    public TimeOfDay minusSeconds(int i11) {
        return withFieldAdded(DurationFieldType.seconds(), e.j(i11));
    }

    public Property minuteOfHour() {
        return new Property(this, 1);
    }

    public TimeOfDay plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public TimeOfDay plusHours(int i11) {
        return withFieldAdded(DurationFieldType.hours(), i11);
    }

    public TimeOfDay plusMillis(int i11) {
        return withFieldAdded(DurationFieldType.millis(), i11);
    }

    public TimeOfDay plusMinutes(int i11) {
        return withFieldAdded(DurationFieldType.minutes(), i11);
    }

    public TimeOfDay plusSeconds(int i11) {
        return withFieldAdded(DurationFieldType.seconds(), i11);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public Property secondOfMinute() {
        return new Property(this, 2);
    }

    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday((DateTimeZone) null);
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), getChronology());
    }

    public String toString() {
        return i.o().l(this);
    }

    public TimeOfDay withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        TimeOfDay timeOfDay = new TimeOfDay(this, withUTC);
        withUTC.validate(timeOfDay, getValues());
        return timeOfDay;
    }

    public TimeOfDay withField(DateTimeFieldType dateTimeFieldType, int i11) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i11 == getValue(indexOfSupported)) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i11));
    }

    public TimeOfDay withFieldAdded(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i11));
    }

    public TimeOfDay withHourOfDay(int i11) {
        return new TimeOfDay(this, getChronology().hourOfDay().set(this, 0, getValues(), i11));
    }

    public TimeOfDay withMillisOfSecond(int i11) {
        return new TimeOfDay(this, getChronology().millisOfSecond().set(this, 3, getValues(), i11));
    }

    public TimeOfDay withMinuteOfHour(int i11) {
        return new TimeOfDay(this, getChronology().minuteOfHour().set(this, 1, getValues(), i11));
    }

    public TimeOfDay withPeriodAdded(i iVar, int i11) {
        if (iVar == null || i11 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i12 = 0; i12 < iVar.size(); i12++) {
            int indexOf = indexOf(iVar.getFieldType(i12));
            if (indexOf >= 0) {
                values = getField(indexOf).addWrapPartial(this, indexOf, values, e.g(iVar.getValue(i12), i11));
            }
        }
        return new TimeOfDay(this, values);
    }

    public TimeOfDay withSecondOfMinute(int i11) {
        return new TimeOfDay(this, getChronology().secondOfMinute().set(this, 2, getValues(), i11));
    }

    public TimeOfDay(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static TimeOfDay fromMillisOfDay(long j11, Chronology chronology) {
        return new TimeOfDay(j11, a.c(chronology).withUTC());
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, a.b()), withZone);
    }

    @Deprecated
    public static class Property extends a implements Serializable {
        private static final long serialVersionUID = 5598459141741063833L;
        private final int iFieldIndex;
        private final TimeOfDay iTimeOfDay;

        public Property(TimeOfDay timeOfDay, int i11) {
            this.iTimeOfDay = timeOfDay;
            this.iFieldIndex = i11;
        }

        public TimeOfDay addNoWrapToCopy(int i11) {
            return new TimeOfDay(this.iTimeOfDay, getField().add(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i11));
        }

        public TimeOfDay addToCopy(int i11) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapPartial(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i11));
        }

        public TimeOfDay addWrapFieldToCopy(int i11) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapField(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i11));
        }

        public int get() {
            return this.iTimeOfDay.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iTimeOfDay.getField(this.iFieldIndex);
        }

        public h getReadablePartial() {
            return this.iTimeOfDay;
        }

        public TimeOfDay getTimeOfDay() {
            return this.iTimeOfDay;
        }

        public TimeOfDay setCopy(int i11) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i11));
        }

        public TimeOfDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public TimeOfDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public TimeOfDay setCopy(String str, Locale locale) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), str, locale));
        }

        public TimeOfDay setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public TimeOfDay(Chronology chronology) {
        super(chronology);
    }

    public TimeOfDay(long j11) {
        super(j11);
    }

    public TimeOfDay(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public TimeOfDay(Object obj) {
        super(obj, (Chronology) null, i.r());
    }

    public TimeOfDay(Object obj, Chronology chronology) {
        super(obj, a.c(chronology), i.r());
    }

    public TimeOfDay(int i11, int i12) {
        this(i11, i12, 0, 0, (Chronology) null);
    }

    public TimeOfDay(int i11, int i12, Chronology chronology) {
        this(i11, i12, 0, 0, chronology);
    }

    public TimeOfDay(int i11, int i12, int i13) {
        this(i11, i12, i13, 0, (Chronology) null);
    }

    public TimeOfDay(int i11, int i12, int i13, Chronology chronology) {
        this(i11, i12, i13, 0, chronology);
    }

    public TimeOfDay(int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14, (Chronology) null);
    }

    public TimeOfDay(int i11, int i12, int i13, int i14, Chronology chronology) {
        super(new int[]{i11, i12, i13, i14}, chronology);
    }

    public TimeOfDay(TimeOfDay timeOfDay, int[] iArr) {
        super((BasePartial) timeOfDay, iArr);
    }

    public TimeOfDay(TimeOfDay timeOfDay, Chronology chronology) {
        super((BasePartial) timeOfDay, chronology);
    }
}
