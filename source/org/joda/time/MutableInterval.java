package org.joda.time;

import org.joda.time.base.BaseInterval;
import org.joda.time.field.e;

public class MutableInterval extends BaseInterval implements b, Cloneable {
    private static final long serialVersionUID = -5982824024992428470L;

    public MutableInterval() {
        super(0, 0, (Chronology) null);
    }

    public static MutableInterval parse(String str) {
        return new MutableInterval(str);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableInterval copy() {
        return (MutableInterval) clone();
    }

    public void setChronology(Chronology chronology) {
        super.setInterval(getStartMillis(), getEndMillis(), chronology);
    }

    public void setDurationAfterStart(long j11) {
        setEndMillis(e.e(getStartMillis(), j11));
    }

    public void setDurationBeforeEnd(long j11) {
        setStartMillis(e.e(getEndMillis(), -j11));
    }

    public void setEnd(f fVar) {
        super.setInterval(getStartMillis(), a.h(fVar), getChronology());
    }

    public void setEndMillis(long j11) {
        super.setInterval(getStartMillis(), j11, getChronology());
    }

    public void setInterval(long j11, long j12) {
        super.setInterval(j11, j12, getChronology());
    }

    public void setPeriodAfterStart(i iVar) {
        if (iVar == null) {
            setEndMillis(getStartMillis());
        } else {
            setEndMillis(getChronology().add(iVar, getStartMillis(), 1));
        }
    }

    public void setPeriodBeforeEnd(i iVar) {
        if (iVar == null) {
            setStartMillis(getEndMillis());
        } else {
            setStartMillis(getChronology().add(iVar, getEndMillis(), -1));
        }
    }

    public void setStart(f fVar) {
        super.setInterval(a.h(fVar), getEndMillis(), getChronology());
    }

    public void setStartMillis(long j11) {
        super.setInterval(j11, getEndMillis(), getChronology());
    }

    public MutableInterval(long j11, long j12) {
        super(j11, j12, (Chronology) null);
    }

    public void setDurationAfterStart(e eVar) {
        setEndMillis(e.e(getStartMillis(), a.f(eVar)));
    }

    public void setDurationBeforeEnd(e eVar) {
        setStartMillis(e.e(getEndMillis(), -a.f(eVar)));
    }

    public void setInterval(g gVar) {
        if (gVar != null) {
            super.setInterval(gVar.getStartMillis(), gVar.getEndMillis(), gVar.getChronology());
            return;
        }
        throw new IllegalArgumentException("Interval must not be null");
    }

    public MutableInterval(long j11, long j12, Chronology chronology) {
        super(j11, j12, chronology);
    }

    public MutableInterval(f fVar, f fVar2) {
        super(fVar, fVar2);
    }

    public MutableInterval(f fVar, e eVar) {
        super(fVar, eVar);
    }

    public MutableInterval(e eVar, f fVar) {
        super(eVar, fVar);
    }

    public MutableInterval(f fVar, i iVar) {
        super(fVar, iVar);
    }

    public void setInterval(f fVar, f fVar2) {
        if (fVar == null && fVar2 == null) {
            long b11 = a.b();
            setInterval(b11, b11);
            return;
        }
        super.setInterval(a.h(fVar), a.h(fVar2), a.g(fVar));
    }

    public MutableInterval(i iVar, f fVar) {
        super(iVar, fVar);
    }

    public MutableInterval(Object obj) {
        super(obj, (Chronology) null);
    }

    public MutableInterval(Object obj, Chronology chronology) {
        super(obj, chronology);
    }
}
