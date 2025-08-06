package org.joda.time;

import com.hbg.lib.network.pro.core.util.Period;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class DateTime extends BaseDateTime {
    private static final long serialVersionUID = -5171125899451703815L;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -6983323811635733510L;
        private DateTimeField iField;
        private DateTime iInstant;

        public Property(DateTime dateTime, DateTimeField dateTimeField) {
            this.iInstant = dateTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public DateTime addToCopy(int i11) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.add(dateTime.getMillis(), i11));
        }

        public DateTime addWrapFieldToCopy(int i11) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.addWrapField(dateTime.getMillis(), i11));
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTime getDateTime() {
            return this.iInstant;
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public DateTime roundCeilingCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundCeiling(dateTime.getMillis()));
        }

        public DateTime roundFloorCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundFloor(dateTime.getMillis()));
        }

        public DateTime roundHalfCeilingCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfCeiling(dateTime.getMillis()));
        }

        public DateTime roundHalfEvenCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfEven(dateTime.getMillis()));
        }

        public DateTime roundHalfFloorCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfFloor(dateTime.getMillis()));
        }

        public DateTime setCopy(int i11) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.set(dateTime.getMillis(), i11));
        }

        public DateTime withMaximumValue() {
            try {
                return setCopy(getMaximumValue());
            } catch (RuntimeException e11) {
                if (IllegalInstantException.isIllegalInstant(e11)) {
                    return new DateTime(getChronology().getZone().previousTransition(getMillis() + Period.DAY_MILLS), getChronology());
                }
                throw e11;
            }
        }

        public DateTime withMinimumValue() {
            try {
                return setCopy(getMinimumValue());
            } catch (RuntimeException e11) {
                if (IllegalInstantException.isIllegalInstant(e11)) {
                    return new DateTime(getChronology().getZone().nextTransition(getMillis() - Period.DAY_MILLS), getChronology());
                }
                throw e11;
            }
        }

        public DateTime addToCopy(long j11) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.add(dateTime.getMillis(), j11));
        }

        public DateTime setCopy(String str, Locale locale) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.set(dateTime.getMillis(), str, locale));
        }

        public DateTime setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public DateTime() {
    }

    public static DateTime now() {
        return new DateTime();
    }

    @FromString
    public static DateTime parse(String str) {
        return parse(str, i.i().w());
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

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public DateTime minus(long j11) {
        return withDurationAdded(j11, -1);
    }

    public DateTime minusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().days().subtract(getMillis(), i11));
    }

    public DateTime minusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().hours().subtract(getMillis(), i11));
    }

    public DateTime minusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().millis().subtract(getMillis(), i11));
    }

    public DateTime minusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().minutes().subtract(getMillis(), i11));
    }

    public DateTime minusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().months().subtract(getMillis(), i11));
    }

    public DateTime minusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().seconds().subtract(getMillis(), i11));
    }

    public DateTime minusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().weeks().subtract(getMillis(), i11));
    }

    public DateTime minusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().years().subtract(getMillis(), i11));
    }

    public Property minuteOfDay() {
        return new Property(this, getChronology().minuteOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public DateTime plus(long j11) {
        return withDurationAdded(j11, 1);
    }

    public DateTime plusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().days().add(getMillis(), i11));
    }

    public DateTime plusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().hours().add(getMillis(), i11));
    }

    public DateTime plusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().millis().add(getMillis(), i11));
    }

    public DateTime plusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().minutes().add(getMillis(), i11));
    }

    public DateTime plusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().months().add(getMillis(), i11));
    }

    public DateTime plusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().seconds().add(getMillis(), i11));
    }

    public DateTime plusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        return withMillis(getChronology().weeks().add(getMillis(), i11));
    }

    public DateTime plusYears(int i11) {
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

    public Property secondOfDay() {
        return new Property(this, getChronology().secondOfDay());
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    @Deprecated
    public DateMidnight toDateMidnight() {
        return new DateMidnight(getMillis(), getChronology());
    }

    public DateTime toDateTime() {
        return this;
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        if (getZone() == m11) {
            return this;
        }
        return super.toDateTime(m11);
    }

    public DateTime toDateTimeISO() {
        if (getChronology() == ISOChronology.getInstance()) {
            return this;
        }
        return super.toDateTimeISO();
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getMillis(), getChronology());
    }

    public LocalDateTime toLocalDateTime() {
        return new LocalDateTime(getMillis(), getChronology());
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getMillis(), getChronology());
    }

    @Deprecated
    public TimeOfDay toTimeOfDay() {
        return new TimeOfDay(getMillis(), getChronology());
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

    public DateTime withCenturyOfEra(int i11) {
        return withMillis(getChronology().centuryOfEra().set(getMillis(), i11));
    }

    public DateTime withChronology(Chronology chronology) {
        Chronology c11 = a.c(chronology);
        return c11 == getChronology() ? this : new DateTime(getMillis(), c11);
    }

    public DateTime withDate(int i11, int i12, int i13) {
        Chronology chronology = getChronology();
        return withMillis(chronology.dayOfMonth().set(chronology.monthOfYear().set(chronology.year().set(getMillis(), i11), i12), i13));
    }

    public DateTime withDayOfMonth(int i11) {
        return withMillis(getChronology().dayOfMonth().set(getMillis(), i11));
    }

    public DateTime withDayOfWeek(int i11) {
        return withMillis(getChronology().dayOfWeek().set(getMillis(), i11));
    }

    public DateTime withDayOfYear(int i11) {
        return withMillis(getChronology().dayOfYear().set(getMillis(), i11));
    }

    public DateTime withDurationAdded(long j11, int i11) {
        return (j11 == 0 || i11 == 0) ? this : withMillis(getChronology().add(getMillis(), j11, i11));
    }

    public DateTime withEarlierOffsetAtOverlap() {
        return withMillis(getZone().adjustOffset(getMillis(), false));
    }

    public DateTime withEra(int i11) {
        return withMillis(getChronology().era().set(getMillis(), i11));
    }

    public DateTime withField(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType != null) {
            return withMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i11));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateTime withFieldAdded(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i11 == 0) {
            return this;
        } else {
            return withMillis(durationFieldType.getField(getChronology()).add(getMillis(), i11));
        }
    }

    public DateTime withFields(h hVar) {
        return hVar == null ? this : withMillis(getChronology().set(hVar, getMillis()));
    }

    public DateTime withHourOfDay(int i11) {
        return withMillis(getChronology().hourOfDay().set(getMillis(), i11));
    }

    public DateTime withLaterOffsetAtOverlap() {
        return withMillis(getZone().adjustOffset(getMillis(), true));
    }

    public DateTime withMillis(long j11) {
        return j11 == getMillis() ? this : new DateTime(j11, getChronology());
    }

    public DateTime withMillisOfDay(int i11) {
        return withMillis(getChronology().millisOfDay().set(getMillis(), i11));
    }

    public DateTime withMillisOfSecond(int i11) {
        return withMillis(getChronology().millisOfSecond().set(getMillis(), i11));
    }

    public DateTime withMinuteOfHour(int i11) {
        return withMillis(getChronology().minuteOfHour().set(getMillis(), i11));
    }

    public DateTime withMonthOfYear(int i11) {
        return withMillis(getChronology().monthOfYear().set(getMillis(), i11));
    }

    public DateTime withPeriodAdded(i iVar, int i11) {
        return (iVar == null || i11 == 0) ? this : withMillis(getChronology().add(iVar, getMillis(), i11));
    }

    public DateTime withSecondOfMinute(int i11) {
        return withMillis(getChronology().secondOfMinute().set(getMillis(), i11));
    }

    public DateTime withTime(int i11, int i12, int i13, int i14) {
        Chronology chronology = getChronology();
        return withMillis(chronology.millisOfSecond().set(chronology.secondOfMinute().set(chronology.minuteOfHour().set(chronology.hourOfDay().set(getMillis(), i11), i12), i13), i14));
    }

    public DateTime withTimeAtStartOfDay() {
        return toLocalDate().toDateTimeAtStartOfDay(getZone());
    }

    public DateTime withWeekOfWeekyear(int i11) {
        return withMillis(getChronology().weekOfWeekyear().set(getMillis(), i11));
    }

    public DateTime withWeekyear(int i11) {
        return withMillis(getChronology().weekyear().set(getMillis(), i11));
    }

    public DateTime withYear(int i11) {
        return withMillis(getChronology().year().set(getMillis(), i11));
    }

    public DateTime withYearOfCentury(int i11) {
        return withMillis(getChronology().yearOfCentury().set(getMillis(), i11));
    }

    public DateTime withYearOfEra(int i11) {
        return withMillis(getChronology().yearOfEra().set(getMillis(), i11));
    }

    public DateTime withZone(DateTimeZone dateTimeZone) {
        return withChronology(getChronology().withZone(dateTimeZone));
    }

    public DateTime withZoneRetainFields(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        DateTimeZone m12 = a.m(getZone());
        if (m11 == m12) {
            return this;
        }
        return new DateTime(m12.getMillisKeepLocal(m11, getMillis()), getChronology().withZone(m11));
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

    public DateTime(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static DateTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new DateTime(dateTimeZone);
    }

    public static DateTime parse(String str, b bVar) {
        return bVar.f(str);
    }

    public DateTime minus(e eVar) {
        return withDurationAdded(eVar, -1);
    }

    public DateTime plus(e eVar) {
        return withDurationAdded(eVar, 1);
    }

    public DateTime(Chronology chronology) {
        super(chronology);
    }

    public DateTime minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public DateTime plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public DateTime withDurationAdded(e eVar, int i11) {
        return (eVar == null || i11 == 0) ? this : withDurationAdded(eVar.getMillis(), i11);
    }

    public DateTime(long j11) {
        super(j11);
    }

    public static DateTime now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new DateTime(chronology);
    }

    public DateTime toDateTime(Chronology chronology) {
        Chronology c11 = a.c(chronology);
        if (getChronology() == c11) {
            return this;
        }
        return super.toDateTime(c11);
    }

    public DateTime(long j11, DateTimeZone dateTimeZone) {
        super(j11, dateTimeZone);
    }

    public DateTime(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public DateTime(Object obj) {
        super(obj, (Chronology) null);
    }

    public DateTime withDate(LocalDate localDate) {
        return withDate(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
    }

    public DateTime(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public DateTime withTime(LocalTime localTime) {
        return withTime(localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute(), localTime.getMillisOfSecond());
    }

    public DateTime(Object obj, Chronology chronology) {
        super(obj, a.c(chronology));
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15) {
        super(i11, i12, i13, i14, i15, 0, 0);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, DateTimeZone dateTimeZone) {
        super(i11, i12, i13, i14, i15, 0, 0, dateTimeZone);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, Chronology chronology) {
        super(i11, i12, i13, i14, i15, 0, 0, chronology);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16) {
        super(i11, i12, i13, i14, i15, i16, 0);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16, DateTimeZone dateTimeZone) {
        super(i11, i12, i13, i14, i15, i16, 0, dateTimeZone);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16, Chronology chronology) {
        super(i11, i12, i13, i14, i15, i16, 0, chronology);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super(i11, i12, i13, i14, i15, i16, i17);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, DateTimeZone dateTimeZone) {
        super(i11, i12, i13, i14, i15, i16, i17, dateTimeZone);
    }

    public DateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, Chronology chronology) {
        super(i11, i12, i13, i14, i15, i16, i17, chronology);
    }
}
