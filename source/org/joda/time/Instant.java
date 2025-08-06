package org.joda.time;

import java.io.Serializable;
import m20.c;
import n20.d;
import org.joda.convert.FromString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class Instant extends c implements Serializable {
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public Instant() {
        this.iMillis = a.b();
    }

    public static Instant now() {
        return new Instant();
    }

    @FromString
    public static Instant parse(String str) {
        return parse(str, i.i());
    }

    public Chronology getChronology() {
        return ISOChronology.getInstanceUTC();
    }

    public long getMillis() {
        return this.iMillis;
    }

    public Instant minus(long j11) {
        return withDurationAdded(j11, -1);
    }

    public Instant plus(long j11) {
        return withDurationAdded(j11, 1);
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public DateTime toDateTimeISO() {
        return toDateTime();
    }

    public Instant toInstant() {
        return this;
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public MutableDateTime toMutableDateTimeISO() {
        return toMutableDateTime();
    }

    public Instant withDurationAdded(long j11, int i11) {
        return (j11 == 0 || i11 == 0) ? this : withMillis(getChronology().add(getMillis(), j11, i11));
    }

    public Instant withMillis(long j11) {
        return j11 == this.iMillis ? this : new Instant(j11);
    }

    public static Instant parse(String str, b bVar) {
        return bVar.f(str).toInstant();
    }

    public Instant minus(e eVar) {
        return withDurationAdded(eVar, -1);
    }

    public Instant plus(e eVar) {
        return withDurationAdded(eVar, 1);
    }

    public Instant(long j11) {
        this.iMillis = j11;
    }

    public Instant withDurationAdded(e eVar, int i11) {
        return (eVar == null || i11 == 0) ? this : withDurationAdded(eVar.getMillis(), i11);
    }

    public Instant(Object obj) {
        this.iMillis = d.b().c(obj).k(obj, ISOChronology.getInstanceUTC());
    }
}
