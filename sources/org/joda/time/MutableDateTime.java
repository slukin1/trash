package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.field.e;
import org.joda.time.format.b;
import org.joda.time.format.i;

public class MutableDateTime extends BaseDateTime implements Cloneable {
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_FLOOR = 1;
    public static final int ROUND_HALF_CEILING = 4;
    public static final int ROUND_HALF_EVEN = 5;
    public static final int ROUND_HALF_FLOOR = 3;
    public static final int ROUND_NONE = 0;
    private static final long serialVersionUID = 2852608688135209575L;
    private DateTimeField iRoundingField;
    private int iRoundingMode;

    public MutableDateTime() {
    }

    public static MutableDateTime now() {
        return new MutableDateTime();
    }

    @FromString
    public static MutableDateTime parse(String str) {
        return parse(str, i.i().w());
    }

    public void add(long j11) {
        setMillis(e.e(getMillis(), j11));
    }

    public void addDays(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().days().add(getMillis(), i11));
        }
    }

    public void addHours(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().hours().add(getMillis(), i11));
        }
    }

    public void addMillis(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().millis().add(getMillis(), i11));
        }
    }

    public void addMinutes(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().minutes().add(getMillis(), i11));
        }
    }

    public void addMonths(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().months().add(getMillis(), i11));
        }
    }

    public void addSeconds(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().seconds().add(getMillis(), i11));
        }
    }

    public void addWeeks(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().weeks().add(getMillis(), i11));
        }
    }

    public void addWeekyears(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().weekyears().add(getMillis(), i11));
        }
    }

    public void addYears(int i11) {
        if (i11 != 0) {
            setMillis(getChronology().years().add(getMillis(), i11));
        }
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableDateTime copy() {
        return (MutableDateTime) clone();
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

    public DateTimeField getRoundingField() {
        return this.iRoundingField;
    }

    public int getRoundingMode() {
        return this.iRoundingMode;
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

    public Property minuteOfDay() {
        return new Property(this, getChronology().minuteOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
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

    public void set(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType != null) {
            setMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i11));
            return;
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public void setChronology(Chronology chronology) {
        super.setChronology(chronology);
    }

    public void setDate(long j11) {
        setMillis(getChronology().millisOfDay().set(j11, getMillisOfDay()));
    }

    public void setDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        setMillis(getChronology().getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17));
    }

    public void setDayOfMonth(int i11) {
        setMillis(getChronology().dayOfMonth().set(getMillis(), i11));
    }

    public void setDayOfWeek(int i11) {
        setMillis(getChronology().dayOfWeek().set(getMillis(), i11));
    }

    public void setDayOfYear(int i11) {
        setMillis(getChronology().dayOfYear().set(getMillis(), i11));
    }

    public void setHourOfDay(int i11) {
        setMillis(getChronology().hourOfDay().set(getMillis(), i11));
    }

    public void setMillis(long j11) {
        int i11 = this.iRoundingMode;
        if (i11 == 1) {
            j11 = this.iRoundingField.roundFloor(j11);
        } else if (i11 == 2) {
            j11 = this.iRoundingField.roundCeiling(j11);
        } else if (i11 == 3) {
            j11 = this.iRoundingField.roundHalfFloor(j11);
        } else if (i11 == 4) {
            j11 = this.iRoundingField.roundHalfCeiling(j11);
        } else if (i11 == 5) {
            j11 = this.iRoundingField.roundHalfEven(j11);
        }
        super.setMillis(j11);
    }

    public void setMillisOfDay(int i11) {
        setMillis(getChronology().millisOfDay().set(getMillis(), i11));
    }

    public void setMillisOfSecond(int i11) {
        setMillis(getChronology().millisOfSecond().set(getMillis(), i11));
    }

    public void setMinuteOfDay(int i11) {
        setMillis(getChronology().minuteOfDay().set(getMillis(), i11));
    }

    public void setMinuteOfHour(int i11) {
        setMillis(getChronology().minuteOfHour().set(getMillis(), i11));
    }

    public void setMonthOfYear(int i11) {
        setMillis(getChronology().monthOfYear().set(getMillis(), i11));
    }

    public void setRounding(DateTimeField dateTimeField) {
        setRounding(dateTimeField, 1);
    }

    public void setSecondOfDay(int i11) {
        setMillis(getChronology().secondOfDay().set(getMillis(), i11));
    }

    public void setSecondOfMinute(int i11) {
        setMillis(getChronology().secondOfMinute().set(getMillis(), i11));
    }

    public void setTime(long j11) {
        setMillis(getChronology().millisOfDay().set(getMillis(), ISOChronology.getInstanceUTC().millisOfDay().get(j11)));
    }

    public void setWeekOfWeekyear(int i11) {
        setMillis(getChronology().weekOfWeekyear().set(getMillis(), i11));
    }

    public void setWeekyear(int i11) {
        setMillis(getChronology().weekyear().set(getMillis(), i11));
    }

    public void setYear(int i11) {
        setMillis(getChronology().year().set(getMillis(), i11));
    }

    public void setZone(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        Chronology chronology = getChronology();
        if (chronology.getZone() != m11) {
            setChronology(chronology.withZone(m11));
        }
    }

    public void setZoneRetainFields(DateTimeZone dateTimeZone) {
        DateTimeZone m11 = a.m(dateTimeZone);
        DateTimeZone m12 = a.m(getZone());
        if (m11 != m12) {
            long millisKeepLocal = m12.getMillisKeepLocal(m11, getMillis());
            setChronology(getChronology().withZone(m11));
            setMillis(millisKeepLocal);
        }
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
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

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -4481126543819298617L;
        private DateTimeField iField;
        private MutableDateTime iInstant;

        public Property(MutableDateTime mutableDateTime, DateTimeField dateTimeField) {
            this.iInstant = mutableDateTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (MutableDateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public MutableDateTime add(int i11) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), i11));
            return this.iInstant;
        }

        public MutableDateTime addWrapField(int i11) {
            this.iInstant.setMillis(getField().addWrapField(this.iInstant.getMillis(), i11));
            return this.iInstant;
        }

        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public MutableDateTime getMutableDateTime() {
            return this.iInstant;
        }

        public MutableDateTime roundCeiling() {
            this.iInstant.setMillis(getField().roundCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundFloor() {
            this.iInstant.setMillis(getField().roundFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfCeiling() {
            this.iInstant.setMillis(getField().roundHalfCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfEven() {
            this.iInstant.setMillis(getField().roundHalfEven(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfFloor() {
            this.iInstant.setMillis(getField().roundHalfFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime set(int i11) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), i11));
            return this.iInstant;
        }

        public MutableDateTime add(long j11) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), j11));
            return this.iInstant;
        }

        public MutableDateTime set(String str, Locale locale) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), str, locale));
            return this.iInstant;
        }

        public MutableDateTime set(String str) {
            set(str, (Locale) null);
            return this.iInstant;
        }
    }

    public MutableDateTime(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static MutableDateTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new MutableDateTime(dateTimeZone);
    }

    public static MutableDateTime parse(String str, b bVar) {
        return bVar.f(str).toMutableDateTime();
    }

    public void add(e eVar) {
        add(eVar, 1);
    }

    public void setDate(f fVar) {
        DateTimeZone zone;
        long h11 = a.h(fVar);
        if ((fVar instanceof d) && (zone = a.c(((d) fVar).getChronology()).getZone()) != null) {
            h11 = zone.getMillisKeepLocal(getZone(), h11);
        }
        setDate(h11);
    }

    public void setRounding(DateTimeField dateTimeField, int i11) {
        if (dateTimeField == null || (i11 >= 0 && i11 <= 5)) {
            this.iRoundingField = i11 == 0 ? null : dateTimeField;
            if (dateTimeField == null) {
                i11 = 0;
            }
            this.iRoundingMode = i11;
            setMillis(getMillis());
            return;
        }
        throw new IllegalArgumentException("Illegal rounding mode: " + i11);
    }

    public MutableDateTime(Chronology chronology) {
        super(chronology);
    }

    public void add(e eVar, int i11) {
        if (eVar != null) {
            add(e.h(eVar.getMillis(), i11));
        }
    }

    public void setTime(f fVar) {
        long h11 = a.h(fVar);
        DateTimeZone zone = a.g(fVar).getZone();
        if (zone != null) {
            h11 = zone.getMillisKeepLocal(DateTimeZone.UTC, h11);
        }
        setTime(h11);
    }

    public MutableDateTime(long j11) {
        super(j11);
    }

    public static MutableDateTime now(Chronology chronology) {
        Objects.requireNonNull(chronology, "Chronology must not be null");
        return new MutableDateTime(chronology);
    }

    public void add(i iVar) {
        add(iVar, 1);
    }

    public MutableDateTime(long j11, DateTimeZone dateTimeZone) {
        super(j11, dateTimeZone);
    }

    public void add(i iVar, int i11) {
        if (iVar != null) {
            setMillis(getChronology().add(iVar, getMillis(), i11));
        }
    }

    public MutableDateTime(long j11, Chronology chronology) {
        super(j11, chronology);
    }

    public void add(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i11 != 0) {
            setMillis(durationFieldType.getField(getChronology()).add(getMillis(), i11));
        }
    }

    public MutableDateTime(Object obj) {
        super(obj, (Chronology) null);
    }

    public MutableDateTime(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public void setMillis(f fVar) {
        setMillis(a.h(fVar));
    }

    public void setTime(int i11, int i12, int i13, int i14) {
        setMillis(getChronology().getDateTimeMillis(getMillis(), i11, i12, i13, i14));
    }

    public MutableDateTime(Object obj, Chronology chronology) {
        super(obj, a.c(chronology));
    }

    public void setDate(int i11, int i12, int i13) {
        setDate(getChronology().getDateTimeMillis(i11, i12, i13, 0));
    }

    public MutableDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super(i11, i12, i13, i14, i15, i16, i17);
    }

    public MutableDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, DateTimeZone dateTimeZone) {
        super(i11, i12, i13, i14, i15, i16, i17, dateTimeZone);
    }

    public MutableDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, Chronology chronology) {
        super(i11, i12, i13, i14, i15, i16, i17, chronology);
    }
}
