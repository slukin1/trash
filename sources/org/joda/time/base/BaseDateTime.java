package org.joda.time.base;

import java.io.Serializable;
import m20.a;
import n20.d;
import n20.h;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

public abstract class BaseDateTime extends a implements Serializable {
    private static final long serialVersionUID = -6728882245981L;
    private volatile Chronology iChronology;
    private volatile long iMillis;

    public BaseDateTime() {
        this(org.joda.time.a.b(), (Chronology) ISOChronology.getInstance());
    }

    public Chronology checkChronology(Chronology chronology) {
        return org.joda.time.a.c(chronology);
    }

    public long checkInstant(long j11, Chronology chronology) {
        return j11;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public long getMillis() {
        return this.iMillis;
    }

    public void setChronology(Chronology chronology) {
        this.iChronology = checkChronology(chronology);
    }

    public void setMillis(long j11) {
        this.iMillis = checkInstant(j11, this.iChronology);
    }

    public BaseDateTime(DateTimeZone dateTimeZone) {
        this(org.joda.time.a.b(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(Chronology chronology) {
        this(org.joda.time.a.b(), chronology);
    }

    public BaseDateTime(long j11) {
        this(j11, (Chronology) ISOChronology.getInstance());
    }

    public BaseDateTime(long j11, DateTimeZone dateTimeZone) {
        this(j11, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(long j11, Chronology chronology) {
        this.iChronology = checkChronology(chronology);
        this.iMillis = checkInstant(j11, this.iChronology);
        if (this.iChronology.year().isSupported()) {
            this.iChronology.year().set(this.iMillis, this.iChronology.year().get(this.iMillis));
        }
    }

    public BaseDateTime(Object obj, DateTimeZone dateTimeZone) {
        h c11 = d.b().c(obj);
        Chronology checkChronology = checkChronology(c11.b(obj, dateTimeZone));
        this.iChronology = checkChronology;
        this.iMillis = checkInstant(c11.k(obj, checkChronology), checkChronology);
    }

    public BaseDateTime(Object obj, Chronology chronology) {
        h c11 = d.b().c(obj);
        this.iChronology = checkChronology(c11.a(obj, chronology));
        this.iMillis = checkInstant(c11.k(obj, chronology), this.iChronology);
    }

    public BaseDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this(i11, i12, i13, i14, i15, i16, i17, (Chronology) ISOChronology.getInstance());
    }

    public BaseDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, DateTimeZone dateTimeZone) {
        this(i11, i12, i13, i14, i15, i16, i17, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17, Chronology chronology) {
        this.iChronology = checkChronology(chronology);
        this.iMillis = checkInstant(this.iChronology.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17), this.iChronology);
    }
}
