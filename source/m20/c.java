package m20;

import java.util.Date;
import org.joda.convert.ToString;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.a;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.f;
import org.joda.time.field.e;
import org.joda.time.format.b;
import org.joda.time.format.i;

public abstract class c implements f {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (getMillis() != fVar.getMillis() || !e.a(getChronology(), fVar.getChronology())) {
            return false;
        }
        return true;
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public DateTimeZone getZone() {
        return getChronology().getZone();
    }

    public int hashCode() {
        return ((int) (getMillis() ^ (getMillis() >>> 32))) + getChronology().hashCode();
    }

    public boolean isAfter(long j11) {
        return getMillis() > j11;
    }

    public boolean isAfterNow() {
        return isAfter(a.b());
    }

    public boolean isBefore(long j11) {
        return getMillis() < j11;
    }

    public boolean isBeforeNow() {
        return isBefore(a.b());
    }

    public boolean isEqual(long j11) {
        return getMillis() == j11;
    }

    public boolean isEqualNow() {
        return isEqual(a.b());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public Date toDate() {
        return new Date(getMillis());
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), getZone());
    }

    public DateTime toDateTimeISO() {
        return new DateTime(getMillis(), (Chronology) ISOChronology.getInstance(getZone()));
    }

    public Instant toInstant() {
        return new Instant(getMillis());
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), getZone());
    }

    public MutableDateTime toMutableDateTimeISO() {
        return new MutableDateTime(getMillis(), (Chronology) ISOChronology.getInstance(getZone()));
    }

    @ToString
    public String toString() {
        return i.h().k(this);
    }

    public int compareTo(f fVar) {
        int i11;
        if (this == fVar || getMillis() == fVar.getMillis()) {
            return 0;
        }
        return i11 < 0 ? -1 : 1;
    }

    public boolean isAfter(f fVar) {
        return isAfter(a.h(fVar));
    }

    public boolean isBefore(f fVar) {
        return isBefore(a.h(fVar));
    }

    public boolean isEqual(f fVar) {
        return isEqual(a.h(fVar));
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        return new DateTime(getMillis(), a.c(getChronology()).withZone(dateTimeZone));
    }

    public MutableDateTime toMutableDateTime(DateTimeZone dateTimeZone) {
        return new MutableDateTime(getMillis(), a.c(getChronology()).withZone(dateTimeZone));
    }

    public String toString(b bVar) {
        if (bVar == null) {
            return toString();
        }
        return bVar.k(this);
    }

    public int get(DateTimeField dateTimeField) {
        if (dateTimeField != null) {
            return dateTimeField.get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeField must not be null");
    }

    public DateTime toDateTime(Chronology chronology) {
        return new DateTime(getMillis(), chronology);
    }

    public MutableDateTime toMutableDateTime(Chronology chronology) {
        return new MutableDateTime(getMillis(), chronology);
    }
}
