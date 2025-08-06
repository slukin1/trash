package org.joda.time;

import org.joda.time.base.BaseInterval;
import org.joda.time.chrono.ISOChronology;

public final class Interval extends BaseInterval {
    private static final long serialVersionUID = 4922451897541386752L;

    public Interval(long j11, long j12) {
        super(j11, j12, (Chronology) null);
    }

    public static Interval parse(String str) {
        return new Interval(str);
    }

    public boolean abuts(g gVar) {
        if (gVar == null) {
            long b11 = a.b();
            if (getStartMillis() == b11 || getEndMillis() == b11) {
                return true;
            }
            return false;
        } else if (gVar.getEndMillis() == getStartMillis() || getEndMillis() == gVar.getStartMillis()) {
            return true;
        } else {
            return false;
        }
    }

    public Interval gap(g gVar) {
        g l11 = a.l(gVar);
        long startMillis = l11.getStartMillis();
        long endMillis = l11.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        if (startMillis2 > endMillis) {
            return new Interval(endMillis, startMillis2, getChronology());
        }
        if (startMillis > endMillis2) {
            return new Interval(endMillis2, startMillis, getChronology());
        }
        return null;
    }

    public Interval overlap(g gVar) {
        g l11 = a.l(gVar);
        if (!overlaps(l11)) {
            return null;
        }
        return new Interval(Math.max(getStartMillis(), l11.getStartMillis()), Math.min(getEndMillis(), l11.getEndMillis()), getChronology());
    }

    public Interval toInterval() {
        return this;
    }

    public Interval withChronology(Chronology chronology) {
        if (getChronology() == chronology) {
            return this;
        }
        return new Interval(getStartMillis(), getEndMillis(), chronology);
    }

    public Interval withDurationAfterStart(e eVar) {
        long f11 = a.f(eVar);
        if (f11 == toDurationMillis()) {
            return this;
        }
        Chronology chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(startMillis, f11, 1), chronology);
    }

    public Interval withDurationBeforeEnd(e eVar) {
        long f11 = a.f(eVar);
        if (f11 == toDurationMillis()) {
            return this;
        }
        Chronology chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(endMillis, f11, -1), endMillis, chronology);
    }

    public Interval withEnd(f fVar) {
        return withEndMillis(a.h(fVar));
    }

    public Interval withEndMillis(long j11) {
        if (j11 == getEndMillis()) {
            return this;
        }
        return new Interval(getStartMillis(), j11, getChronology());
    }

    public Interval withPeriodAfterStart(i iVar) {
        if (iVar == null) {
            return withDurationAfterStart((e) null);
        }
        Chronology chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(iVar, startMillis, 1), chronology);
    }

    public Interval withPeriodBeforeEnd(i iVar) {
        if (iVar == null) {
            return withDurationBeforeEnd((e) null);
        }
        Chronology chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(iVar, endMillis, -1), endMillis, chronology);
    }

    public Interval withStart(f fVar) {
        return withStartMillis(a.h(fVar));
    }

    public Interval withStartMillis(long j11) {
        if (j11 == getStartMillis()) {
            return this;
        }
        return new Interval(j11, getEndMillis(), getChronology());
    }

    public Interval(long j11, long j12, DateTimeZone dateTimeZone) {
        super(j11, j12, ISOChronology.getInstance(dateTimeZone));
    }

    public Interval(long j11, long j12, Chronology chronology) {
        super(j11, j12, chronology);
    }

    public Interval(f fVar, f fVar2) {
        super(fVar, fVar2);
    }

    public Interval(f fVar, e eVar) {
        super(fVar, eVar);
    }

    public Interval(e eVar, f fVar) {
        super(eVar, fVar);
    }

    public Interval(f fVar, i iVar) {
        super(fVar, iVar);
    }

    public Interval(i iVar, f fVar) {
        super(iVar, fVar);
    }

    public Interval(Object obj) {
        super(obj, (Chronology) null);
    }

    public Interval(Object obj, Chronology chronology) {
        super(obj, chronology);
    }
}
