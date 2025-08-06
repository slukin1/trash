package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
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

public final class LocalTime extends g implements Serializable {
    private static final int HOUR_OF_DAY = 0;
    public static final LocalTime MIDNIGHT = new LocalTime(0, 0, 0, 0);
    private static final int MILLIS_OF_SECOND = 3;
    private static final int MINUTE_OF_HOUR = 1;
    private static final int SECOND_OF_MINUTE = 2;
    private static final Set<DurationFieldType> TIME_DURATION_TYPES;
    private static final long serialVersionUID = -12873158713873L;
    private final Chronology iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -325842547277223L;
        private transient DateTimeField iField;
        private transient LocalTime iInstant;

        public Property(LocalTime localTime, DateTimeField dateTimeField) {
            this.iInstant = localTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalTime addCopy(int i11) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), i11));
        }

        public LocalTime addNoWrapToCopy(int i11) {
            long add = this.iField.add(this.iInstant.getLocalMillis(), i11);
            if (((long) this.iInstant.getChronology().millisOfDay().get(add)) == add) {
                return this.iInstant.withLocalMillis(add);
            }
            throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
        }

        public LocalTime addWrapFieldToCopy(int i11) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.addWrapField(localTime.getLocalMillis(), i11));
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public LocalTime getLocalTime() {
            return this.iInstant;
        }

        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalTime roundCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundFloor(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfEvenCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfEven(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfFloor(localTime.getLocalMillis()));
        }

        public LocalTime setCopy(int i11) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), i11));
        }

        public LocalTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalTime addCopy(long j11) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), j11));
        }

        public LocalTime setCopy(String str, Locale locale) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), str, locale));
        }

        public LocalTime setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        TIME_DURATION_TYPES = hashSet;
        hashSet.add(DurationFieldType.millis());
        hashSet.add(DurationFieldType.seconds());
        hashSet.add(DurationFieldType.minutes());
        hashSet.add(DurationFieldType.hours());
    }

    public LocalTime() {
        this(a.b(), (Chronology) ISOChronology.getInstance());
    }

    public static LocalTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new LocalTime(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalTime fromDateFields(Date date) {
        if (date != null) {
            return new LocalTime(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static LocalTime fromMillisOfDay(long j11) {
        return fromMillisOfDay(j11, (Chronology) null);
    }

    public static LocalTime now() {
        return new LocalTime();
    }

    @FromString
    public static LocalTime parse(String str) {
        return parse(str, i.n());
    }

    private Object readResolve() {
        Chronology chronology = this.iChronology;
        if (chronology == null) {
            return new LocalTime(this.iLocalMillis, (Chronology) ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(chronology.getZone()) ? new LocalTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.iChronology.equals(localTime.iChronology)) {
                if (this.iLocalMillis == localTime.iLocalMillis) {
                    return true;
                }
                return false;
            }
        }
        return super.equals(obj);
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

    public Chronology getChronology() {
        return this.iChronology;
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

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    public int getValue(int i11) {
        if (i11 == 0) {
            return getChronology().hourOfDay().get(getLocalMillis());
        }
        if (i11 == 1) {
            return getChronology().minuteOfHour().get(getLocalMillis());
        }
        if (i11 == 2) {
            return getChronology().secondOfMinute().get(getLocalMillis());
        }
        if (i11 == 3) {
            return getChronology().millisOfSecond().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i11);
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null || !isSupported(dateTimeFieldType.getDurationType())) {
            return false;
        }
        DurationFieldType rangeDurationType = dateTimeFieldType.getRangeDurationType();
        if (isSupported(rangeDurationType) || rangeDurationType == DurationFieldType.days()) {
            return true;
        }
        return false;
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalTime minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public LocalTime minusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i11));
    }

    public LocalTime minusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i11));
    }

    public LocalTime minusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i11));
    }

    public LocalTime minusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i11));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public LocalTime plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public LocalTime plusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().add(getLocalMillis(), i11));
    }

    public LocalTime plusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().add(getLocalMillis(), i11));
    }

    public LocalTime plusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().add(getLocalMillis(), i11));
    }

    public LocalTime plusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().add(getLocalMillis(), i11));
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

    public DateTime toDateTimeToday() {
        return toDateTimeToday((DateTimeZone) null);
    }

    @ToString
    public String toString() {
        return i.p().l(this);
    }

    public LocalTime withField(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i11));
        } else {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
    }

    public LocalTime withFieldAdded(DurationFieldType durationFieldType, int i11) {
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

    public LocalTime withFields(h hVar) {
        return hVar == null ? this : withLocalMillis(getChronology().set(hVar, getLocalMillis()));
    }

    public LocalTime withHourOfDay(int i11) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i11));
    }

    public LocalTime withLocalMillis(long j11) {
        return j11 == getLocalMillis() ? this : new LocalTime(j11, getChronology());
    }

    public LocalTime withMillisOfDay(int i11) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i11));
    }

    public LocalTime withMillisOfSecond(int i11) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i11));
    }

    public LocalTime withMinuteOfHour(int i11) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i11));
    }

    public LocalTime withPeriodAdded(i iVar, int i11) {
        return (iVar == null || i11 == 0) ? this : withLocalMillis(getChronology().add(iVar, getLocalMillis(), i11));
    }

    public LocalTime withSecondOfMinute(int i11) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i11));
    }

    public LocalTime(DateTimeZone dateTimeZone) {
        this(a.b(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalTime fromMillisOfDay(long j11, Chronology chronology) {
        return new LocalTime(j11, a.c(chronology).withUTC());
    }

    public static LocalTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new LocalTime(dateTimeZone);
    }

    public static LocalTime parse(String str, b bVar) {
        return bVar.i(str);
    }

    public int compareTo(h hVar) {
        if (this == hVar) {
            return 0;
        }
        if (hVar instanceof LocalTime) {
            LocalTime localTime = (LocalTime) hVar;
            if (this.iChronology.equals(localTime.iChronology)) {
                long j11 = this.iLocalMillis;
                long j12 = localTime.iLocalMillis;
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

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, a.b()), withZone);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return a.b(str).l(this);
    }

    public LocalTime(Chronology chronology) {
        this(a.b(), chronology);
    }

    public LocalTime(long j11) {
        this(j11, (Chronology) ISOChronology.getInstance());
    }

    public static LocalTime now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new LocalTime(chronology);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        DurationField field = durationFieldType.getField(getChronology());
        if (TIME_DURATION_TYPES.contains(durationFieldType) || field.getUnitMillis() < getChronology().days().getUnitMillis()) {
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

    public LocalTime(long j11, DateTimeZone dateTimeZone) {
        this(j11, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public LocalTime(long j11, Chronology chronology) {
        Chronology c11 = a.c(chronology);
        long millisKeepLocal = c11.getZone().getMillisKeepLocal(DateTimeZone.UTC, j11);
        Chronology withUTC = c11.withUTC();
        this.iLocalMillis = (long) withUTC.millisOfDay().get(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalTime(Object obj) {
        this(obj, (Chronology) null);
    }

    public LocalTime(Object obj, DateTimeZone dateTimeZone) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.b(obj, dateTimeZone));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.n());
        this.iLocalMillis = withUTC.getDateTimeMillis(0, f11[0], f11[1], f11[2], f11[3]);
    }

    public LocalTime(Object obj, Chronology chronology) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.a(obj, chronology));
        Chronology withUTC = c11.withUTC();
        this.iChronology = withUTC;
        int[] f11 = e11.f(this, obj, c11, i.n());
        this.iLocalMillis = withUTC.getDateTimeMillis(0, f11[0], f11[1], f11[2], f11[3]);
    }

    public LocalTime(int i11, int i12) {
        this(i11, i12, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i11, int i12, int i13) {
        this(i11, i12, i13, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i11, int i12, int i13, int i14, Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(0, i11, i12, i13, i14);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
