package org.joda.time.base;

import java.io.Serializable;
import m20.d;
import org.joda.time.Chronology;
import org.joda.time.MutableInterval;
import org.joda.time.a;
import org.joda.time.b;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.e;
import org.joda.time.f;
import org.joda.time.g;
import org.joda.time.i;

public abstract class BaseInterval extends d implements Serializable {
    private static final long serialVersionUID = 576586928732749278L;
    private volatile Chronology iChronology;
    private volatile long iEndMillis;
    private volatile long iStartMillis;

    public BaseInterval(long j11, long j12, Chronology chronology) {
        this.iChronology = a.c(chronology);
        checkInterval(j11, j12);
        this.iStartMillis = j11;
        this.iEndMillis = j12;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public long getEndMillis() {
        return this.iEndMillis;
    }

    public long getStartMillis() {
        return this.iStartMillis;
    }

    public void setInterval(long j11, long j12, Chronology chronology) {
        checkInterval(j11, j12);
        this.iStartMillis = j11;
        this.iEndMillis = j12;
        this.iChronology = a.c(chronology);
    }

    public BaseInterval(f fVar, f fVar2) {
        if (fVar == null && fVar2 == null) {
            long b11 = a.b();
            this.iEndMillis = b11;
            this.iStartMillis = b11;
            this.iChronology = ISOChronology.getInstance();
            return;
        }
        this.iChronology = a.g(fVar);
        this.iStartMillis = a.h(fVar);
        this.iEndMillis = a.h(fVar2);
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(f fVar, e eVar) {
        this.iChronology = a.g(fVar);
        this.iStartMillis = a.h(fVar);
        this.iEndMillis = org.joda.time.field.e.e(this.iStartMillis, a.f(eVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(e eVar, f fVar) {
        this.iChronology = a.g(fVar);
        this.iEndMillis = a.h(fVar);
        this.iStartMillis = org.joda.time.field.e.e(this.iEndMillis, -a.f(eVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(f fVar, i iVar) {
        Chronology g11 = a.g(fVar);
        this.iChronology = g11;
        this.iStartMillis = a.h(fVar);
        if (iVar == null) {
            this.iEndMillis = this.iStartMillis;
        } else {
            this.iEndMillis = g11.add(iVar, this.iStartMillis, 1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(i iVar, f fVar) {
        Chronology g11 = a.g(fVar);
        this.iChronology = g11;
        this.iEndMillis = a.h(fVar);
        if (iVar == null) {
            this.iStartMillis = this.iEndMillis;
        } else {
            this.iStartMillis = g11.add(iVar, this.iEndMillis, -1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(Object obj, Chronology chronology) {
        n20.i d11 = n20.d.b().d(obj);
        if (d11.c(obj, chronology)) {
            g gVar = (g) obj;
            this.iChronology = chronology == null ? gVar.getChronology() : chronology;
            this.iStartMillis = gVar.getStartMillis();
            this.iEndMillis = gVar.getEndMillis();
        } else if (this instanceof b) {
            d11.j((b) this, obj, chronology);
        } else {
            MutableInterval mutableInterval = new MutableInterval();
            d11.j(mutableInterval, obj, chronology);
            this.iChronology = mutableInterval.getChronology();
            this.iStartMillis = mutableInterval.getStartMillis();
            this.iEndMillis = mutableInterval.getEndMillis();
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }
}
