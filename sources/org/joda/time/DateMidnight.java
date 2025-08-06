package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.b;
import org.joda.time.format.i;

@Deprecated
public final class DateMidnight extends BaseDateTime {
    private static final long serialVersionUID = 156371964018738L;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = 257629620;
        private DateTimeField iField;
        private DateMidnight iInstant;

        public Property(DateMidnight dateMidnight, DateTimeField dateTimeField) {
            this.iInstant = dateMidnight;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateMidnight) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public DateMidnight addToCopy(int i11) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), i11));
        }

        public DateMidnight addWrapFieldToCopy(int i11) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.addWrapField(dateMidnight.getMillis(), i11));
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateMidnight getDateMidnight() {
            return this.iInstant;
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public DateMidnight roundCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundFloor(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfEvenCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfEven(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfFloor(dateMidnight.getMillis()));
        }

        public DateMidnight setCopy(int i11) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), i11));
        }

        public DateMidnight withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public DateMidnight withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public DateMidnight addToCopy(long j11) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), j11));
        }

        public DateMidnight setCopy(String str, Locale locale) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), str, locale));
        }

        public DateMidnight setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public DateMidnight() {
    }

    public static DateMidnight now() {
        return new DateMidnight();
    }

    @FromString
    public static DateMidnight parse(String str) {
        return parse(str, i.i().w());
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public long checkInstant(long j11, Chronology chronology) {
        return chronology.dayOfMonth().roundFloor(j11);
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

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public DateMidnight minus(long j11) {
        return withDurationAdded(j11, -1);
    }

    public DateMidnight minusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().days().subtract(getMillis(), i11));
    }

    public DateMidnight minusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().months().subtract(getMillis(), i11));
    }

    public DateMidnight minusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().weeks().subtract(getMillis(), i11));
    }

    public DateMidnight minusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().years().subtract(getMillis(), i11));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public DateMidnight plus(long j11) {
        return withDurationAdded(j11, 1);
    }

    public DateMidnight plusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().days().add(getMillis(), i11));
    }

    public DateMidnight plusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().months().add(getMillis(), i11));
    }

    public DateMidnight plusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().weeks().add(getMillis(), i11));
    }

    public DateMidnight plusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().years().add(getMillis(), i11));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            DateTimeField field = dateTimeFieldType.getField(getChronology());
            if (field.isSupported()) {
                return new Property(this, field);
            }
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public Interval toInterval() {
        Chronology chronology = getChronology();
        long millis = getMillis();
        return new Interval(millis, DurationFieldType.days().getField(chronology).add(millis, 1), chronology);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getMillis(), getChronology());
    }

    @Deprecated
    public YearMonthDay toYearMonthDay() {
        return new YearMonthDay(getMillis(), getChronology());
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public DateMidnight withCenturyOfEra(int i11) {
        return withMillis(getChronology().centuryOfEra().set(getMillis(), i11));
    }

    public DateMidnight withChronology(Chronology chronology) {
        return chronology == getChronology() ? this : new DateMidnight(getMillis(), chronology);
    }

    public DateMidnight withDayOfMonth(int i11) {
        return withMillis(getChronology().dayOfMonth().set(getMillis(), i11));
    }

    public DateMidnight withDayOfWeek(int i11) {
        return withMillis(getChronology().dayOfWeek().set(getMillis(), i11));
    }

    public DateMidnight withDayOfYear(int i11) {
        return withMillis(getChronology().dayOfYear().set(getMillis(), i11));
    }

    public DateMidnight withDurationAdded(long j11, int i11) {
        return (j11 == 0 || i11 == 0) ? this : withMillis(getChronology().add(getMillis(), j11, i11));
    }

    public DateMidnight withEra(int i11) {
        return withMillis(getChronology().era().set(getMillis(), i11));
    }

    public DateMidnight withField(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType != null) {
            return withMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i11));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateMidnight withFieldAdded(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i11 == 0) {
            return this;
        } else {
            return withMillis(durationFieldType.getField(getChronology()).add(getMillis(), i11));
        }
    }

    public DateMidnight withFields(h hVar) {
        return hVar == null ? this : withMillis(getChronology().set(hVar, getMillis()));
    }

    public DateMidnight withMillis(long j11) {
        Chronology chronology = getChronology();
        long checkInstant = checkInstant(j11, chronology);
        return checkInstant == getMillis() ? this : new DateMidnight(checkInstant, chronology);
    }

    public DateMidnight withMonthOfYear(int i11) {
        return withMillis(getChronology().monthOfYear().set(getMillis(), i11));
    }

    public DateMidnight withPeriodAdded(i iVar, int i11) {
        return (iVar == null || i11 == 0) ? this : withMillis(getChronology().add(iVar, getMillis(), i11));
    }

    public DateMidnight withWeekOfWeekyear(int i11) {
        return withMillis(getChronology().weekOfWeekyear().set(getMillis(), i11));
    }

    public DateMidnight withWeekyear(int i11) {
        return withMillis(getChronology().weekyear().set(getMillis(), i11));
    }

    public DateMidnight withYear(int i11) {
        return withMillis(getChronology().year().set(getMillis(), i11));
    }

    public DateMidnight withYearOfCentury(int i11) {
        return withMillis(getChronology().yearOfCentury().set(getMillis(), i11));
    }

    public DateMidnight withYearOfEra(int i11) {
        return withMillis(getChronology().yearOfEra().set(getMillis(), i11));
    }

    public DateMidnight withZoneRetainFields(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        DateTimeZone m12 = a.m(getZone());
        if (m11 == m12) {
            return this;
        }
        return new DateMidnight(m12.getMillisKeepLocal(m11, getMillis()), getChronology().withZone(m11));
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

    public DateMidnight(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static DateMidnight now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new DateMidnight(dateTimeZone);
    }

    public static DateMidnight parse(String str, b bVar) {
        return bVar.f(str).toDateMidnight();
    }

    public DateMidnight minus(e eVar) {
        return withDurationAdded(eVar, -1);
    }

    public DateMidnight plus(e eVar) {
        return withDurationAdded(eVar, 1);
    }

    public DateMidnight(Chronology chronology) {
        super(chronology);
    }

    public DateMidnight minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public DateMidnight plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public DateMidnight withDurationAdded(e eVar, int i11) {
        return (eVar == null || i11 == 0) ? this : withDurationAdded(eVar.getMillis(), i11);
    }

    public DateMidnight(long j11) {
        super(j11);
    }

    public static DateMidnight now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new DateMidnight(chronology);
    }

    public DateMidnight(long j11, DateTimeZone dateTimeZone) {
        super(j11, dateTimeZone);
    }

    public DateMidnight(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public DateMidnight(Object obj) {
        super(obj, (Chronology) null);
    }

    public DateMidnight(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public DateMidnight(Object obj, Chronology chronology) {
        super(obj, a.c(chronology));
    }

    public DateMidnight(int i11, int i12, int i13) {
        super(i11, i12, i13, 0, 0, 0, 0);
    }

    public DateMidnight(int i11, int i12, int i13, DateTimeZone dateTimeZone) {
        super(i11, i12, i13, 0, 0, 0, 0, dateTimeZone);
    }

    public DateMidnight(int i11, int i12, int i13, Chronology chronology) {
        super(i11, i12, i13, 0, 0, 0, 0, chronology);
    }
}
