package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import m20.g;
import n20.d;
import n20.l;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.a;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class LocalDateTime extends g implements Serializable {
    private static final int DAY_OF_MONTH = 2;
    private static final int MILLIS_OF_DAY = 3;
    private static final int MONTH_OF_YEAR = 1;
    private static final int YEAR = 0;
    private static final long serialVersionUID = -268716875315837168L;
    private final Chronology iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -358138762846288L;
        private transient DateTimeField iField;
        private transient LocalDateTime iInstant;

        public Property(LocalDateTime localDateTime, DateTimeField dateTimeField) {
            this.iInstant = localDateTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalDateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalDateTime addToCopy(int i11) {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.add(localDateTime.getLocalMillis(), i11));
        }

        public LocalDateTime addWrapFieldToCopy(int i11) {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.addWrapField(localDateTime.getLocalMillis(), i11));
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public LocalDateTime getLocalDateTime() {
            return this.iInstant;
        }

        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalDateTime roundCeilingCopy() {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.roundCeiling(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundFloorCopy() {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.roundFloor(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfCeilingCopy() {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.roundHalfCeiling(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfEvenCopy() {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.roundHalfEven(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfFloorCopy() {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.roundHalfFloor(localDateTime.getLocalMillis()));
        }

        public LocalDateTime setCopy(int i11) {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.set(localDateTime.getLocalMillis(), i11));
        }

        public LocalDateTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDateTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDateTime addToCopy(long j11) {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.add(localDateTime.getLocalMillis(), j11));
        }

        public LocalDateTime setCopy(String str, Locale locale) {
            LocalDateTime localDateTime = this.iInstant;
            return localDateTime.withLocalMillis(this.iField.set(localDateTime.getLocalMillis(), str, locale));
        }

        public LocalDateTime setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public LocalDateTime() {
        this(a.b(), (Chronology) ISOChronology.getInstance());
    }

    private Date correctDstTransition(Date date, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(date);
        LocalDateTime fromCalendarFields = fromCalendarFields(instance);
        if (fromCalendarFields.isBefore(this)) {
            while (fromCalendarFields.isBefore(this)) {
                instance.setTimeInMillis(instance.getTimeInMillis() + 60000);
                fromCalendarFields = fromCalendarFields(instance);
            }
            while (!fromCalendarFields.isBefore(this)) {
                instance.setTimeInMillis(instance.getTimeInMillis() - 1000);
                fromCalendarFields = fromCalendarFields(instance);
            }
            instance.setTimeInMillis(instance.getTimeInMillis() + 1000);
        } else if (fromCalendarFields.equals(this)) {
            Calendar instance2 = Calendar.getInstance(timeZone);
            instance2.setTimeInMillis(instance.getTimeInMillis() - ((long) timeZone.getDSTSavings()));
            if (fromCalendarFields(instance2).equals(this)) {
                instance = instance2;
            }
        }
        return instance.getTime();
    }

    public static LocalDateTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            int i11 = calendar.get(0);
            int i12 = calendar.get(1);
            if (i11 != 1) {
                i12 = 1 - i12;
            }
            return new LocalDateTime(i12, calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalDateTime fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (date.getTime() >= 0) {
            return new LocalDateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return fromCalendarFields(gregorianCalendar);
        }
    }

    public static LocalDateTime now() {
        return new LocalDateTime();
    }

    @FromString
    public static LocalDateTime parse(String str) {
        return parse(str, i.l());
    }

    private Object readResolve() {
        Chronology chronology = this.iChronology;
        if (chronology == null) {
            return new LocalDateTime(this.iLocalMillis, (Chronology) ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(chronology.getZone()) ? new LocalDateTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Property dayOfMonth() {
        return new Property(this, getChronology().dayOfMonth());
    }

    public Property dayOfWeek() {
        return new Property(this, getChronology().dayOfWeek());
    }

    public Property dayOfYear() {
        return new Property(this, getChronology().dayOfYear());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                if (this.iLocalMillis == localDateTime.iLocalMillis) {
                    return true;
                }
                return false;
            }
        }
        return super.equals(obj);
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getLocalMillis());
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getLocalMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getLocalMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getLocalMillis());
    }

    public int getEra() {
        return getChronology().era().get(getLocalMillis());
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
        if (i11 == 3) {
            return chronology.millisOfDay();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getLocalMillis());
    }

    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getLocalMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getLocalMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getLocalMillis());
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    public int getValue(int i11) {
        if (i11 == 0) {
            return getChronology().year().get(getLocalMillis());
        }
        if (i11 == 1) {
            return getChronology().monthOfYear().get(getLocalMillis());
        }
        if (i11 == 2) {
            return getChronology().dayOfMonth().get(getLocalMillis());
        }
        if (i11 == 3) {
            return getChronology().millisOfDay().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getLocalMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getLocalMillis());
    }

    public int getYear() {
        return getChronology().year().get(getLocalMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getLocalMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getLocalMillis());
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalDateTime minus(e eVar) {
        return withDurationAdded(eVar, -1);
    }

    public LocalDateTime minusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i11));
    }

    public LocalDateTime minusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().years().subtract(getLocalMillis(), i11));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public LocalDateTime plus(e eVar) {
        return withDurationAdded(eVar, 1);
    }

    public LocalDateTime plusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().add(getLocalMillis(), i11));
    }

    public LocalDateTime plusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().years().add(getLocalMillis(), i11));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return new Property(this, dateTimeFieldType.getField(getChronology()));
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    public int size() {
        return 4;
    }

    public Date toDate() {
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        date.setTime(date.getTime() + ((long) getMillisOfSecond()));
        return correctDstTransition(date, TimeZone.getDefault());
    }

    public DateTime toDateTime() {
        return toDateTime((DateTimeZone) null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getLocalMillis(), getChronology());
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getLocalMillis(), getChronology());
    }

    @ToString
    public String toString() {
        return i.h().l(this);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public LocalDateTime withCenturyOfEra(int i11) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i11));
    }

    public LocalDateTime withDate(int i11, int i12, int i13) {
        Chronology chronology = getChronology();
        return withLocalMillis(chronology.dayOfMonth().set(chronology.monthOfYear().set(chronology.year().set(getLocalMillis(), i11), i12), i13));
    }

    public LocalDateTime withDayOfMonth(int i11) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i11));
    }

    public LocalDateTime withDayOfWeek(int i11) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i11));
    }

    public LocalDateTime withDayOfYear(int i11) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i11));
    }

    public LocalDateTime withDurationAdded(e eVar, int i11) {
        return (eVar == null || i11 == 0) ? this : withLocalMillis(getChronology().add(getLocalMillis(), eVar.getMillis(), i11));
    }

    public LocalDateTime withEra(int i11) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i11));
    }

    public LocalDateTime withField(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType != null) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i11));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDateTime withFieldAdded(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i11 == 0) {
            return this;
        } else {
            return withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i11));
        }
    }

    public LocalDateTime withFields(h hVar) {
        return hVar == null ? this : withLocalMillis(getChronology().set(hVar, getLocalMillis()));
    }

    public LocalDateTime withHourOfDay(int i11) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i11));
    }

    public LocalDateTime withLocalMillis(long j11) {
        return j11 == getLocalMillis() ? this : new LocalDateTime(j11, getChronology());
    }

    public LocalDateTime withMillisOfDay(int i11) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i11));
    }

    public LocalDateTime withMillisOfSecond(int i11) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i11));
    }

    public LocalDateTime withMinuteOfHour(int i11) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i11));
    }

    public LocalDateTime withMonthOfYear(int i11) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i11));
    }

    public LocalDateTime withPeriodAdded(i iVar, int i11) {
        return (iVar == null || i11 == 0) ? this : withLocalMillis(getChronology().add(iVar, getLocalMillis(), i11));
    }

    public LocalDateTime withSecondOfMinute(int i11) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i11));
    }

    public LocalDateTime withTime(int i11, int i12, int i13, int i14) {
        Chronology chronology = getChronology();
        return withLocalMillis(chronology.millisOfSecond().set(chronology.secondOfMinute().set(chronology.minuteOfHour().set(chronology.hourOfDay().set(getLocalMillis(), i11), i12), i13), i14));
    }

    public LocalDateTime withWeekOfWeekyear(int i11) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i11));
    }

    public LocalDateTime withWeekyear(int i11) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i11));
    }

    public LocalDateTime withYear(int i11) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i11));
    }

    public LocalDateTime withYearOfCentury(int i11) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i11));
    }

    public LocalDateTime withYearOfEra(int i11) {
        return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), i11));
    }

    public Property year() {
        return new Property(this, getChronology().year());
    }

    public Property yearOfCentury() {
        return new Property(this, getChronology().yearOfCentury());
    }

    public Property yearOfEra() {
        return new Property(this, getChronology().yearOfEra());
    }

    public LocalDateTime(DateTimeZone dateTimeZone) {
        this(a.b(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalDateTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new LocalDateTime(dateTimeZone);
    }

    public static LocalDateTime parse(String str, b bVar) {
        return bVar.h(str);
    }

    public int compareTo(h hVar) {
        if (this == hVar) {
            return 0;
        }
        if (hVar instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) hVar;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                long j11 = this.iLocalMillis;
                long j12 = localDateTime.iLocalMillis;
                if (j11 < j12) {
                    return -1;
                }
                if (j11 == j12) {
                    return 0;
                }
                return 1;
            }
        }
        return super.compareTo(hVar);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        return durationFieldType.getField(getChronology()).isSupported();
    }

    public LocalDateTime minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public LocalDateTime plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), this.iChronology.withZone(a.m(dateTimeZone)));
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return a.b(str).l(this);
    }

    public LocalDateTime(Chronology chronology) {
        this(a.b(), chronology);
    }

    public LocalDateTime(long j11) {
        this(j11, (Chronology) ISOChronology.getInstance());
    }

    public static LocalDateTime now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new LocalDateTime(chronology);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return a.b(str).v(locale).l(this);
    }

    public LocalDateTime(long j11, DateTimeZone dateTimeZone) {
        this(j11, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public Date toDate(TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.clear();
        instance.set(getYear(), getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        Date time = instance.getTime();
        time.setTime(time.getTime() + ((long) getMillisOfSecond()));
        return correctDstTransition(time, timeZone);
    }

    public LocalDateTime(long j11, Chronology chronology) {
        Chronology c11 = a.c(chronology);
        this.iLocalMillis = c11.getZone().getMillisKeepLocal(DateTimeZone.UTC, j11);
        this.iChronology = c11.withUTC();
    }

    public LocalDateTime(Object obj) {
        this(obj, (Chronology) null);
    }

    public LocalDateTime(Object obj, DateTimeZone dateTimeZone) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.b(obj, dateTimeZone));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.l());
        this.iLocalMillis = withUTC.getDateTimeMillis(f11[0], f11[1], f11[2], f11[3]);
    }

    public LocalDateTime(Object obj, Chronology chronology) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.a(obj, chronology));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.l());
        this.iLocalMillis = withUTC.getDateTimeMillis(f11[0], f11[1], f11[2], f11[3]);
    }

    public LocalDateTime(int i11, int i12, int i13, int i14, int i15) {
        this(i11, i12, i13, i14, i15, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i11, int i12, int i13, int i14, int i15, int i16) {
        this(i11, i12, i13, i14, i15, i16, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this(i11, i12, i13, i14, i15, i16, i17, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
