package org.joda.time;

import com.hbg.lib.network.pro.core.util.Period;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import m20.g;
import n20.d;
import n20.l;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.field.e;
import org.joda.time.format.a;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class LocalDate extends g implements Serializable {
    private static final Set<DurationFieldType> DATE_DURATION_TYPES;
    private static final int DAY_OF_MONTH = 2;
    private static final int MONTH_OF_YEAR = 1;
    private static final int YEAR = 0;
    private static final long serialVersionUID = -8775358157899L;
    private final Chronology iChronology;
    private transient int iHash;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -3193829732634L;
        private transient DateTimeField iField;
        private transient LocalDate iInstant;

        public Property(LocalDate localDate, DateTimeField dateTimeField) {
            this.iInstant = localDate;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalDate) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalDate addToCopy(int i11) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.add(localDate.getLocalMillis(), i11));
        }

        public LocalDate addWrapFieldToCopy(int i11) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.addWrapField(localDate.getLocalMillis(), i11));
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public LocalDate getLocalDate() {
            return this.iInstant;
        }

        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalDate roundCeilingCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundFloorCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundFloor(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfCeilingCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfEvenCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfEven(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfFloorCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfFloor(localDate.getLocalMillis()));
        }

        public LocalDate setCopy(int i11) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.set(localDate.getLocalMillis(), i11));
        }

        public LocalDate withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDate withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDate setCopy(String str, Locale locale) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.set(localDate.getLocalMillis(), str, locale));
        }

        public LocalDate setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        DATE_DURATION_TYPES = hashSet;
        hashSet.add(DurationFieldType.days());
        hashSet.add(DurationFieldType.weeks());
        hashSet.add(DurationFieldType.months());
        hashSet.add(DurationFieldType.weekyears());
        hashSet.add(DurationFieldType.years());
        hashSet.add(DurationFieldType.centuries());
        hashSet.add(DurationFieldType.eras());
    }

    public LocalDate() {
        this(a.b(), (Chronology) ISOChronology.getInstance());
    }

    public static LocalDate fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            int i11 = calendar.get(0);
            int i12 = calendar.get(1);
            if (i11 != 1) {
                i12 = 1 - i12;
            }
            return new LocalDate(i12, calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalDate fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (date.getTime() >= 0) {
            return new LocalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return fromCalendarFields(gregorianCalendar);
        }
    }

    public static LocalDate now() {
        return new LocalDate();
    }

    @FromString
    public static LocalDate parse(String str) {
        return parse(str, i.m());
    }

    private Object readResolve() {
        Chronology chronology = this.iChronology;
        if (chronology == null) {
            return new LocalDate(this.iLocalMillis, (Chronology) ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(chronology.getZone()) ? new LocalDate(this.iLocalMillis, this.iChronology.withUTC()) : this;
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
        if (obj instanceof LocalDate) {
            LocalDate localDate = (LocalDate) obj;
            if (this.iChronology.equals(localDate.iChronology)) {
                if (this.iLocalMillis == localDate.iLocalMillis) {
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
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
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
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
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

    public int hashCode() {
        int i11 = this.iHash;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = super.hashCode();
        this.iHash = hashCode;
        return hashCode;
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        DurationFieldType durationType = dateTimeFieldType.getDurationType();
        if (DATE_DURATION_TYPES.contains(durationType) || durationType.getField(getChronology()).getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return dateTimeFieldType.getField(getChronology()).isSupported();
        }
        return false;
    }

    public LocalDate minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public LocalDate minusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().subtract(getLocalMillis(), i11));
    }

    public LocalDate minusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().subtract(getLocalMillis(), i11));
    }

    public LocalDate minusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i11));
    }

    public LocalDate minusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().years().subtract(getLocalMillis(), i11));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public LocalDate plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public LocalDate plusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().add(getLocalMillis(), i11));
    }

    public LocalDate plusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().add(getLocalMillis(), i11));
    }

    public LocalDate plusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().add(getLocalMillis(), i11));
    }

    public LocalDate plusYears(int i11) {
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

    public int size() {
        return 3;
    }

    public Date toDate() {
        int dayOfMonth = getDayOfMonth();
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, dayOfMonth);
        LocalDate fromDateFields = fromDateFields(date);
        if (fromDateFields.isBefore(this)) {
            while (!fromDateFields.equals(this)) {
                date.setTime(date.getTime() + Period.MIN60_MILLS);
                fromDateFields = fromDateFields(date);
            }
            while (date.getDate() == dayOfMonth) {
                date.setTime(date.getTime() - 1000);
            }
            date.setTime(date.getTime() + 1000);
            return date;
        } else if (!fromDateFields.equals(this)) {
            return date;
        } else {
            Date date2 = new Date(date.getTime() - ((long) TimeZone.getDefault().getDSTSavings()));
            return date2.getDate() == dayOfMonth ? date2 : date;
        }
    }

    @Deprecated
    public DateMidnight toDateMidnight() {
        return toDateMidnight((DateTimeZone) null);
    }

    public DateTime toDateTime(LocalTime localTime) {
        return toDateTime(localTime, (DateTimeZone) null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime((DateTimeZone) null);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight((DateTimeZone) null);
    }

    public DateTime toDateTimeAtStartOfDay() {
        return toDateTimeAtStartOfDay((DateTimeZone) null);
    }

    public Interval toInterval() {
        return toInterval((DateTimeZone) null);
    }

    public LocalDateTime toLocalDateTime(LocalTime localTime) {
        if (localTime == null) {
            throw new IllegalArgumentException("The time must not be null");
        } else if (getChronology() == localTime.getChronology()) {
            return new LocalDateTime(getLocalMillis() + localTime.getLocalMillis(), getChronology());
        } else {
            throw new IllegalArgumentException("The chronology of the time does not match");
        }
    }

    @ToString
    public String toString() {
        return i.c().l(this);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public LocalDate withCenturyOfEra(int i11) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i11));
    }

    public LocalDate withDayOfMonth(int i11) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i11));
    }

    public LocalDate withDayOfWeek(int i11) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i11));
    }

    public LocalDate withDayOfYear(int i11) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i11));
    }

    public LocalDate withEra(int i11) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i11));
    }

    public LocalDate withField(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i11));
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public LocalDate withFieldAdded(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (!isSupported(durationFieldType)) {
            throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
        } else if (i11 == 0) {
            return this;
        } else {
            return withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i11));
        }
    }

    public LocalDate withFields(h hVar) {
        return hVar == null ? this : withLocalMillis(getChronology().set(hVar, getLocalMillis()));
    }

    public LocalDate withLocalMillis(long j11) {
        long roundFloor = this.iChronology.dayOfMonth().roundFloor(j11);
        return roundFloor == getLocalMillis() ? this : new LocalDate(roundFloor, getChronology());
    }

    public LocalDate withMonthOfYear(int i11) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i11));
    }

    public LocalDate withPeriodAdded(i iVar, int i11) {
        if (iVar == null || i11 == 0) {
            return this;
        }
        long localMillis = getLocalMillis();
        Chronology chronology = getChronology();
        for (int i12 = 0; i12 < iVar.size(); i12++) {
            long g11 = (long) e.g(iVar.getValue(i12), i11);
            DurationFieldType fieldType = iVar.getFieldType(i12);
            if (isSupported(fieldType)) {
                localMillis = fieldType.getField(chronology).add(localMillis, g11);
            }
        }
        return withLocalMillis(localMillis);
    }

    public LocalDate withWeekOfWeekyear(int i11) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i11));
    }

    public LocalDate withWeekyear(int i11) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i11));
    }

    public LocalDate withYear(int i11) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i11));
    }

    public LocalDate withYearOfCentury(int i11) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i11));
    }

    public LocalDate withYearOfEra(int i11) {
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

    public LocalDate(DateTimeZone dateTimeZone) {
        this(a.b(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalDate now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new LocalDate(dateTimeZone);
    }

    public static LocalDate parse(String str, b bVar) {
        return bVar.g(str);
    }

    public int compareTo(h hVar) {
        if (this == hVar) {
            return 0;
        }
        if (hVar instanceof LocalDate) {
            LocalDate localDate = (LocalDate) hVar;
            if (this.iChronology.equals(localDate.iChronology)) {
                long j11 = this.iLocalMillis;
                long j12 = localDate.iLocalMillis;
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

    @Deprecated
    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(a.m(dateTimeZone)));
    }

    public DateTime toDateTime(LocalTime localTime, DateTimeZone dateTimeZone) {
        if (localTime == null) {
            return toDateTimeAtCurrentTime(dateTimeZone);
        }
        if (getChronology() == localTime.getChronology()) {
            return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute(), localTime.getMillisOfSecond(), getChronology().withZone(dateTimeZone));
        }
        throw new IllegalArgumentException("The chronology of the time does not match");
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(a.m(dateTimeZone));
        return new DateTime(withZone.set(this, a.b()), withZone);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(a.m(dateTimeZone)));
    }

    public DateTime toDateTimeAtStartOfDay(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        Chronology withZone = getChronology().withZone(m11);
        return new DateTime(withZone.dayOfMonth().roundFloor(m11.convertLocalToUTC(getLocalMillis() + 21600000, false)), withZone);
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        return new Interval((f) toDateTimeAtStartOfDay(m11), (f) plusDays(1).toDateTimeAtStartOfDay(m11));
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return a.b(str).l(this);
    }

    public LocalDate(Chronology chronology) {
        this(a.b(), chronology);
    }

    public LocalDate(long j11) {
        this(j11, (Chronology) ISOChronology.getInstance());
    }

    public static LocalDate now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new LocalDate(chronology);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        DurationField field = durationFieldType.getField(getChronology());
        if (DATE_DURATION_TYPES.contains(durationFieldType) || field.getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return a.b(str).v(locale).l(this);
    }

    public LocalDate(long j11, DateTimeZone dateTimeZone) {
        this(j11, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDate(long j11, Chronology chronology) {
        Chronology c11 = a.c(chronology);
        long millisKeepLocal = c11.getZone().getMillisKeepLocal(DateTimeZone.UTC, j11);
        Chronology withUTC = c11.withUTC();
        this.iLocalMillis = withUTC.dayOfMonth().roundFloor(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalDate(Object obj) {
        this(obj, (Chronology) null);
    }

    public LocalDate(Object obj, DateTimeZone dateTimeZone) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.b(obj, dateTimeZone));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.m());
        this.iLocalMillis = withUTC.getDateTimeMillis(f11[0], f11[1], f11[2], 0);
    }

    public LocalDate(Object obj, Chronology chronology) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.a(obj, chronology));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.m());
        this.iLocalMillis = withUTC.getDateTimeMillis(f11[0], f11[1], f11[2], 0);
    }

    public LocalDate(int i11, int i12, int i13) {
        this(i11, i12, i13, ISOChronology.getInstanceUTC());
    }

    public LocalDate(int i11, int i12, int i13, Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i11, i12, i13, 0);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
